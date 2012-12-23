package ee.itcollege.i377.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.i377.iseseisev3.Incident;
import ee.itcollege.i377.model.Vahtkond;
import ee.itcollege.i377.service.VahtkondServiceImpl;

//@Controller
public class VahtkondController {
	
	Long originalVahtkondId;
	Vahtkond originalVahtkond;
		
	@Resource
	private VahtkondServiceImpl vahtkondServiceImpl;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/guard/show")
	public String showGuard(Model model) {
		List<Vahtkond> vahtkonds = vahtkondServiceImpl.getAllVahtkonds();
		model.addAttribute("allVahtkonds", vahtkonds);
		return "showGuard";
	}
	
	@RequestMapping("/guard/add")
	public String addGuard(Model model) {
		//List<Vahtkond> vahtkonds = vahtkondServiceImpl.getAllVahtkonds();
		model.addAttribute("vahtkond", new Vahtkond());
		return "addGuard";
	}
	
	@RequestMapping(value="/guard/add", method = RequestMethod.POST)
	public String addGuard(@ModelAttribute Vahtkond vahtkond, Model model) {
		vahtkondServiceImpl.addVahtkond(vahtkond);
		model.addAttribute("added", true);
		return "addGuard";
	}
	
	@RequestMapping("/guard/update")
	public String updateGuard(@RequestParam("id") String updateId, Model model) {
		originalVahtkondId = Long.valueOf(updateId).longValue();
		originalVahtkond = vahtkondServiceImpl.getVahtkondById(originalVahtkondId);
		model.addAttribute("vahtkond", vahtkondServiceImpl.getVahtkondById(originalVahtkondId));
		return "updateGuard";
	}
	
	@RequestMapping(value="/guard/update", method = RequestMethod.POST)
	public String updateGuardPost(@ModelAttribute Vahtkond vahtkond, Model model) {
		vahtkond.setId(originalVahtkondId);
		vahtkond.setAvaja(originalVahtkond.getAvaja());
		vahtkond.setAvatud(originalVahtkond.getAvatud());
		vahtkondServiceImpl.updateVahtkond(vahtkond);
		model.addAttribute("updated", true);
		return "updateGuard";
	}
	
	@RequestMapping("/guard/delete")
	public String deleteGuard(@RequestParam("id") String deleteId, Model model) {
		vahtkondServiceImpl.deleteVahtkondById(Long.valueOf(deleteId).longValue());
		return "redirect:/guard/show";
	}
	
}
