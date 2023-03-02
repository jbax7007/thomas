package thomas777.controller;

import org.springframework.web.servlet.view.RedirectView;
import thomas777.domain.Video;
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
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private TagService tagService;

    @RequestMapping("/content")
    public String showAllVideos(@RequestParam(name = "tag", defaultValue = "0") int videoTag,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                Model model){

        long perpage = 10;

        long vidCount = videoService.numberOfVideos();
        model.addAttribute("vidCount", vidCount);

        long tagCount = tagService.numberOfTags();
        model.addAttribute("tagCount", tagCount);

        if(videoTag == 0){
            model.addAttribute("message", "Showing all recent videos");
        }
        else{

            model.addAttribute("message", "Showing videos with " + tagService.findTagName(videoTag).replaceAll(","," as "));
        }

        model.addAttribute("page", page);
        model.addAttribute("tag",videoTag);
        long currentPage = page + 1;
        long numberOfPages = vidCount/perpage + 1;
        ArrayList<String> pages = new ArrayList<String>();


        for(int i = 1; i < numberOfPages; i++){
            pages.add(String.valueOf(i));
        }

        model.addAttribute("pages",pages);

        if(videoTag == 0){
            if(vidCount > 0){
                List<Video> allVideos = videoService.findAllVideos(page,perpage);
                model.addAttribute("allVideos", allVideos);
            }
        }
        else{
            List<Video> taggedVideos = videoService.findVideosByTag(videoTag,page,perpage);
            model.addAttribute("allVideos", taggedVideos);
        }

/*
        if(tagCount > 0){//tag tab
            List<Tag> allHosts = tagService.findTagsByType("Host");
            model.addAttribute("allHosts", allHosts);

            List<Tag> allGuests = tagService.findTagsByType("Guest");
            model.addAttribute("allGuests", allGuests);

            List<Tag> allSubjects = tagService.findTagsByType("Subject");
            model.addAttribute("allSubjects", allSubjects);

            List<Tag> allSeries = tagService.findTagsByType("Series");
            model.addAttribute("allSeries", allSeries);
        }
*/

        List<Tag> allHosts = tagService.findTagsByTypeTo(1,5);
        model.addAttribute("allHosts", allHosts);

        List<Tag> allGuests = tagService.findTagsByTypeTo(2,5);
        model.addAttribute("allGuests", allGuests);

        List<Tag> allSubjects = tagService.findTagsByTypeTo(3,5);
        model.addAttribute("allSubjects", allSubjects);

        List<Tag> allSeries = tagService.findTagsByTypeTo(4,5);
        model.addAttribute("allSeries", allSeries);



        return "content";

    }




}
