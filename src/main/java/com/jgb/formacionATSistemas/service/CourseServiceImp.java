package com.jgb.formacionATSistemas.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jgb.formacionATSistemas.dao.CourseDAO;
import com.jgb.formacionATSistemas.model.Course;

@Service
public class CourseServiceImp implements CourseService {

	/**
	 * @Author = Javier Gallardo
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	CourseDAO courseDao;

	@Override
	public Course create(Course course) {
		return courseDao.save(course);
	}

	@Override
	public void update(Course course) {
		courseDao.save(course);
		
	}

	@Override
	public Optional<Course> findById(Integer id) {
		return courseDao.findById(id);
	}

	@Override
	public Set<Course> findAll(Pageable p) {
		return courseDao.findAll(PageRequest.of(p.getPageNumber(), p.getPageSize())).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Course course) {
		courseDao.delete(course);
	}
}
