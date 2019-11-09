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

import com.gamepride.platform.model.Gamer;
import com.gamepride.platform.model.LanCenter;
import com.gamepride.platform.model.Person;
import com.gamepride.platform.model.Subscription;
import com.gamepride.platform.service.IGamerService;
import com.gamepride.platform.service.ILanCenterService;
import com.gamepride.platform.service.IPersonService;
import com.gamepride.platform.service.ISubscriptionService;


@Controller
@RequestMapping("people")
@SessionAttributes("/people")
public class PersonController {

	@Autowired
	private IPersonService personService;
	
	@Autowired
	private IGamerService gamerService;
	
	@Autowired
	private ILanCenterService lancenterService;
	
	@Autowired
	private ISubscriptionService subscriptionService;
	
	@GetMapping
	public String event(Model model) throws Exception {
		List<Person> people = personService.findAll();
		model.addAttribute("person", people);
		return "people/people";
	}
	@GetMapping(value = "new")
	public String newPerson(Model model) throws Exception {
		Person person = new Person();
		model.addAttribute("person", person);
		model.addAttribute("gamers", loadGamers());
		model.addAttribute("gamers", loadLanCenters());
		model.addAttribute("subscritions", loadSubscriptions());
		model.addAttribute("title", "Nueva persona");
		return "person/form";
	}
	
	@PostMapping(value = "/save")
	public String savePerson(@Valid Person person, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("title", "Nueva persona");
			return "person/form";
		}

		String mensajeFlash = (person.getId() == null) ? "Persona editada" : "Persona registrada";
		personService.save(person);
		status.setComplete();
		flash.addFlashAttribute("title", mensajeFlash);
		return "redirect:/people";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editPerson(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) throws Exception {
		Optional<Person> person;
		if (id > 0) {
			person = personService.findById(id);
			if (!person.isPresent()) {
				flash.addFlashAttribute("error", "La persona no existe");
				return "redirect:/people";
			}
		} else {
			flash.addFlashAttribute("error", "La persona no existe");
			return "redirect:/people";
		}
		
		model.addAttribute("gamers", loadGamers());
		model.addAttribute("subscription", loadSubscriptions());
		model.addAttribute("subscription", loadLanCenters());
		model.addAttribute("person", person);
		model.addAttribute("title", "Editar persona");
		return "person/form";

	}
	
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable(value = "id") Long id, Model model) throws Exception {

		personService.deleteById(id);
		return "redirect:/people";

	}
	
	List<Gamer> loadGamers() throws Exception {
	return gamerService.findAll();
	}
	List<LanCenter> loadLanCenters() throws Exception {
	return lancenterService.findAll();
	}
	List<Subscription> loadSubscriptions() throws Exception {
	return subscriptionService.findAll();
	}

}
