package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDao extends JpaRepository<Team, Integer> {
}
