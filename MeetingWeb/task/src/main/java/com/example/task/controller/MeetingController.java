package com.example.task.controller;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.task.model.Meeting;
import com.example.task.service.MeetingService;



@Controller
public class MeetingController {

	private MeetingService meetingService;
	
	@Autowired
	public MeetingController(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
	@GetMapping
	public String index() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Meeting> meetingList  =  (List<Meeting>) meetingService.getMeeting();
		model.addAttribute("meetings", meetingList.isEmpty() ? Collections.EMPTY_LIST : meetingList);
		return "index";
	}
	
	@GetMapping("/addmeeting")
	public String ShowAddMeetingForm(Meeting meet) {
		return "add-meeting";
	}
	
	@PostMapping("/addmeeting")
	public String addMeeting(@Valid Meeting meet, BindingResult result, Model model) {
		if(result.hasErrors()){	
			return "add-meeting";
		}
		meetingService.createMeeting(meet);
		model.addAttribute("meetings", meetingService.getMeeting());
		return "redirect:/index";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateMeetingForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("meeting", meetingService.getMeetingByID(id).get());
		return "update-meeting";
	}
	
	@PutMapping("/update/{id}")
	public String updateMeeting(@PathVariable("id") Long id, @Valid Meeting meeting, BindingResult result, Model model) {
		if(result.hasErrors()) {
			meeting.setId(id);
			return "update-meeting";
		}
		meetingService.updateMeeting(id, meeting);
		model.addAttribute("meetings", meetingService.getMeeting());
		return "redirect:/index";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMeeting(@PathVariable("id") Long id, Model model) {
		meetingService.deleteMeeting(id);
		model.addAttribute("meetings", meetingService.getMeeting());
		return "redirect:/index";
	}
}
