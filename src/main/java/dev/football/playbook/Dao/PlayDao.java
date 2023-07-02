package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayDao extends JpaRepository<Play, Integer> {

    public Play findPlayBySchemeId(int id);
    public List<Play> findAllBySchemeId(int id);


}
