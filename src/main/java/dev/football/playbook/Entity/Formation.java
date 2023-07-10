package dev.football.playbook.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema="\"Playbook\"", name="\"formation\"")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "formation")
    private List<Scheme> schemes;

    @ManyToOne
    @JoinColumn(name = "playbook_id")
    PlayBook playBook;

    public Formation() {
    }

    public Formation(String name) {
        this.name = name;
    }

    public Formation(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Formation(String name, List<Scheme> schemes) {
        this.name = name;
        this.schemes = schemes;
    }

    public Formation(Integer id, String name, List<Scheme> schemes) {
        this.id = id;
        this.name = name;
        this.schemes = schemes;
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

    public List<Scheme> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<Scheme> schemes) {
        this.schemes = schemes;
    }


}
