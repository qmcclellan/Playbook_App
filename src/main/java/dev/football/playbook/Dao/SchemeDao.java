package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SchemeDao extends JpaRepository<Scheme,Integer> {

//    public List<Scheme> findAllByPlayBookId(int id);
//    public Scheme findByPlayId(int id);
}
