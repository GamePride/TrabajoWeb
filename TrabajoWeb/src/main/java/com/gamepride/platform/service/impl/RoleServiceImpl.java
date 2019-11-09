package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Role;
import com.gamepride.platform.repository.IRoleRepository;
import com.gamepride.platform.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Role> findAll() throws Exception {
		return roleRepository.findAll();
	}

	@Transactional
	@Override
	public Role save(Role r) throws Exception {
		return roleRepository.save(r);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Role> findById(Long id) throws Exception {
		return roleRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		roleRepository.deleteById(id);
	}
}
