package com.web.SE2.services;

import java.util.List;
import java.util.Optional;

import com.web.SE2.domains.Announcement;





public interface AnnouncementService {
	void deleteAnnouncement(Long id);
	void saveAnnouncement(Announcement a);
	Optional<Announcement> findAnnouncement(Long id);
	List<Announcement> findAllAnnouncements();
}
