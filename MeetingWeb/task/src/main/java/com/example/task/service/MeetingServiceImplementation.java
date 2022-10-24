package com.example.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.model.Meeting;
import com.example.task.repository.MeetingRepository;

@Service
public class MeetingServiceImplementation implements MeetingService {

	private MeetingRepository meetingRepository;
	@Autowired
	public MeetingServiceImplementation(MeetingRepository meetingRepository) {
		super();
		this.meetingRepository = meetingRepository;
	}
	
	
	@Override
	public Meeting createMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		return meetingRepository.save(meeting);
	}


	@Override
	public void updateMeeting(long id, Meeting meeting) {
		// TODO Auto-generated method stub
		Optional<Meeting> optionalMeeting = meetingRepository.findById(id);
		if(optionalMeeting.isPresent()) {
			Meeting dbMeeting = optionalMeeting.get();
			dbMeeting.setName(meeting.getName());
			dbMeeting.setResponsibleperson(meeting.getResponsibleperson());
			dbMeeting.setDescription(meeting.getDescription());
			dbMeeting.setCategory(meeting.isCategory()); 
			dbMeeting.setLocation(meeting.isLocation());
			dbMeeting.setStartdateTime(meeting.getStartdateTime());
			dbMeeting.setEnddateTime(meeting.getEnddateTime());		
			meetingRepository.save(dbMeeting);
		}
	}

	@Override
	public Iterable<Meeting> getMeeting() {
		// TODO Auto-generated method stub
		return meetingRepository.findAll();
	}

	@Override
	public Optional<Meeting> getMeetingByID(long id) {
		// TODO Auto-generated method stub
		return meetingRepository.findById(id);
	}

	@Override
	public void deleteMeeting(long id) {
		// TODO Auto-generated method stub
		meetingRepository.deleteById(id);
	}

	
	
}
