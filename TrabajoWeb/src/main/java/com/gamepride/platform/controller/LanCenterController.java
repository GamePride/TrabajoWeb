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
import com.gamepride.platform.service.IGamerService;
import com.gamepride.platform.service.ILanCenterService;

@Controller
@SessionAttributes("lancenter")
@RequestMapping("/lancenters")
public class LanCenterController {

	@Autowired
<<<<<<< HEAD
	private ILanCenterService lanCenterService;
	
	@GetMapping("/new")
	public String newCategory(Model model)throws Exception {
		model.addAttribute("lancenter", new LanCenter());
		return "/lancenter/lancenterForm";
=======
	private ILanCenterService lancenterService;

	@Autowired
	private IGamerService gamerService;

	@Autowired
	private IEventService eventService;

	@GetMapping("/create")
	public String newLanCenter(Model model) throws Exception {
		model.addAttribute("lancenter", new LanCenter());
		model.addAttribute("gamers", gamerService.getGamers());
		model.addAttribute("events", eventService.getEvents());
		return "/lancenter/lancenter";
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
	}

	@PostMapping("/save")
<<<<<<< HEAD
	public String saveLanCenter(
			@Valid LanCenter lancenter,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
	
		if(result.hasErrors()) {
			return "/lancenter/lancenterForm";
		} else {
			if(lanCenterService.create(lancenter) > 0) {
				model.addAttribute("info", "Este lancenter ya existe.");
			} else {
				
				model.addAttribute("info", "Lancenter registrado.");
				status.setComplete();
			}
		}
		model.addAttribute("lancenters",lanCenterService.getLanCenters());
=======
	public String saveLanCenter(@Valid LanCenter lancenter, BindingResult result, Model model, SessionStatus status)
			throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("gamers", gamerService.getGamers());
			model.addAttribute("events", eventService.getEvents());
			return "/lancenter/lancenter";
		} else {
			if (lancenterService.create(lancenter) > 0) {
				model.addAttribute("info", "Usted ya cuenta con una cuenta LanCenter.");
				model.addAttribute("gamers", gamerService.getGamers());
				model.addAttribute("events", eventService.getEvents());
				return "/lancenter/lancenterList";
			} else {
				model.addAttribute("info", "LanCenter creado correctamente.");
				status.setComplete();
			}
		}
		model.addAttribute("lancenters", lancenterService.getLanCenters());
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
		return "/lancenter/lancenterList";
	}

	@GetMapping("/list")
	public String listLanCenters(Model model) {
		try {
<<<<<<< HEAD
			model.addAttribute("lancenter",new LanCenter());
			model.addAttribute("lancenters", lanCenterService.getLanCenters());
=======
			model.addAttribute("lancenter", new LanCenter());
			model.addAttribute("lancenters", lancenterService.getLanCenters());
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/lancenter/lancenterList";
	}
	
	@GetMapping("/search")
	public String searchLanCenter(@RequestParam("name") String name, Model model) {
		try {
			if (!name.isEmpty()) {
<<<<<<< HEAD
				List<LanCenter> lancenters = lanCenterService.findByName(name);
				if (!lancenters.isEmpty()) {
					model.addAttribute("lancenters", lancenters);
				} else {
					model.addAttribute("info", "No existe el lancenter");
					model.addAttribute("lancenters", lanCenterService.getLanCenters());
				}
			} else {
				model.addAttribute("info", "Debe ingresar un nombre");
				model.addAttribute("lancenters",lanCenterService.getLanCenters());
=======
				List<LanCenter> lancenters = lancenterService.fetchLanCenterByName(name);
				if (!lancenters.isEmpty()) {
					model.addAttribute("lancenters", lancenters);
				} else {
					model.addAttribute("info", "Lan Center no existe");
					model.addAttribute("lancenters", lancenterService.getLanCenters());
				}
			} else {
				model.addAttribute("info", "Debe ingresar un nombre");
				model.addAttribute("lancenters", lancenterService.getLanCenters());
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/lancenter/lancenterList";
	}
<<<<<<< HEAD
	
}
=======
}
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
