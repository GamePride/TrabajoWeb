package com.gamepride.platform.service;

import java.util.Optional;

public interface ICrudService<T> {
	
<<<<<<< HEAD

=======
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
	public int create(T t) throws Exception;
	
	public Optional<T> findById(Long id) throws Exception;
	
	public void deleteById(Long id) throws Exception;
}
