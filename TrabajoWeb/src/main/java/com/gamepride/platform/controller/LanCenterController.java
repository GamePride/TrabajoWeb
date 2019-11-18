package com.gamepride.platform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gamepride.platform.model.LanCenter;
import com.gamepride.platform.service.ILanCenterService;

@Controller
@SessionAttributes("lancenter")
@RequestMapping("/lancenters")
public class LanCenterController {
	
	@Autowired
	private ILanCenterService lancenterService;
	
	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("lancenter", new LanCenter());
		return "lancenter/lancenter";
	}
	
	@PostMapping("/save")
	public String saveLanCenter(
			@Valid LanCenter lancenter,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
	
		if(result.hasErrors()) {
			return "lancenter/lancenter";
		} else {
			if(lancenterService.create(lancenter) > 0) {
				model.addAttribute("info", "Already exists.");
			} else {
				
				model.addAttribute("info", "Successfully saved.");
				status.setComplete();
			}
		}
		return "list/listLanCenters";
	}
	
	@GetMapping("/list")
	public String listLanCenters(Model model) {
		try {
			model.addAttribute("listLanCenters", lancenterService.getLanCenters());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "lancenter/listLanCenters";
	}
}
