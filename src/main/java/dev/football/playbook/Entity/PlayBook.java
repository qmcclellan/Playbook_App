package dev.football.playbook.Entity;

public class PlayBook {

    private Integer id;
    private String name;
    private String team;
    private String teamImagePath;
    private Coach coach;

    public PlayBook() {
    }

    public PlayBook(String name, String team, String teamImagePath, Coach coach) {
        this.name = name;
        this.team = team;
        this.teamImagePath = teamImagePath;
        this.coach = coach;
    }

    public PlayBook(Integer id, String name, String team, String teamImagePath, Coach coach) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "PlayBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", teamImagePath='" + teamImagePath + '\'' +
                ", coach=" + coach +
                '}';
    }
}
