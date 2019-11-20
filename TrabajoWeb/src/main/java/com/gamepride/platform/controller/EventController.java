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

/*@Controller
@RequestMapping("event")
@SessionAttributes("/events")
public class EventController {

	@Autowired
	private IEventService eventService;
	
	@Autowired
	private IGamerService gamerService;

	@GetMapping
	public String event(Model model) throws Exception {
		List<Event> events = eventService.findAll();
		model.addAttribute("event", events);
		return "event/event";
	}

	@GetMapping(value = "new")
	public String newEvent(Model model) throws Exception {
		Event event = new Event();
		model.addAttribute("event", event);
		model.addAttribute("gamers", loadGamers());
		model.addAttribute("title", "Nuevo evento");
		return "event/form";
	}

	@PostMapping(value = "/save")
	public String saveEvent(@Valid Event event, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("title", "Nuevo evento");
			return "event/form";
		}

		String mensajeFlash = (event.getId() == null) ? "Evento editado" : "Evento registrado";
		eventService.save(event);
		status.setComplete();
		flash.addFlashAttribute("title", mensajeFlash);
		return "redirect:/events";
	}

	@GetMapping(value = "/edit/{id}")
	public String editEvent(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) throws Exception {
		Optional<Event> event;
		if (id > 0) {
			event = eventService.findById(id);
			if (!event.isPresent()) {
				flash.addFlashAttribute("error", "El evento no existe");
				return "redirect:/events";
			}
		} else {
			flash.addFlashAttribute("error", "El evento no existe");
			return "redirect:/events";
		}
		
		model.addAttribute("gamers", loadGamers());
		model.addAttribute("event", event);
		model.addAttribute("title", "Editar cliente");
		return "event/form";

	}

	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable(value = "id") Long id, Model model) throws Exception {

		eventService.deleteById(id);
		return "redirect:/events";

	}
	
	List<Gamer> loadGamers() throws Exception {
		return gamerService.findAll();
	}
	
	
}*/
