package dev.football.playbook.Entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(schema="\"Playbook\"", name="\"playbook\"")
public class PlayBook {


    private enum PlaybookType{OFFENSE, DEFENSE}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name = "type")
    private PlaybookType type;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name="coach_id")
    private Coach coach;
    @Column(name="team")
    private String team;
    @Column(name="image")
    private String teamImagePath;

    @OneToMany(mappedBy = "playBook")
    private List <Scheme> schemes;


    public PlayBook() {
    }

    public PlayBook(String name, PlaybookType type, String team, String teamImagePath, Coach coach) {
        this.name = name;
        this.type = type;
        this.team = team;
        this.teamImagePath = teamImagePath;
        this.coach = coach;
    }

    public PlayBook(Integer id, String name, PlaybookType type, String team, String teamImagePath, Coach coach) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.team = team;
        this.teamImagePath = teamImagePath;
        this.coach = coach;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaybookType getType() {
        return type;
    }

    public void setType(PlaybookType type) {
        this.type = type;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamImagePath() {
        return teamImagePath;
    }

    public void setTeamImagePath(String teamImagePath) {
        this.teamImagePath = teamImagePath;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Scheme> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<Scheme> schemes) {
        this.schemes = schemes;
    }

    public void addSchemes(Scheme ...schemesToAdd){

        if(schemes == null){
            schemes = new ArrayList<>();
        }

        schemes = Arrays.asList(schemesToAdd);
    }

    @Override
    public String toString() {
        return "PlayBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", team='" + team + '\'' +
                ", teamImagePath='" + teamImagePath + '\'' +
                ", coach=" + coach +
                '}';
    }
}
