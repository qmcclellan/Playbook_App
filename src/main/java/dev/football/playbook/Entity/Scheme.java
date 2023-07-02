package dev.football.playbook.Entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(schema="Playbook", name="Scheme")
public class Scheme {


    private enum SchemeType{}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;

    @Column(name="type")
    private SchemeType type;

    @Column(name="image")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name="playbook_id", nullable = false)
    private PlayBook playBook;

    @OneToMany(mappedBy = "scheme")
    private List <Play> plays;

    public Scheme() {
    }

    public Scheme(String name, SchemeType type, String imagePath, PlayBook playBook) {
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
        this.playBook = playBook;
    }

    public Scheme(Integer id, String name, SchemeType type, String imagePath, PlayBook playBook) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
        this.playBook = playBook;
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

    public SchemeType getType() {
        return type;
    }

    public void setType(SchemeType type) {
        this.type = type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public PlayBook getPlayBook() {
        return playBook;
    }

    public void setPlayBook(PlayBook playBook) {
        this.playBook = playBook;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    public void addPlay(Play ...newPlays){

            plays = Arrays.stream(newPlays).toList();

    }

    @Override
    public String toString() {
        return "Scheme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", imagePath='" + imagePath + '\'' +
                ", playBook=" + playBook +
                '}';
    }
}

