package thomas777.controller;

import org.springframework.web.servlet.view.RedirectView;
import thomas777.domain.Announcement;
import thomas777.domain.Video;
import thomas777.service.AnnouncementService;
import thomas777.service.TagService;
import thomas777.service.VideoService;

import thomas777.domain.Tag;
import thomas777.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class IndexController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping("/index")
    public String displayHome(Model model){


        List<Announcement> announcements = announcementService.findRecentAnnouncements(2);
        model.addAttribute("announcements", announcements);

        List<Video> videos = videoService.findRecentVideos(2);
        model.addAttribute("videos", videos);


        return "index";
    }

}
