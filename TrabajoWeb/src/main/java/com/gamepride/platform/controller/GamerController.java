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

import com.gamepride.platform.model.Gamer;
import com.gamepride.platform.service.IGamerService;

@Controller
@SessionAttributes("gamer")
@RequestMapping("/gamers")
public class GamerController {

	@Autowired
	private IGamerService gamerService;

	@GetMapping("/new")
	public String newPerson(Model model) throws Exception {
		model.addAttribute("gamer", new Gamer());
		return "person/personForm";
	}

	@PostMapping("/save")
	public String savePerson(@Valid Gamer gamer, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "person/personForm";
		}

		if (gamer.getId() != null) {
			model.addAttribute("info", "Este usuario ya se encuentra registrado");
			return "person/personForm";
		} else {
			model.addAttribute("info", "Usuario registrado correctamente");
			status.setComplete();
			gamerService.save(gamer);
		}

		return "redirect:list";

	}

	@GetMapping("/list")
	public String listPeople(Model model) {
		try {
			model.addAttribute("gamers", gamerService.getGamers());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "person/personList";
	}

	@GetMapping("/search")
	public String searchPerson(@RequestParam("name") String name, Model model) {
		try {
			if (!name.isEmpty()) {
				List<Gamer> gamers = gamerService.findByUsername(name);
				if (!gamers.isEmpty()) {
					model.addAttribute("gamers", gamers);
				} else {
					model.addAttribute("info", "No existe la persona");
					model.addAttribute("gamers", gamerService.getGamers());
				}
			} else {
				model.addAttribute("info", "Debe ingresar un nombre");
				model.addAttribute("gamers", gamerService.getGamers());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "person/personList";
	}
}
