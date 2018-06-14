package com.jgb.formacionATSistemas.component.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jgb.formacionATSistemas.component.AnswerUserMapper;
import com.jgb.formacionATSistemas.dto.AnswerUserDTO;
import com.jgb.formacionATSistemas.model.AnswerUser;
import com.jgb.formacionATSistemas.service.AnswerUserService;

@Component
public class AnswerUserMapperImp implements AnswerUserMapper {

	@Autowired
	public DozerBeanMapper dozer;
	
	@Autowired
	public AnswerUserService answerUserService;
	

	@Override
	public AnswerUser dtoToModel(AnswerUserDTO dto) {
		AnswerUser answerUser = new AnswerUser();
		answerUser.setIdAnswerUser(dto.getIdAnswerUser());
		answerUser.setAnswer(dto.getAnswer());
		
		if (dto.getIdQuestion() != null)
			answerUser.setQuestion(answerUserService.findQuestionByIdQuestion(dto.getIdQuestion()).get());
		
		if (dto.getIdQuiz() != null)
			answerUser.setQuiz(answerUserService.findQuizByIdQuiz(dto.getIdQuiz()).get());
		
		if (dto.getIdUser() != null)
			answerUser.setUser(answerUserService.findUserByIdUser(dto.getIdUser()).get());
		
		return answerUser;
	}

	@Override
	public AnswerUserDTO modelToDto(AnswerUser model) {
		
		AnswerUserDTO answerUserDTO = new AnswerUserDTO();
		answerUserDTO.setIdAnswerUser(model.getIdAnswerUser());
		answerUserDTO.setAnswer(model.getAnswer());
		
		if (model.getQuestion() != null)
			answerUserDTO.setIdQuestion(model.getQuestion().getIdQuestion());
		
		if (model.getQuiz() != null)
			answerUserDTO.setIdQuiz(model.getQuiz().getIdQuiz());
		
		if (model.getUser() != null)
			answerUserDTO.setIdUser(model.getUser().getIdUser());
		
		return answerUserDTO;	
	}
	
	@Override
	public List<AnswerUser> dtoToModel(List<AnswerUserDTO> dtos) {
		return dtos.stream().map(d -> dtoToModel(d)).collect(Collectors.toList());
	}

	@Override
	public List<AnswerUserDTO> modelToDto(List<AnswerUser> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
