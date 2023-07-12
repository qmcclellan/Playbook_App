package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.SchemeDao;
import dev.football.playbook.Entity.Scheme;
import dev.football.playbook.Service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeServiceImpl implements SchemeService {

    private final SchemeDao schemeDao;

    @Autowired
    public SchemeServiceImpl(SchemeDao schemeDao) {
        this.schemeDao = schemeDao;
    }

    @Override
    public List<Scheme> findAll() {
        return schemeDao.findAll();
    }

    @Override
    public void saveScheme(Scheme scheme) {
        schemeDao.save(scheme);
    }

    @Override
    public Scheme saveAndFlush(Scheme scheme) {
        return schemeDao.saveAndFlush(scheme);
    }

    @Override
    public Scheme getScheme(int id) {
        return schemeDao.getReferenceById(id);
    }

    @Override
    public void updateScheme(Scheme scheme) {
        schemeDao.save(scheme);
    }

    @Override
    public void deleteScheme(int id) {
        schemeDao.deleteById(id);
    }

//    @Override
//    public List<Scheme> findAllByPlayBookId(int id) {
//        return schemeDao.findAllByPlayBookId(id);
//    }
//
//    @Override
//    public Scheme findByPlayId(int id) {
//        return schemeDao.findByPlayId(id);
//    }
}
