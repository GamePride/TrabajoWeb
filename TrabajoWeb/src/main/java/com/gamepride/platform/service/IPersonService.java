package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

import com.gamepride.platform.model.Person;

public interface IPersonService extends ICrudService<Person>  {

	List<Person> fetchPersonByName(String name) throws Exception;

	Optional<Person> fetchByPersonIdWithLanCenters(Long id) throws Exception;
}
