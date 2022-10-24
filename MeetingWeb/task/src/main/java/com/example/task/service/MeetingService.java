package com.example.task.service;

import java.util.Optional;

import com.example.task.model.Meeting;

public interface MeetingService {

	Meeting createMeeting(Meeting meeting);
	
	void updateMeeting(long id, Meeting meeting);
	
	Iterable<Meeting> getMeeting();
	
	Optional<Meeting> getMeetingByID(long id);
	
	void deleteMeeting(long id);
}
