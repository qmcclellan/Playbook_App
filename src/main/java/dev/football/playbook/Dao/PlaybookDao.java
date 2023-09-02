package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Formation;
import dev.football.playbook.Entity.PlayBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaybookDao extends JpaRepository<PlayBook, Integer> {

    public List<PlayBook> findAllByType(String type);
    public List<PlayBook> findByCoachId(int id);


}
