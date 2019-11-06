package com.gamepride.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamepride.platform.model.LanCenter;

public interface ILanCenterRepository extends JpaRepository<LanCenter, Long> {
	
}
