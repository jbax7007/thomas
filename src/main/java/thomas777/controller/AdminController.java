package thomas777.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thomas777.domain.Tag;
import thomas777.domain.Video;
import thomas777.domain.VideoDetails;
import thomas777.service.TagService;
import thomas777.service.VideoDetailsService;
import thomas777.service.VideoService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.core.io.NumberInput.parseInt;

@Controller
public class AdminController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private TagService tagService;
    @Autowired
    private VideoDetailsService videoDetailsService;

    @RequestMapping("/admin")
    public String admin(Model model,
                        HttpSession session) {

        Object loggedOn = session.getAttribute("userID");
        if (loggedOn == null) {
            return "redirect:/error";
        }

        return "admin";
    }

    @RequestMapping("/newvideo")
    public String addVideo(Model model,
                        HttpSession session) {

        Object loggedOn = session.getAttribute("userID");
        if (loggedOn == null) {
            return "redirect:/error";
        }


        List<Tag> allHosts = tagService.findTagsByType("Host");
        model.addAttribute("allHosts", allHosts);

        List<Tag> allGuests = tagService.findTagsByType("Guest");
        model.addAttribute("allGuests", allGuests);

        List<Tag> allSubjects = tagService.findTagsByType("Subject");
        model.addAttribute("allSubjects", allSubjects);

        List<Tag> allSeries = tagService.findTagsByType("Series");
        model.addAttribute("allSeries", allSeries);

        return "newvideo";
    }

    @RequestMapping("/newtag")
    public String addTag(Model model,
                           HttpSession session) {

        Object loggedOn = session.getAttribute("userID");
        if (loggedOn == null) {
            return "redirect:/error";
        }


        List<Tag> allHosts = tagService.findTagsByType("Host");
        model.addAttribute("allHosts", allHosts);

        List<Tag> allGuests = tagService.findTagsByType("Guest");
        model.addAttribute("allGuests", allGuests);

        List<Tag> allSubjects = tagService.findTagsByType("Subject");
        model.addAttribute("allSubjects", allSubjects);

        List<Tag> allSeries = tagService.findTagsByType("Series");
        model.addAttribute("allSeries", allSeries);

        return "newtag";
    }


    @RequestMapping("/createVideo")
    public String createVideo(@RequestParam("title")String title,
                         @RequestParam("description")String description,
                         @RequestParam("link")String link,
                         @RequestParam("embedded")String embedded,
                         @RequestParam("date")String date,
                         @RequestParam(name = "tags", defaultValue = "") List<String> tags,
                         Model model,
                           HttpSession session) {

        Object loggedOn = session.getAttribute("userID");
        if (loggedOn == null) {
            return "redirect:/error";
        }


        Video newVideo = new Video();
        newVideo.setVideoTitle(title);
        newVideo.setVideoDescription(description);
        newVideo.setVideoLink(link);
        newVideo.setVideoEmbeddedLink(embedded);
        newVideo.setVideoDate(date);

        videoService.save(newVideo);

        long videoID = videoService.findVideoID(title);

        for(String tag : tags){

            VideoDetails videoDetails = new VideoDetails();
            videoDetails.setVideoID(videoID);
            videoDetails.setTagID(parseInt(tag));
            videoDetailsService.save(videoDetails);
        }

        return "admin";
    }

    @RequestMapping("/createTag")
    public String createTag(@RequestParam("name")String name,
                         @RequestParam("type")int type,
                         Model model,
                         HttpSession session) {
        Object loggedOn = session.getAttribute("userID");
        if (loggedOn == null) {
            return "redirect:/error";
        }
        Tag tag = new Tag();
        tag.setTagName(name);
        tag.setTagTypeID(type);

        tagService.save(tag);

        return "admin";
    }

}
