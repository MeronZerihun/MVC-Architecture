package com.web.SE2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.SE2.domains.Announcement;
import com.web.SE2.repositories.AnnouncementRepository;


@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	
	
	AnnouncementRepository announcementRepository;
	@Autowired
	public AnnouncementServiceImpl(
			AnnouncementRepository announcementRepository) {
		this.announcementRepository=announcementRepository;
		
	}
	@Override
	public void deleteAnnouncement(Long id) {
		announcementRepository.deleteById(id);

	}

	@Override
	public void saveAnnouncement(Announcement a) {
		announcementRepository.save(a);

	}

	@Override
	public Optional<Announcement> findAnnouncement(Long id) {
		return announcementRepository.findById(id);
	}

	@Override
	public List<Announcement> findAllAnnouncements() {
		return (List<Announcement>) announcementRepository.findAll();
	}


}
