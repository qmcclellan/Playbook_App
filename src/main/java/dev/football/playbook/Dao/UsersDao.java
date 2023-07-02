package dev.football.playbook.Dao;

import dev.football.playbook.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {

    public Users findUsersByCoachId(int id);

    public Users findByUserName(String username);

}
