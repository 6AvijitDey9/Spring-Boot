package com.springrest.Springrst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.Springrst.entity.Course;
import com.springrest.Springrst.services.ServiceDemo;

@RestController
public class ControllerDemo {
	@Autowired
	private ServiceDemo sd;

	@GetMapping("/test")
	public List<Course> getCourses() {
		return this.sd.getCourses();
	}

	@GetMapping("/test/{cid}")
	public Course singleCourse(@PathVariable String cid) {
		return this.sd.singleCourse(Long.parseLong(cid));
	}

	@PostMapping("/test") // add
	public Course addCourse(@RequestBody Course obj) {
		return this.sd.addCourse(obj);
	}

	@PutMapping("/test") // update
	public Course updateCourse(@RequestBody Course obj) {
		return this.sd.updateCourse(obj);
	}

	@DeleteMapping("/test/{cid}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String cid) {
		try {
			this.sd.deleteCourse(Long.parseLong(cid));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
