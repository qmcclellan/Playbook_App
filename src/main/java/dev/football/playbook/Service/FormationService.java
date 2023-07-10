package dev.football.playbook.Service;

import dev.football.playbook.Entity.Formation;

import java.util.List;

public interface FormationService {

    public List<Formation> getAll();

    public void saveFormation(Formation formation);

    public Formation saveAndFlush(Formation formation);

    public void saveAll(List<Formation> formation);

    public List<Formation> saveAllAndFlush(List<Formation> formations);

    public Formation getFormation(int id);

    public void deleteFormation(int id);
}
