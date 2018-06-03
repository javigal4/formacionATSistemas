package com.jgb.formacionATSistemas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgb.formacionATSistemas.model.AnswerUser;

@Repository
public interface AnswerUserDAO extends PagingAndSortingRepository<AnswerUser, Integer>{

}
