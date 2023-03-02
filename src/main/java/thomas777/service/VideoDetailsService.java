package thomas777.service;

import thomas777.domain.VideoDetails;

import java.util.List;

public interface VideoDetailsService {
    long numberOfVideoDetails();
    List<VideoDetails> findAllVideoDetails();

    void save(VideoDetails videoDetails);
}
