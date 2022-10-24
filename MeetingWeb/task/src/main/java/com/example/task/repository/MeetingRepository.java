package com.example.task.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.task.model.Meeting;


@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {

}
