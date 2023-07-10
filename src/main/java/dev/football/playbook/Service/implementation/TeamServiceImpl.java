package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.TeamDao;
import dev.football.playbook.Entity.Team;
import dev.football.playbook.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;

    @Autowired
    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public void saveTeam(Team team) {
        teamDao.save(team);
    }

    @Override
    public Team saveTeamAndFlush(Team team) {
        return teamDao.saveAndFlush(team);
    }

    @Override
    public List<Team> saveTeamAndFlush(List<Team> teams) {
        return teamDao.saveAllAndFlush(teams);
    }

    @Override
    public Team getTeam(int id) {
        return teamDao.getReferenceById(id);
    }

    @Override
    public void deleteTeam(int id) {
        teamDao.deleteById(id);
    }
}
