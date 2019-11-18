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
<<<<<<< HEAD:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterImpl.java
	


	@Override
	public List<LanCenter> fetchByLanCenterIdWithEvents(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEvents(id);
	}
=======
>>>>>>> César:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterServiceImpl.java

	@Transactional
	@Override
<<<<<<< HEAD:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterImpl.java
	public List<LanCenter> fetchLanCenterByName(String name) throws Exception {
		return lanCenterRepository.fetchLanCenterByName(name);
=======
	public int create(LanCenter l) throws Exception {
		int result=lanCenterRepository.countByName(l.getName());
		if(result==0)
		{
			lanCenterRepository.save(l);
		}
		return result;
>>>>>>> César:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterServiceImpl.java
	}

	@Transactional(readOnly = true)
	@Override
	public List<LanCenter> fetchByLanCenterIdWithEventsWithPeopleWithGamers(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEventsWithPeopleWithGamers(id);
	}

<<<<<<< HEAD:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterImpl.java
	@Autowired
	private ILanCenterRepository lancenterRepository;
	
	@Override
	@Transactional
	public int createLanCenter(LanCenter lancenter) {
		// TODO Auto-generated method stub
		int result = lancenterRepository.countByName(lancenter.getName());
		if(result == 0) {
			lancenterRepository.save(lancenter);
		}
		return result;
	}
/*
=======
	@Transactional
>>>>>>> César:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterServiceImpl.java
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

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = true)
	@Override
	@Transactional(readOnly = true)
	public Collection<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAllByOrderByNameDesc();
	}
*/

	@Transactional(readOnly = true)
	@Override
<<<<<<< HEAD:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterImpl.java
	public int updateLanCenter(Long id, LanCenter lancenter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLanCenter(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<LanCenter> getLanCenters() {
		// TODO Auto-generated method stub
		return null;
=======
	public List<LanCenter> fetchByLanCenterIdWithEventsWithGamers(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEventsWithGamers(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<LanCenter> getLanCenters() throws Exception {
		return lanCenterRepository.findAllByOrderByNameDesc();
>>>>>>> César:TrabajoWeb/src/main/java/com/gamepride/platform/service/impl/LanCenterServiceImpl.java
	}
}
