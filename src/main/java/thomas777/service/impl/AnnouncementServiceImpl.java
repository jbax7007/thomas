package thomas777.service.impl;

import thomas777.dao.AnnouncementDao;
import thomas777.domain.Announcement;
import thomas777.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
@Service
public class AnnouncementServiceImpl implements AnnouncementService {


    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public void save(Announcement announcement) {
        announcementDao.save(announcement);
    }

    @Override
    public List<Announcement> findAllAnnouncements() {
        return announcementDao.findAll();
    }

    @Override
    public List<Announcement> findRecentAnnouncements(int n) {
        return announcementDao.findRecentAnnouncements(n);
    }
    @Override
    public long numberOfAnnouncements() {
        return announcementDao.count();
    }



}
