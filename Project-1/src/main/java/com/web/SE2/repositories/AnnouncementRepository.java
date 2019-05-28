package com.web.SE2.repositories;


import org.springframework.data.repository.CrudRepository;

import com.web.SE2.domains.Announcement;

public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
		
}
