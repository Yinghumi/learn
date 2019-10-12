package edu.hubu.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.HugherDao;
import edu.hubu.learn.entity.Hugher;
@Service
public class HugherService {

    @Autowired
    private HugherDao hugherDao;

    public Hugher getHugher(Long id) {
        return hugherDao.findById(id).get();
    }

    public List<Hugher> getHughers() {
        return hugherDao.findAll(new Sort(Direction.DESC, "id"));
    }

    public List<Hugher> searchHughers(String keyword) {
        Hugher hugher = new Hugher();
        hugher.setHughername(keyword);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("hughername", match->match.contains());
        Example<Hugher> example = Example.of(hugher, matcher);
        Sort sort = new Sort(Direction.DESC, "id");
        return hugherDao.findAll(example, sort);
    }

    public Hugher addHugher(Hugher hugher) {
        return hugherDao.save(hugher);
    }

    public void deleteHugher(Long id) {
        hugherDao.deleteById(id);
    }

    public void modifyHugher(Hugher hugher) {
        hugherDao.save(hugher);
    }
}