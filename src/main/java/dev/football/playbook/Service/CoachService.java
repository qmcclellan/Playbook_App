package dev.football.playbook.Service;

import dev.football.playbook.Entity.Coach;

import java.util.List;

public interface CoachService {

    public List<Coach> findAll();
    public void saveCoach(Coach coach);
    public Coach saveCoachFlush(Coach coach);
    public Coach getCoach(int id);
    public void updateCoach(Coach coach);
    public void deleteCoach(int id);

    public Coach findCoachByUsersId(int id);
}
