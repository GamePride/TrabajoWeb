package com.gamepride.platform.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gamepride.platform.model.Event;
import com.gamepride.platform.model.Gamer;
import com.gamepride.platform.model.LanCenter;
import com.gamepride.platform.service.ILanCenterService;
import com.gamepride.platform.service.IPersonService;
import com.gamepride.platform.service.IEventService;
import com.gamepride.platform.service.IGamerService;

@Controller
@RequestMapping("lancenter")
@SessionAttributes("/lancenters")
public class LanCenterController {

	@Autowired
	private ILanCenterService lancenterService;
	
	@Autowired
	private IGamerService gamerService;
	
	@Autowired
	private IEventService eventService;

	@GetMapping
	public String event(Model model) throws Exception {
		List<LanCenter> lancenters = lancenterService.findAll();
		model.addAttribute("lancenter", lancenters);
		return "lancenter/lancenter";
	}

	@GetMapping(value = "new")
	public String newLanCenter(Model model) throws Exception {
		LanCenter lancenter = new LanCenter();
		model.addAttribute("lancenter", lancenter);
		model.addAttribute("events", loadEvents());
		model.addAttribute("title", "Nuevo Lan Center");
		return "lancenter/form";
	}

	@PostMapping(value = "/save")
	public String saveLanCenter(@Valid LanCenter lancenter, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("title", "Nuevo Lan Center");
			return "lancenter/form";
		}

		String mensajeFlash = (lancenter.getId() == null) ? "Lan Center editado" : "Lan Center registrado";
		lancenterService.save(lancenter);
		status.setComplete();
		flash.addFlashAttribute("title", mensajeFlash);
		return "redirect:/lancenters";
	}

	@GetMapping(value = "/edit/{id}")
	public String editLanCenter(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) throws Exception {
		Optional<LanCenter> lancenter;
		if (id > 0) {
			lancenter = lancenterService.findById(id);
			if (!lancenter.isPresent()) {
				flash.addFlashAttribute("error", "El lan center no existe");
				return "redirect:/events";
			}
		} else {
			flash.addFlashAttribute("error", "El evento no existe");
			return "redirect:/lancenters";
		}
		
		model.addAttribute("events", loadEvents());
		model.addAttribute("lancenter", lancenter);
		model.addAttribute("title", "Editar cliente");
		return "lancenter/form";

	}

	@GetMapping("/delete/{id}")
	public String deleteLanCenter(@PathVariable(value = "id") Long id, Model model) throws Exception {

		lancenterService.deleteById(id);
		return "redirect:/lancenters";

	}
	
	List<Event> loadEvents() throws Exception {
		return eventService.findAll();
	}
	
	
}