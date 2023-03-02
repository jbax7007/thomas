package thomas777.service;

import thomas777.domain.Announcement;

import java.util.List;

public interface AnnouncementService {
    long numberOfAnnouncements();
    List<Announcement> findAllAnnouncements();

    List<Announcement> findRecentAnnouncements(int n);

    void save(Announcement announcement);
}
