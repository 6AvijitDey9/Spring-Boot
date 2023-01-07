package com.springrest.Springrst.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.Springrst.Dao.Dao;
import com.springrest.Springrst.entity.Course;

@Service
public class ServiceImpl implements ServiceDemo {
 
	@Autowired
	private Dao dao;
//	List<Course> list;

	public ServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(111, "JavaCore", "this course contains basic java"));
//		list.add(new Course(222, "Python", "this course contains basic python"));
//		list.add(new Course(333, "C++", "this course contains basic c++"));
	}

	@Override
	public List<Course> getCourses() {
		return dao.findAll();
	}

	@Override
	public Course singleCourse(long cid) {
//		Course course = null;
//		for (Course c : list) {
//			if (c.getId() == cid) {
//				course = c;
//			}
//		}
		return dao.getOne(cid);
	}

	public Course addCourse(Course obj) {
//		list.add(obj);
		dao.save(obj);
		return obj;
	}

	public Course updateCourse(Course obj) {
//		list.forEach(up -> {
//			if (up.getId() == obj.getId()) {
//				up.setTitle(obj.getTitle());
//				up.setDescription(obj.getDescription());
//			}
//		});
		dao.save(obj);
		return obj;
	}

	public void deleteCourse(long cid) {
//		list = this.list.stream().filter(del -> del.getId() != cid).collect(Collectors.toList());
		Course del = dao.getOne(cid);
		dao.delete(del);
	}

}
