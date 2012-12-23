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
import ee.itcollege.i377.model.VahtkonnaLiige;
import ee.itcollege.i377.service.VahtkonnaLiigeServiceImpl;

@Controller
public class VahtkonnaLiigeController {
	
	Long originalVahtkonnaLiigeId;
	VahtkonnaLiige originalVahtkonnaLiige;
		
	@Resource
	private VahtkonnaLiigeServiceImpl vahtkonnaliigeServiceImpl;
	
	
	@RequestMapping("/vahtkonnaliige/show")
	public String showVahtkonnaLiige(Model model) {
		List<VahtkonnaLiige> vahtkonnaliiges = vahtkonnaliigeServiceImpl.getAllVahtkonnaLiiges();
		model.addAttribute("allVahtkonnaLiiges", vahtkonnaliiges);
		return "showVahtkonnaLiige";
	}
	
	@RequestMapping("/vahtkonnaliige/add")
	public String addVahtkonnaLiige(Model model) {
		model.addAttribute("vahtkonnaliige", new VahtkonnaLiige());
		return "addVahtkonnaLiige";
	}
	
	@RequestMapping(value="/vahtkonnaliige/add", method = RequestMethod.POST)
	public String addVahtkonnaLiige(@ModelAttribute VahtkonnaLiige vahtkonnaLiige, Model model) {
		vahtkonnaliigeServiceImpl.addVahtkonnaLiige(vahtkonnaLiige);
		model.addAttribute("added", true);
		return "addVahtkonnaLiige";
	}
	
	@RequestMapping("/vahtkonnaliige/update")
	public String updateVahtkond(@RequestParam("id") String updateId, Model model) {
		originalVahtkonnaLiigeId = Long.valueOf(updateId).longValue();
		originalVahtkonnaLiige = vahtkonnaliigeServiceImpl.getVahtkonnaLiigeById(originalVahtkonnaLiigeId);
		model.addAttribute("vahtkonnaliige", vahtkonnaliigeServiceImpl.getVahtkonnaLiigeById(originalVahtkonnaLiigeId));
		return "updateVahtkonnaLiige";
	}
	
	@RequestMapping(value="/vahtkonnaliige/update", method = RequestMethod.POST)
	public String updateVahtkonnaLiige(@ModelAttribute VahtkonnaLiige vahtkonnaLiige, Model model) {
		vahtkonnaLiige.setId(originalVahtkonnaLiigeId);
		vahtkonnaLiige.setAvaja(originalVahtkonnaLiige.getAvaja());
		vahtkonnaLiige.setAvatud(originalVahtkonnaLiige.getAvatud());
		vahtkonnaliigeServiceImpl.updateVahtkonnaLiige(vahtkonnaLiige);
		model.addAttribute("updated", true);
		return "updateVahtkonnaLiige";
	}
	
	@RequestMapping("/vahtkonnaliige/delete")
	public String deleteVahtkonnaLiige(@RequestParam("id") String deleteId, Model model) {
		vahtkonnaliigeServiceImpl.deleteVahtkonnaLiigeById(Long.valueOf(deleteId).longValue());
		return "redirect:/vahtkonnaliige/show";
	}
	
}
