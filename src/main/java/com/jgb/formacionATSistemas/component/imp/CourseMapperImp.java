package com.jgb.formacionATSistemas.component.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistemas.component.CourseMapper;
import com.jgb.formacionATSistemas.component.QuizMapper;
import com.jgb.formacionATSistemas.component.UserMapper;
import com.jgb.formacionATSistemas.dto.CourseDTO;
import com.jgb.formacionATSistemas.dto.QuizDTO;
import com.jgb.formacionATSistemas.dto.UserDTO;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.User;
import com.jgb.formacionATSistemas.service.CourseService;
import com.jgb.formacionATSistemas.service.QuizService;
import com.jgb.formacionATSistemas.service.UserService;

import lombok.extern.java.Log;

@Log
@Component
public class CourseMapperImp implements CourseMapper {

	@Autowired
	public DozerBeanMapper dozer;

	@Autowired
	UserService userService;

	@Autowired
	CourseService courseService;

	@Autowired
	QuizService quizService;

	@Autowired
	QuizMapper quizMapper;

	@Autowired
	UserMapper userMapper;

	@Override
	public Course dtoToModel(CourseDTO dto) {
		log.info("Map Course: DTO to model");
		
		Course course = dozer.map(dto, Course.class);
		
		List<Optional<User>> usersOpt = dto.getUsers().stream().map(u -> userService.findById(u))
				.collect(Collectors.toList());
		List<User> users = usersOpt.stream().map(Optional::get).collect(Collectors.toList());

		List<Optional<Quiz>> quizOpt = dto.getQuiz().stream().map(a -> quizService.findById(a))
				.collect(Collectors.toList());
		List<Quiz> answers = quizOpt.stream().map(Optional::get).collect(Collectors.toList());
		course.setQuiz(answers);
		course.setUser(users);
		
		return course;
	}

	@Override
	public CourseDTO modelToDto(Course model) {
		log.info("Map Course: model to DTO");
		List<User> users = courseService.findUserById(model.getIdCourse());

		List<UserDTO> usersDTO = userMapper.modelToDto(users);
		List<Integer> usersInt = usersDTO.stream().map(a -> a.getIdUser()).collect(Collectors.toList());

		List<Quiz> quiz = courseService.findQuizById(model.getIdCourse());

		List<QuizDTO> quizDTO = quizMapper.modelToDto(quiz);
		List<Integer> quizInt = quizDTO.stream().map(a -> a.getIdQuiz()).collect(Collectors.toList());

		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setIdCourse(model.getIdCourse());
		courseDTO.setCourse(model.getCourse());
		courseDTO.setQuiz(quizInt);
		courseDTO.setUsers(usersInt);
		return courseDTO;
	}

	@Override
	public List<Course> dtoToModel(List<CourseDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<CourseDTO> modelToDto(List<Course> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
