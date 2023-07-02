package dev.football.playbook.Service;

import dev.football.playbook.Entity.Scheme;

import java.util.List;

public interface SchemeService {

    public List<Scheme> findAll();
    public void saveScheme(Scheme scheme);
    public Scheme saveAndFlush(Scheme scheme);
    public Scheme getScheme(int id);
    public  void updateScheme(Scheme scheme);
    public void deleteScheme(int id);

    public List<Scheme> findAllByPlayBookId(int id);
    public Scheme findByPlayId(int id);
}
