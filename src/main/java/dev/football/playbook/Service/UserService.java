package dev.football.playbook.Service;

import dev.football.playbook.Entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<Users> findAll();
    public void saveUsers(Users user);
    public Users saveUsersFlush(Users user);
    public Users getUser(int id);
    public void UpdateUser(Users user);
    public void deleteUsers(int id);

    public Users findUsersByCoachId(int id);
}
