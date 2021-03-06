package ee.itcollege.i377.iseseisev3;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.i377.iseseisev3.IncidentSimulatorServiceImpl;
import ee.itcollege.i377.model.Piirivalvur;
import ee.itcollege.i377.service.PiirivalvurServiceImpl;

//@Controller
public class IncidentController {

//	@Autowired
//	private IncidentSimulatorServiceImpl incidentSimulatorServiceImpl;
	
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
	@RequestMapping(value="/reportIncident", method=RequestMethod.GET)
	public String reportIncident(ModelMap model){
		model.addAttribute("incident", new Incident());
		return "reportIncident";
	}
	
	@RequestMapping(value="/reportIncident", method=RequestMethod.POST)
	public String reportIncidents(@ModelAttribute Incident incident, Model model){
		model.addAttribute("msg", incident.getLocation());
		return "showIncident";
	}
	
	@RequestMapping("/guard/show")
	public String showGuard(Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		return "showGuard";
	}
	
	@RequestMapping("/guard/update")
	public String updateGuard() {
		return "updateGuard";
	}
	
	@RequestMapping("/guard/delete")
	public String deleteGuard() {
		return "deleteGuard";
	}
	
	@RequestMapping("/borderStation/show")
	public String showBorderStation() {
		return "showBorderStation";
	}
	
	@RequestMapping("/borderStation/update")
	public String updateBorderStation() {
		return "updateBorderStation";
	}
	
	@RequestMapping("/borderStation/delete")
	public String deleteBorderStation() {
		return "deleteBorderStation";
	}
	
}
