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
import ee.itcollege.i377.model.Piirivalvur;
import ee.itcollege.i377.service.PiirivalvurServiceImpl;

@Controller
public class PiirivalvurController {
	
	Long originalPiirivalvurId;
	Piirivalvur originalPiirivalvur;
		
	@Resource
	private PiirivalvurServiceImpl piirivalvurServiceImpl;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/guard/show")
	public String showGuard(Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		return "showGuard";
	}
	
	@RequestMapping("/guard/add")
	public String addGuard(Model model) {
		//List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("piirivalvur", new Piirivalvur());
		return "addGuard";
	}
	
	@RequestMapping(value="/guard/add", method = RequestMethod.POST)
	public String addGuard(@ModelAttribute Piirivalvur piirivalvur, Model model) {
		piirivalvurServiceImpl.addPiirivalvur(piirivalvur);
		model.addAttribute("added", true);
		return "addGuard";
	}
	
	@RequestMapping("/guard/update")
	public String updateGuard(@RequestParam("id") String updateId, Model model) {
		originalPiirivalvurId = Long.valueOf(updateId).longValue();
		originalPiirivalvur = piirivalvurServiceImpl.getPiirivalvurById(originalPiirivalvurId);
		model.addAttribute("piirivalvur", piirivalvurServiceImpl.getPiirivalvurById(originalPiirivalvurId));
		return "updateGuard";
	}
	
	@RequestMapping(value="/guard/update", method = RequestMethod.POST)
	public String updateGuardPost(@ModelAttribute Piirivalvur piirivalvur, Model model) {
		piirivalvur.setId(originalPiirivalvurId);
		piirivalvur.setAvaja(originalPiirivalvur.getAvaja());
		piirivalvur.setAvatud(originalPiirivalvur.getAvatud());
		piirivalvurServiceImpl.updatePiirivalvur(piirivalvur);
		model.addAttribute("updated", true);
		return "updateGuard";
	}
	
	@RequestMapping("/guard/delete")
	public String deleteGuard(@RequestParam("id") String deleteId, Model model) {
		piirivalvurServiceImpl.deletePiirivalvurById(Long.valueOf(deleteId).longValue());
		return "redirect:/guard/show";
	}
	
}
