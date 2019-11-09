package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
	public List<T> findAll() throws Exception;
	public T save(T entity) throws Exception;
	public Optional <T> findById (Long id) throws Exception;
	public void deleteById(Long id)throws Exception;

}