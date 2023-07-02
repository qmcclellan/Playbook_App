package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users,Integer> {

    public Users findUsersByCoachId(int id);


}
