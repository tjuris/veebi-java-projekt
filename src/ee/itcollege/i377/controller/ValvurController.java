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
public class ValvurController {

//	@Autowired
//	private IncidentSimulatorServiceImpl incidentSimulatorServiceImpl;
	
	Long originalId;
	Piirivalvur originalPiirivalvur;
		
	@Resource
	private PiirivalvurServiceImpl piirivalvurServiceImpl;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
//	@RequestMapping("/listAll")
//	public String allIncidents(Model model){
//		model.addAttribute("incidents", incidentSimulatorServiceImpl.getUnresolvedIncidents());
//		return "listAll";
//	}
//	@RequestMapping(value="/reportIncident", method=RequestMethod.GET)
//	public String reportIncident(ModelMap model){
//		model.addAttribute("incident", new Incident());
//		return "reportIncident";
//	}
//	
//	@RequestMapping(value="/reportIncident", method=RequestMethod.POST)
//	public String reportIncidents(@ModelAttribute Incident incident, Model model){
//		model.addAttribute("msg", incident.getLocation());
//		return "showIncident";
//	}
	
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
		originalId = Long.valueOf(updateId).longValue();
		originalPiirivalvur = piirivalvurServiceImpl.getPiirivalvurById(originalId);
		model.addAttribute("piirivalvur", piirivalvurServiceImpl.getPiirivalvurById(originalId));
		return "updateGuard";
	}
	
	@RequestMapping(value="/guard/update", method = RequestMethod.POST)
	public String updateGuardPost(@ModelAttribute Piirivalvur piirivalvur, Model model) {
		piirivalvur.setId(originalId);
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

//	@RequestMapping("/guard/delete")
//	public String deleteGuard() {
//		return "deleteGuard";
//	}
//	
//	@RequestMapping("/borderStation/show")
//	public String showBorderStation() {
//		return "showBorderStation";
//	}
//	
//	@RequestMapping("/borderStation/update")
//	public String updateBorderStation() {
//		return "updateBorderStation";
//	}
//	
//	@RequestMapping("/borderStation/delete")
//	public String deleteBorderStation() {
//		return "deleteBorderStation";
//	}
	
}
