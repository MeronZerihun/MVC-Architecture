package com.web.SE2.controllers;




import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.SE2.domains.Announcement;
import com.web.SE2.services.AnnouncementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/announcement")
public class PostAnnouncementController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping
	@ModelAttribute
	public String announcement(Model model) {
		model.addAttribute("announcement", new Announcement());
		return "announcement";
	}
	
	
	@PostMapping(params="post")
	public String postAnnouncement(@Valid @ModelAttribute("announcement") Announcement announcement, Errors errors,HttpSession session,RedirectAttributes attribute) {
		
		if(errors.hasErrors()) {
			return "announcement";
		}
		
		announcementService.saveAnnouncement(announcement);
		log.info("Announcement saved");
		
	
		attribute.addFlashAttribute("success","Announcement has been added successfully");

		return "redirect:/announcement";
	}
	
	
	
}
