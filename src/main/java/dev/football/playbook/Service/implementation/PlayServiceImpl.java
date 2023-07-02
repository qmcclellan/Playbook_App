package dev.football.playbook.Service.implementation;

import dev.football.playbook.Dao.PlayDao;
import dev.football.playbook.Dao.PlaybookDao;
import dev.football.playbook.Entity.Play;
import dev.football.playbook.Entity.PlayBook;
import dev.football.playbook.Service.PlayService;
import dev.football.playbook.Service.PlaybookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayServiceImpl implements PlayService {

    private final PlayDao playDao;

    public PlayServiceImpl(PlayDao playDao) {
        this.playDao = playDao;
    }

    @Override
    public List<Play> findAll() {
        return playDao.findAll();
    }

    @Override
    public void savePlay(Play play) {
        playDao.save(play);
    }

    @Override
    public Play savePlayFlush(Play play) {
        return playDao.saveAndFlush(play);
    }

    @Override
    public Play getPlay(int id) {
        return playDao.getReferenceById(id);
    }

    @Override
    public void UpdatePlay(Play play) {
        playDao.save(play);
    }

    @Override
    public void deletePlay(int id) {
        playDao.deleteById(id);
    }

    @Override
    public Play findPlayBySchemeId(int id) {
        return playDao.findPlayBySchemeId(id);
    }

    @Override
    public List<Play> findAllBySchemeId(int id) {
        return playDao.findAllBySchemeId(id);
    }
}
