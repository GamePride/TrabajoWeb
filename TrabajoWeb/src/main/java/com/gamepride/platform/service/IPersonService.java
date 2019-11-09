package com.gamepride.platform.service;


import java.util.List;

import com.gamepride.platform.model.Person;

public interface IPersonService extends ICrudService<Person>  {

	List<Person> fetchPersonById(Long id) throws Exception;

}
