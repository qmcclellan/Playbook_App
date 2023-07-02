package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.PlaybookDao;
import dev.football.playbook.Entity.PlayBook;
import dev.football.playbook.Service.PlaybookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaybookServiceImpl implements PlaybookService {

    private final PlaybookDao playbookDao;

    @Autowired
    public PlaybookServiceImpl(PlaybookDao playbookDao) {
        this.playbookDao = playbookDao;
    }

    @Override
    public List<PlayBook> findAll() {
        return playbookDao.findAll();
    }

    @Override
    public void savePlayBook(PlayBook playbook) {
        playbookDao.save(playbook);
    }

    @Override
    public PlayBook saveAndFlush(PlayBook playbook) {
        return playbookDao.saveAndFlush(playbook);
    }

    @Override
    public PlayBook getPlayBook(int id) {
        return playbookDao.getReferenceById(id);
    }

    @Override
    public void UpdatePlaybook(PlayBook playbook) {
        playbookDao.save(playbook);
    }

    @Override
    public void deletePlayBook(int id) {
        playbookDao.deleteById(id);
    }

    @Override
    public List<PlayBook> findAllByType(String type) {
        return playbookDao.findAllByType(type);
    }

    @Override
    public List<PlayBook> findByCoachId(int id) {
        return playbookDao.findByCoachId(id);
    }
}
