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
import com.gamepride.platform.service.IEventService;
import com.gamepride.platform.service.IGamerService;

@Controller
@RequestMapping("Gamer")
@SessionAttributes("/gamers")
public class GamerController {
	
	@Autowired
	private IGamerService gamerService;
	
	@Autowired
	private IEventService eventService;
	
	@GetMapping
	public String Gamer(Model model) throws Exception {
		List<Gamer> gamers = gamerService.findAll();
		model.addAttribute("gamer", gamers);
		return "gamer/gamer";
	}
    
	@GetMapping(value = "new")
	public String newEvent(Model model) throws Exception {
		Gamer gamers = new Gamer();
		model.addAttribute("gamer", gamers );
		model.addAttribute("gamers", loadEvents());
		model.addAttribute("title", "Nuevo gamer");
		return "gamer/form";
	}
	
	@PostMapping(value = "/save")
	public String saveEvent(@Valid Gamer gamer, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("title", "Nuevo evento");
			return "event/form";
		}

		String mensajeFlash = (gamer.getId() == null) ? "Gamer editado" : "Gamer registrado";
		gamerService.save(gamer);
		status.setComplete();
		flash.addFlashAttribute("title", mensajeFlash);
		return "redirect:/gamers";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editGamer(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) throws Exception {
		Optional<Gamer> gamer;
		if (id > 0) {
			gamer = gamerService.findById(id);
			if (!gamer.isPresent()) {
				flash.addFlashAttribute("error", "El gamer no existe");
				return "redirect:/gamers";
			}
		} else {
			flash.addFlashAttribute("error", "El gamer no existe");
			return "redirect:/gamers";
		}
		
		model.addAttribute("events", loadEvents());
		model.addAttribute("gamer", gamer);
		model.addAttribute("title", "Editar Gamer");
		return "gamer/form";

		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable(value = "id") Long id, Model model) throws Exception {

		gamerService.deleteById(id);
		return "redirect:/gamers";

	}
	List<Event> loadEvents() throws Exception {
		return eventService.findAll();
	}	
}
