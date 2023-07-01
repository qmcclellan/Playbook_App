package dev.football.playbook.Entity;

public class Coach {

    private enum CoachType{}

    private Integer id;
    private String name;
    private CoachType type;
    private Users user;
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
