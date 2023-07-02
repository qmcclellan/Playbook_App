package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchemeDao extends JpaRepository<Scheme,Integer> {

    public List<Scheme> findAllByPlayBookId(int id);
    public Scheme findByPlayId(int id);
}
