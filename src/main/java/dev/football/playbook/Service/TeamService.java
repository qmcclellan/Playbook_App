package dev.football.playbook.Service;

import dev.football.playbook.Entity.Team;

import java.util.List;

public interface TeamService {

    public List<Team> findAll();

    public void saveTeam(Team team);

    public Team saveTeamAndFlush(Team team);

    public List<Team> saveTeamAndFlush(List<Team> team);

    public Team getTeam(int id);

    public void deleteTeam(int id);



}
