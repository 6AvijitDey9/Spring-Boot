package com.springrest.Springrst.services;

import java.util.List;

import com.springrest.Springrst.entity.Course;

public interface ServiceDemo {
	public List<Course> getCourses();

	public Course singleCourse(long cid);

	public Course addCourse(Course obj);

	public Course updateCourse(Course obj);

	public void deleteCourse(long cid);
}
