package dev.football.playbook.Entity;

import jakarta.persistence.*;

import java.util.Collection;
@Entity
@Table(schema="\"Playbook\"", name="\"user\"")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="pass")
    private String password;

    @Column(name="enabled")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "\"users_roles\"", schema = "\"Banking\"",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public Users() {
    }

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Users(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Users(String name, String password, Boolean enabled) {
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }

    public Users(Integer id, String name, String password, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
