package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.UsersDao;
import dev.football.playbook.Entity.Users;
import dev.football.playbook.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UserService {

    private final UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<Users> findAll() {
        return usersDao.findAll();
    }

    @Override
    public void saveUsers(Users user) {
        usersDao.save(user);
    }

    @Override
    public Users saveUsersFlush(Users user) {
        return usersDao.saveAndFlush(user);
    }

    @Override
    public Users getUser(int id) {
        return usersDao.getReferenceById(id);
    }

    @Override
    public void UpdateUser(Users user) {
        usersDao.save(user);
    }

    @Override
    public void deleteUsers(int id) {
        usersDao.deleteById(id);
    }

//    @Override
//    public Users findUsersByCoachId(int id) {
//        return usersDao.findUsersByCoachId(id);
//    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Users user = findByUserName(username);
//        if (user == null) {
//
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//
//        List<GrantedAuthority>authorities = new ArrayList<>();
//
//        authorities.add(new SimpleGrantedAuthority(user.getRoles().toString()));
//
//        return new User(user.getUserName(), user.getPassword().trim(), authorities); //removed .trim()
//    }

    private Users findByUserName(String username) {

        return usersDao.findByUserName(username);
    }
}
