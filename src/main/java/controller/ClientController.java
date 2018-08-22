package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Client;
import model.ClientEl;
import model.ClientMoral;
import model.ClientPhysique;
import repositories.ClientRepository;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping("")
	public ModelAndView home() {
		
		return new ModelAndView("redirect:/client/");
	}
	
	@RequestMapping("/")
	public ModelAndView list(Model model) {
		return new ModelAndView("client/list", "clients", clientRepository.findAll());
	}
	
	private ModelAndView goEdit(Client client) {
		ModelAndView modelAndView = new ModelAndView("client/edit", "client", client);
		modelAndView.addObject("clients", clientRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping("/addphysique")
	public ModelAndView addPhysique() {
		return goEdit(new ClientPhysique());
	}
	
	@RequestMapping("/addmoral")
	public ModelAndView addMoral() {
		return goEdit(new ClientMoral());
	}
	
	@RequestMapping("/addel")
	public ModelAndView addEl() {
		return goEdit(new ClientEl());
	}
	
	

}
