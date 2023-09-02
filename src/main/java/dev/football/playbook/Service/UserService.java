package dev.football.playbook.Service;

import dev.football.playbook.Entity.Users;

import java.util.List;
//extends UserDetailsService
public interface UserService  {

    public List<Users> findAll();
    public void saveUsers(Users user);
    public Users saveUsersFlush(Users user);
    public Users getUser(int id);
    public void UpdateUser(Users user);
    public void deleteUsers(int id);

   // public Users findUsersByCoachId(int id);
}
