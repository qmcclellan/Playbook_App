package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.CoachDao;
import dev.football.playbook.Entity.Coach;
import dev.football.playbook.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachDao coachDao;

    @Autowired
    public CoachServiceImpl(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    @Override
    public List<Coach> findAll() {
        return coachDao.findAll();
    }

    @Override
    public void saveCoach(Coach coach) {
        coachDao.save(coach);
    }

    @Override
    public Coach saveCoachFlush(Coach coach) {
        return coachDao.saveAndFlush(coach);
    }

    @Override
    public Coach getCoach(int id) {
        return coachDao.getReferenceById(id);
    }

    @Override
    public void updateCoach(Coach coach) {
        coachDao.save(coach);
    }

    @Override
    public void deleteCoach(int id) {
        coachDao.deleteById(id);
    }

    @Override
    public Coach findCoachByUsersId(int id) {
        return coachDao.findCoachByUsersId(id);
    }
}
