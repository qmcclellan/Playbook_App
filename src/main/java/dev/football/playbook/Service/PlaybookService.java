package dev.football.playbook.Service;

import dev.football.playbook.Entity.PlayBook;

import java.util.List;

public interface PlaybookService {

    public List<PlayBook> findAll();
    public void savePlayBook(PlayBook playbook);
    public PlayBook saveAndFlush(PlayBook playbook);
    public PlayBook getPlayBook(int id);
    public void UpdatePlaybook(PlayBook playbook);
    public void deletePlayBook(int id);

    public List<PlayBook> findAllByType(String type);
    public List<PlayBook> findByCoachId(int id);

    public void saveAll(List<PlayBook> playBooks);
}
