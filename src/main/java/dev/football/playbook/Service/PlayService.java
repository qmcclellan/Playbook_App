package dev.football.playbook.Service;

import dev.football.playbook.Entity.Play;

import java.util.List;

public interface PlayService {

    public List<Play> findAll();
    public void savePlay(Play play);
    public Play savePlayFlush(Play play);
    public Play getPlay(int id);
    public void UpdatePlay(Play play);
    public void deletePlay(int id);

    public Play findPlayBySchemeId(int id);
    public List<Play> findAllBySchemeId(int id);
}
