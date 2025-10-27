package com.java.SpringBatchProcessing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Courses 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	private String courseName;
	private String instructor;
	private int duration;
	private double fee;
	@Version
	private Integer version;
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Courses(Long courseId, String courseName, String instructor, int duration, double fee, Integer version) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructor = instructor;
		this.duration = duration;
		this.fee = fee;
		this.version = version;
	}
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", instructor=" + instructor
				+ ", duration=" + duration + ", fee=" + fee + ", version=" + version + "]";
	}


	
}