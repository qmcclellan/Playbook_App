package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.FormationDao;
import dev.football.playbook.Entity.Formation;
import dev.football.playbook.Entity.PlayBook;
import dev.football.playbook.Service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FormationServiceImpl implements FormationService {

    private FormationDao formationDao;

    @Autowired
    public FormationServiceImpl(FormationDao formationDao) {
        this.formationDao = formationDao;
    }

    @Override
    public List<Formation> getAll() {
        return formationDao.findAll();
    }

    @Override
    public void saveFormation(Formation formation) {

        formationDao.save(formation);
    }

    @Override
    public Formation saveAndFlush(Formation formation) {
        return formationDao.saveAndFlush(formation);
    }

    @Override
    public void saveAll(List<Formation> formations) {
        formationDao.saveAll(formations);
    }

    @Override
    public List<Formation> saveAllAndFlush(List<Formation> formations) {
        return formationDao.saveAllAndFlush(formations);
    }

    @Override
    public Formation getFormation(int id) {
        return formationDao.getReferenceById(id);
    }

    @Override
    public void deleteFormation(int id) {

        formationDao.deleteById(id);

    }

    public List<Formation> findAllByPlayBook(PlayBook playBook){

        List<Formation> formations = formationDao.findAllByPlayBook(playBook);

        return formations;
    }
}
