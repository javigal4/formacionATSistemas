package com.jgb.formacionATSistemas.component.imp;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistemas.component.AnswerMapper;
import com.jgb.formacionATSistemas.component.QuestionMapper;
import com.jgb.formacionATSistemas.component.TagMapper;
import com.jgb.formacionATSistemas.dto.AnswerGetDTO;
import com.jgb.formacionATSistemas.dto.QuestionDTO;
import com.jgb.formacionATSistemas.dto.QuestionPostDTO;
import com.jgb.formacionATSistemas.dto.TagDTO;
import com.jgb.formacionATSistemas.model.Question;
import com.jgb.formacionATSistemas.model.Tag;
import com.jgb.formacionATSistemas.service.AnswerService;
import com.jgb.formacionATSistemas.service.QuestionService;
import com.jgb.formacionATSistemas.service.TagService;

import lombok.extern.java.Log;

@Log
@Component
public class QuestionMapperImp implements QuestionMapper {

	@Autowired
	public DozerBeanMapper dozer;

	@Autowired
	AnswerService answerService;

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerMapper answerMapper;

	@Autowired
	TagService tagService;

	@Autowired
	TagMapper tagMapper;

	@Override
	public Question dtoToModel(QuestionDTO dto) {
		
		log.info("Map Question: DTO to model");
		
		Question question = new Question();
		
		question.setIdQuestion(dto.getIdQuestion());
		question.setQuestion(dto.getQuestion());
		
		Optional<Tag> tag = tagService.findById(dto.getTagId());
		if (tag.isPresent())
			question.setTag(tag.get());
		
		//List<Answer> answers = dto.getAnswers().stream().map(a -> answerMapper.dtoToModel(a))
		//		.collect(Collectors.toList());
		
		//question.setAnswer(answers);
		return question;
	}
	
	@Override
	public Question dtoToModel(QuestionPostDTO dto) {
		
		log.info("Map Question: DTO de post to model");
		
		Question question = new Question();
		question.setQuestion(dto.getQuestion());
		
		Optional<Tag> tag = tagService.findById(dto.getTagId());
		question.setTag(tag.get());
		
		return question;
	}
	

	@Override
	public QuestionDTO modelToDto(Question model) {
		
		log.info("Map Question: model to DTO");
		
		QuestionDTO questionDTO = new QuestionDTO();
		
		questionDTO.setIdQuestion(model.getIdQuestion());
		questionDTO.setQuestion(model.getQuestion());
		
		//El model del post no puede consultar los getAnswer ni getTag, por lo que genera error
		
		if (!model.getAnswer().isEmpty())
		{
			List<AnswerGetDTO> answersGetDTO = answerMapper.modelToDto1(model.getAnswer());
			//Desordenar las respuestas
			Collections.shuffle(answersGetDTO);
			questionDTO.setAnswers(answersGetDTO);
		}

		if (model.getTag() != null) {
			TagDTO tagDTO = tagMapper.modelToDto(model.getTag());
			Integer tagInt = tagDTO.getIdTag();
			questionDTO.setTagId(tagInt);
		}

		return questionDTO;
	}

	@Override
	public List<Question> dtoToModel(List<QuestionDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> modelToDto(List<Question> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
