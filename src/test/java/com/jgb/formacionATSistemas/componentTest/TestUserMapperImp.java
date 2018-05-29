package com.jgb.formacionATSistemas.componentTest;

import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jgb.formacionATSistema.dto.UserDTO;
import com.jgb.formacionATSistemas.component.UserMapper;
import com.jgb.formacionATSistemas.component.UserMapperImp;
import com.jgb.formacionATSistemas.model.User;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TestUserMapperImp implements TestUserMapper{

	@InjectMocks
	UserMapper mapper = new UserMapperImp();
	
	@Mock
	DozerBeanMapper dozer;

	private static final String NAME = "Pepe";
	
	@Test
	public void testDtoToModel() {
		final UserDTO userDTO = new UserDTO();
		userDTO.setName(NAME );
		final User user = new User();
		Mockito.when(dozer.map(new UserDTO(), User.class)).thenReturn(user);
		final User res = mapper.dtoToModel(userDTO);
		Assert.assertEquals(NAME, res.getName());
	}

	@Override
	public UserDTO testModelToDto(User model) {
		return dozer.map(model, UserDTO.class);
	}

	@Override
	public Set<User> testDtoToModel(Set<UserDTO> users) {
		return users.stream().map(d -> mapper.dtoToModel(d)).collect(Collectors.toSet());
	}

	@Override
	public Set<UserDTO> testModelToDto(Set<User> models) {
		return models.stream().map(m -> mapper.modelToDto(m)).collect(Collectors.toSet());
	}

}
