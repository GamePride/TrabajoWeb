package com.gamepride.platform.Service;

import java.util.List;

import com.gamepride.platform.model.Person;

public interface PersonService extends CrudService<Person>  {

	List<Person> fetchPersonById(Long id) throws Exception;

}