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

@Controller
public class VahtkondController {
	
	Long originalVahtkondId;
	Vahtkond originalVahtkond;
		
	@Resource
	private VahtkondServiceImpl vahtkondServiceImpl;
	
	
	@RequestMapping("/vahtkond/show")
	public String showVahtkond(Model model) {
		List<Vahtkond> vahtkonds = vahtkondServiceImpl.getAllVahtkonds();
		model.addAttribute("allVahtkonds", vahtkonds);
		return "showVahtkond";
	}
	
	@RequestMapping("/vahtkond/add")
	public String addVahtkond(Model model) {
		model.addAttribute("vahtkond", new Vahtkond());
		return "addVahtkond";
	}
	
	@RequestMapping(value="/vahtkond/add", method = RequestMethod.POST)
	public String addVahtkond(@ModelAttribute Vahtkond vahtkond, Model model) {
		vahtkondServiceImpl.addVahtkond(vahtkond);
		model.addAttribute("added", true);
		return "addVahtkond";
	}
	
	@RequestMapping("/vahtkond/update")
	public String updateVahtkond(@RequestParam("id") String updateId, Model model) {
		originalVahtkondId = Long.valueOf(updateId).longValue();
		originalVahtkond = vahtkondServiceImpl.getVahtkondById(originalVahtkondId);
		model.addAttribute("vahtkond", vahtkondServiceImpl.getVahtkondById(originalVahtkondId));
		return "updateVahtkond";
	}
	
	@RequestMapping(value="/vahtkond/update", method = RequestMethod.POST)
	public String updateVahtkondPost(@ModelAttribute Vahtkond vahtkond, Model model) {
		vahtkond.setId(originalVahtkondId);
		vahtkond.setAvaja(originalVahtkond.getAvaja());
		vahtkond.setAvatud(originalVahtkond.getAvatud());
		vahtkondServiceImpl.updateVahtkond(vahtkond);
		model.addAttribute("updated", true);
		return "updateVahtkond";
	}
	
	@RequestMapping("/vahtkond/delete")
	public String deleteVahtkond(@RequestParam("id") String deleteId, Model model) {
		vahtkondServiceImpl.deleteVahtkondById(Long.valueOf(deleteId).longValue());
		return "redirect:/vahtkond/show";
	}
	
}
