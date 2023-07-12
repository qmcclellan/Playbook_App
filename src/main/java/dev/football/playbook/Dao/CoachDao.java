package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachDao extends JpaRepository<Coach,Integer> {

  //  public Coach findCoachByUsersId(int id);

}
