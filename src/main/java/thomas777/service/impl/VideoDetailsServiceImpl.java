package thomas777.service.impl;

import thomas777.dao.VideoDetailsDao;
import thomas777.domain.VideoDetails;
import thomas777.service.VideoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoDetailsServiceImpl implements VideoDetailsService {


    @Autowired
    private VideoDetailsDao videoDetailsDao;

    @Override
    public void save(VideoDetails videoDetails) {
        videoDetailsDao.save(videoDetails);
    }

    @Override
    public List<VideoDetails> findAllVideoDetails() {
        return videoDetailsDao.findAll();
    }

    @Override
    public long numberOfVideoDetails() {
        return videoDetailsDao.count();
    }

}