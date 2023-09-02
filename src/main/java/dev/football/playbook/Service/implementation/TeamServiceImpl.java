package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.TeamDao;
import dev.football.playbook.Entity.Team;
import dev.football.playbook.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;

    @Autowired
    public TeamServiceImpl(TeamDao teamDao) {

        this.teamDao = teamDao;
    }

    @Override
    public List<Team> findAll() {
        return null;
    }

    @Override
    public void saveTeam(Team team) {

    }

    @Override
    public Team saveTeamAndFlush(Team team) {
        return teamDao.saveAndFlush(team);
    }

    @Override
    public List<Team> saveTeamAndFlush(List<Team> team) {
        return null;
    }

    @Override
    public Team getTeam(int id) {
        return null;
    }

    @Override
    public void deleteTeam(int id) {

    }
}