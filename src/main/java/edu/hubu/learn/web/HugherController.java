package edu.hubu.learn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.Hugher;
import edu.hubu.learn.service.HugherService;

@Controller
@RequestMapping("/hugher")
public class HugherController {


    @Autowired
    private HugherService hugherService;


    @RequestMapping("/{id}")
    public ModelAndView hugher(@PathVariable long id) {
        ModelAndView mav = new ModelAndView();
        Hugher hugher = hugherService.getHugher(id);
        mav.addObject("hugher",hugher);
        mav.setViewName("hugher");
        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView hughers() {
        ModelAndView mav = new ModelAndView();
        List<Hugher> hughers = hugherService.getHughers();
        mav.addObject("hughers", hughers);
        mav.setViewName("hughers");
        return mav;
    }

}