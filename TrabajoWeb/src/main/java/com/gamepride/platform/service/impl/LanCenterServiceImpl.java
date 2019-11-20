package com.gamepride.platform.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.LanCenter;
import com.gamepride.platform.repository.ILanCenterRepository;
import com.gamepride.platform.service.ILanCenterService;

@Service
public class LanCenterServiceImpl implements ILanCenterService {

	@Autowired
	private ILanCenterRepository lanCenterRepository;
	
	
	@Transactional
	@Override
	public int create(LanCenter lc)throws Exception {
		int result = lanCenterRepository.countByName(lc.getName());
		if(result == 0) {
			lanCenterRepository.save(lc);
		}
		return result;
	}
	
	@Transactional(readOnly=true)
	@Override
	public Optional<LanCenter> findById(Long id)throws Exception{
		return lanCenterRepository.findById(id);
	}
	
	@Transactional
	@Override
	public void deleteById(Long id)throws Exception{
		lanCenterRepository.deleteById(id);
	}
/*
	@Override
	@Transactional
	public int updateCategory(Long id, Category category) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Category> originalCategory = categoryRepository.findById(id);
		
		result = originalCategory.isPresent() ? 0 : -1;
		Category updatedCategory = originalCategory.get();
		updatedCategory.setName(category.getName());
		categoryRepository.save(updatedCategory);
		return result;
		
	}

	@Override
	@Transactional
	public int deleteCategory(Long id) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Category> category = categoryRepository.findById(id);
		category.ifPresent(c -> categoryRepository.delete(c));
		result = category.isPresent() ? 0 : -1;
		return result;
	}
*/
	
	@Transactional(readOnly=true)
	@Override
	public Optional<LanCenter> fetchByLanCenterIdWithEvents(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEvents(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<LanCenter> findByName(String name) throws Exception {
		return lanCenterRepository.findByName(name);
	}
	
	@Transactional(readOnly = true)
	@Override	
	public Collection<LanCenter> getLanCenters()throws Exception{
		return lanCenterRepository.findAllByOrderByNameDesc();
	}
	
}
