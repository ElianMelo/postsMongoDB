package com.iftm.postsMongoDB.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.postsMongoDB.repositories.UserRepository;
import com.iftm.postsMongoDB.service.exceptions.ResourceNotFoundException;
import com.iftm.postsMongoDB.models.entities.User;
import com.iftm.postsMongoDB.models.dto.PostDTO;
import com.iftm.postsMongoDB.models.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO findById(String id) {
		User entity = getEntityById(id);
		return new UserDTO(entity);
	}
	
	private User getEntityById(String id) {
		Optional<User> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
	}
	
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		return new UserDTO(repository.insert(entity));
	}
	
	public UserDTO update(String id, UserDTO dto) {
		User entity = getEntityById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	public void delete(String id) {
		User entity = getEntityById(id);
		repository.delete(entity);
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
	}
	
	public List<PostDTO> getUserPosts(String id) {
		User entity = getEntityById(id);
		return entity.getPosts().stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}

}
