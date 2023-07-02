package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayDao extends JpaRepository<Play, Integer> {

    public Play findPlayBySchemeId(int id);
    public List<Play> findAllBySchemeId(int id);


}
