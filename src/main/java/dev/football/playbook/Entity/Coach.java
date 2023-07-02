package dev.football.playbook.Entity;

import jakarta.persistence.*;

@Entity
@Table(schema="\"Playbook\"", name="\"Coach\"")
public class Coach {

    private enum CoachType{HEAD, ASSISTANT, OFFENSE, DEFENSE,SPECIAL_TEAMS, }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private CoachType type;

    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Users user;
    @Column(name="image")
    private String imagePath;

    public Coach() {
    }

    public Coach(String name, CoachType type, Users user) {
        this.name = name;
        this.type = type;
        this.user = user;
    }

    public Coach(Integer id, String name, CoachType type, Users user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.user = user;
    }

    public Coach(String name, CoachType type, Users user, String imagePath) {
        this.name = name;
        this.type = type;
        this.user = user;
        this.imagePath = imagePath;
    }

    public Coach(Integer id, String name, CoachType type, Users user, String imagePath) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.user = user;
        this.imagePath = imagePath;
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

    public CoachType getType() {
        return type;
    }

    public void setType(CoachType type) {
        this.type = type;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", user=" + user +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
