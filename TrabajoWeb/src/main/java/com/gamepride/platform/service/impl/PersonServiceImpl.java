package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Person;
import com.gamepride.platform.repository.IPersonRepository;
import com.gamepride.platform.service.IPersonService;

/*@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepository personRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Person> findAll() throws Exception {
		return personRepository.findAll();
	}

	@Transactional
	@Override
	public Person save(Person p) throws Exception {
		return personRepository.save(p);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Person> findById(Long id) throws Exception {
		return personRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		personRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Person> fetchPersonByName(String name) throws Exception {
		return personRepository.fetchPersonByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Person> fetchByPersonIdWithLanCenters(Long id) throws Exception {
		return personRepository.fetchByPersonIdWithLanCenters(id);
	}
}*/