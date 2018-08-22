package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	

}
