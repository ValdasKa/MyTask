package com.example.task.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor

public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Meeting name is required")
	private String name;
	@NotEmpty(message = "Meeting responsible person name is required")
	private String responsibleperson;
	@NotEmpty(message = "Meeting description is required")
	private String description;
	private boolean category = true;
	private boolean location = true;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDate startdateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDate enddateTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResponsibleperson() {
		return responsibleperson;
	}
	public void setResponsibleperson(String responsibleperson) {
		this.responsibleperson = responsibleperson;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStartdateTime() {
		return startdateTime;
	}
	public void setStartdateTime(LocalDate startdateTime) {
		this.startdateTime = startdateTime;
	}
	public LocalDate getEnddateTime() {
		return enddateTime;
	}
	public void setEnddateTime(LocalDate enddateTime) {
		this.enddateTime = enddateTime;
	}
	
	public boolean isLocation() {
		return location;
	}
	public void setLocation(boolean location) {
		this.location = location;
	}
	public boolean isCategory() {
		return category;
	}
	public void setCategory(boolean category) {
		this.category = category;
	}
	
}
