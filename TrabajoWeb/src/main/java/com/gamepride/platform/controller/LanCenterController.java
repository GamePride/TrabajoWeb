package com.gamepride.platform.controller;

import java.util.List;

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
import com.gamepride.platform.service.IEventService;
import com.gamepride.platform.service.ILanCenterService;

@Controller
@SessionAttributes("lancenter")
@RequestMapping("/lancenters")
public class LanCenterController {

	@Autowired
	private ILanCenterService lancenterService;

	@Autowired
	private IEventService eventService;

	@GetMapping("/create")
	public String newLanCenter(Model model) throws Exception {
		model.addAttribute("lancenter", new LanCenter());
		model.addAttribute("events", eventService.getEvents());
		return "/lancenter/lancenter";
	}

	@PostMapping("/save")
	public String saveLanCenter(@Valid LanCenter lancenter, BindingResult result, Model model, SessionStatus status)
			throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("events", eventService.getEvents());
			return "/lancenter/lancenter";
		} else {
			if (lancenterService.create(lancenter) > 0) {
				model.addAttribute("info", "Usted ya cuenta con una cuenta LanCenter.");
				model.addAttribute("events", eventService.getEvents());
				return "/lancenter/lancenterList";
			} else {
				model.addAttribute("info", "LanCenter creado correctamente.");
				status.setComplete();
			}
		}
		model.addAttribute("lancenters", lancenterService.getLanCenters());
		return "/lancenter/lancenterList";
	}

	@GetMapping("/list")
	public String listLanCenters(Model model) {
		try {
			model.addAttribute("lancenter", new LanCenter());
			model.addAttribute("lancenters", lancenterService.getLanCenters());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/lancenter/lancenterList";
	}
	
	@GetMapping("/search")
	public String searchLanCenter(@RequestParam("name") String name, Model model) {
		try {
			if (!name.isEmpty()) {
				List<LanCenter> lancenters = lancenterService.findByName(name);
				if (!lancenters.isEmpty()) {
					model.addAttribute("lancenters", lancenters);
				} else {
					model.addAttribute("info", "Lan Center no existe");
					model.addAttribute("lancenters", lancenterService.getLanCenters());
				}
			} else {
				model.addAttribute("info", "Debe ingresar un nombre");
				model.addAttribute("lancenters", lancenterService.getLanCenters());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/lancenter/lancenterList";
	}
}
