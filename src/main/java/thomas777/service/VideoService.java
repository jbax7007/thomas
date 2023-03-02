package thomas777.service;

import thomas777.domain.Video;

import java.util.List;

public interface VideoService {
    long numberOfVideos();
    List<Video> findAllVideos(long page,long perpage);

    List<Video> findVideosByTag(long tagID,long page,long perpage);

    List<Video> findRecentVideos(long n);

    long findVideoID(String Title);

    void save(Video video);
}
