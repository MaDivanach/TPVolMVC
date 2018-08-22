package controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Reservation;
import repositories.ClientRepository;
import repositories.ReservationRepository;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/reservation/");
	}

	@RequestMapping("/")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("reservation/list");
		mv.getModelMap().addAttribute("reservations", reservationRepository.findAll());
		return mv;
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id) {
		reservationRepository.deleteById(id);
		return "redirect:/reservation/";
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		return goEdit(new Reservation());
	}
	
	@RequestMapping("/edit")
	public ModelAndView update(@RequestParam(name = "id") Long id) {
		Optional<Reservation> opt = reservationRepository.findById(id);
		if(opt.isPresent()) {
			return goEdit(opt.get());
		} else {
			return new ModelAndView("redirect:/reservation/");
		}
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("reservation") Reservation reservation, BindingResult br) {
		if(br.hasErrors()) {
			return goEdit(reservation);
		} else {
			reservationRepository.save(reservation);
			return new ModelAndView("redirect:/reservation/");
		}
	}
	
	private ModelAndView goEdit(Reservation reservation) {
		ModelAndView mv = new ModelAndView("reservation/edit");
		mv.getModelMap().addAttribute("reservation", reservation);
		mv.getModelMap().addAttribute("clients",clientRepository.findAll());
		return mv;
	}
}
