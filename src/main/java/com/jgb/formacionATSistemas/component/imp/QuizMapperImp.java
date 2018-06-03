package com.jgb.formacionATSistemas.component.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistemas.component.QuestionMapper;
import com.jgb.formacionATSistemas.component.QuizMapper;
import com.jgb.formacionATSistemas.component.TagMapper;
import com.jgb.formacionATSistemas.dto.QuestionDTO;
import com.jgb.formacionATSistemas.dto.QuizDTO;
import com.jgb.formacionATSistemas.dto.TagDTO;
import com.jgb.formacionATSistemas.model.Course;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Quiz;
import com.jgb.formacionATSistemas.model.Tag;
import com.jgb.formacionATSistemas.service.CourseService;
import com.jgb.formacionATSistemas.service.QuizService;

import lombok.extern.java.Log;

@Log
@Component
public class QuizMapperImp implements QuizMapper {

	@Autowired
	public DozerBeanMapper dozer;

	@Autowired
	public QuizService quizService;
	
	@Autowired
	public CourseService courseService;

	@Autowired
	public QuestionMapper questionMapper;

	@Autowired
	public TagMapper tagMapper;

	@Override
	public Quiz dtoToModel(QuizDTO dto) {
		log.info("Map Quiz: DTO to model");
		
		
		//EL dozer da fallo
		Quiz quiz = new Quiz();
		quiz.setIdQuiz(dto.getIdQuiz());
		quiz.setQuiz(dto.getQuiz());
		quiz.setRand(dto.getRand());
		
		Optional<Course> courseOpt = courseService.findById(dto.getCourse());
		
		if (courseOpt.isPresent())
			quiz.setCourse(courseOpt.get());
		
		return quiz;
	}

	@Override
	public QuizDTO modelToDto(Quiz model) {
		log.info("Map Quiz: model to DTO");
		
		QuizDTO quizDTO = dozer.map(model, QuizDTO.class);
		
		quizDTO.setQuiz(model.getQuiz());

		if (!model.getQuestion().isEmpty())
		{
			List<Question> questions = quizService.findQuestionByQuiz(model);
			List<QuestionDTO> questionDTO = questionMapper.modelToDto(questions);
			List<Integer> questionInt = questionDTO.stream().map(a -> a.getIdQuestion()).collect(Collectors.toList());
			
			quizDTO.setQuestions(questionInt);
		}
		
		if (!model.getTag().isEmpty())
		{
			List<Tag> tags = quizService.findTagByQuiz(model);
			List<TagDTO> tagsDTO = tagMapper.modelToDto(tags);
			List<Integer> tagInt = tagsDTO.stream().map(t -> t.getIdTag()).collect(Collectors.toList());
	
			quizDTO.setTags(tagInt);
		}
		return quizDTO;
	}

	@Override
	public List<Quiz> dtoToModel(List<QuizDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<QuizDTO> modelToDto(List<Quiz> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
