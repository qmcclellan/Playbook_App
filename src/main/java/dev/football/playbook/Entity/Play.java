package dev.football.playbook.Entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "\"Playbook\"", name = "\"play\"")
public class Play {

    //    private enum PlayType{PASS, RUN, RPO, KICK, PUNT, FAKE_KICK,
//    FAKE_PUNT, BLITZ, QB_CONTAIN, MAN,ZONE}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "pros")
    private String pros;

    @Column(name = "cons")
    private String cons;

    @Column(name = "image")
    private String imagePath;

    @Column(name="play_type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "play_id", nullable = false)
    private Scheme scheme;

    public Play() {
    }

    public Play(String name, String pros, String cons, String imagePath) {
        this.name = name;
        this.pros = pros;
        this.cons = cons;
        this.imagePath = imagePath;
    }

    public Play(Integer id, String name, String pros, String cons, String imagePath) {
        this.id = id;
        this.name = name;
        this.pros = pros;
        this.cons = cons;
        this.imagePath = imagePath;
    }

    public Play(String name, String pros, String cons, String imagePath, String type, Scheme scheme) {
        this.name = name;
        this.pros = pros;
        this.cons = cons;
        this.imagePath = imagePath;
        this.type = type;
        this.scheme = scheme;
    }

    public Play(Integer id, String name, String pros, String cons, String imagePath, String type, Scheme scheme) {
        this.id = id;
        this.name = name;
        this.pros = pros;
        this.cons = cons;
        this.imagePath = imagePath;
        this.type = type;
        this.scheme = scheme;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
                ", type='" + type + '\'' +
                '}';
    }
}
