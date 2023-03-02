package thomas777.service.impl;

import thomas777.dao.VideoDao;
import thomas777.domain.Video;
import thomas777.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private VideoDao videoDao;

    @Override
    public void save(Video video) {
        videoDao.save(video);
    }

    @Override
    public List<Video> findAllVideos(long page,long perpage) {
        return videoDao.findAllVideos(page,perpage);
    }

    @Override
    public long numberOfVideos() {
        return videoDao.count();
    }

    @Override
    public List<Video> findVideosByTag(long tag, long page,long perpage){return videoDao.findVideosByTag(tag,page,perpage);}

    @Override
    public long findVideoID(String title){return videoDao.findVideoID(title);}

    @Override
    public List<Video> findRecentVideos(long n){return videoDao.findRecentVideos(n);}

}