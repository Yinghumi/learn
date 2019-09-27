package edu.hubu.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
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
}