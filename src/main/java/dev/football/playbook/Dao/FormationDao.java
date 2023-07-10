package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationDao extends JpaRepository<Formation,Integer> {
}
