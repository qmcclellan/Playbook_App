package dev.football.playbook.Entity;

public class Play {

    private enum PlayType{}

    private Integer id;
    private String name;
    private String pros;
    private String cons;
    private String imagePath;
    private PlayType type;
    private Scheme scheme;

    public Play() {
    }

    public Play(String name, String pros, String cons, String imagePath, PlayType type, Scheme scheme) {
        this.name = name;
        this.pros = pros;
        this.cons = cons;
        this.imagePath = imagePath;
        this.type = type;
        this.scheme = scheme;
    }

    public Play(Integer id, String name, String pros, String cons, String imagePath, PlayType type) {
        this.id = id;
        this.name = name;
        this.pros = pros;
        this.cons = cons;
        this.imagePath = imagePath;
        this.type = type;
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

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public PlayType getType() {
        return type;
    }

    public void setType(PlayType type) {
        this.type = type;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    @Override
    public String toString() {
        return "Play{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pros='" + pros + '\'' +
                ", cons='" + cons + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", type=" + type +
                ", scheme=" + scheme +
                '}';
    }
}
