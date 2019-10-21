package edu.hubu.learn.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.Hugher;
import edu.hubu.learn.service.HugherService;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
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

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        hugherService.deleteHugher(id);
        ModelAndView mav = new ModelAndView("redirect:/hugher/list");
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

    @RequestMapping("/add")
    public ModelAndView addHugher() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hugher_add");
        return mav;
    }

    @RequestMapping("/do_add")
    public ModelAndView doAddHugher(Hugher hugher) {
        hugher.setAvatar("");
        hugherService.addHugher(hugher);
        ModelAndView mav = new ModelAndView("redirect:/hugher/list");
        return mav;
    }

    @RequestMapping("/modify/{id}")
    public ModelAndView modifyHugher(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hugher", hugherService.getHugher(id));
        mav.setViewName("hugher_modify");
        return mav;
    }

    @RequestMapping("/do_modify")
    public ModelAndView doModifyHugher(Hugher hugher) {
        hugher.setAvatar("");
        hugherService.modifyHugher(hugher);
        ModelAndView mav = new ModelAndView("redirect:/hugher/list");
        return mav;
    }

    @RequestMapping("/search")
    public ModelAndView searchHugher() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hugher_search");
        return mav;
    }

    @RequestMapping("/do_search")
    public ModelAndView doSearchHugher(HttpServletRequest httpRequest) {
        ModelAndView mav = new ModelAndView();
        String keyword = httpRequest.getParameter("keyword");
        List<Hugher> hughers = hugherService.searchhughers(keyword);
        mav.addObject("hughers", hughers);
        mav.setViewName("hughers");
        return mav;
    }

    @RequestMapping("/add_avatar/{id}")
    public ModelAndView addHugherAvatar(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hugher", hugherService.getHugher(id));
        mav.setViewName("hugher_add_avatar");
        return mav;
    }

    @RequestMapping("/do_add_avatar/{id}")
    public ModelAndView doAddHugherAvatar(@RequestParam("avatar") MultipartFile file, @PathVariable Long id) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = ResourceUtils.getURL("classpath:").getPath() + "../../../resources/main/static/";
            log.info(filePath, fileName);
            File dest = new File(filePath + fileName);
            log.info(dest.getAbsolutePath());
            file.transferTo(dest);
            Hugher hugher = hugherService.getHugher(id);
            hugher.setAvatar(fileName);
            hugherService.modifyHugher(hugher);
        } catch (Exception e) {
            log.error("upload avatar error", e.getMessage());
        }
        return new ModelAndView("redirect:/hugher/list");
    }

}