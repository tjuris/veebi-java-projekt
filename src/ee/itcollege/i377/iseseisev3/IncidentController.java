package ee.itcollege.i377.iseseisev3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncidentController {

	@Autowired
	private IncidentSimulatorServiceImpl incidentSimulatorServiceImpl;
	
	@RequestMapping("/listAll")
	public String allIncidents(Model model){
		model.addAttribute("incidents", incidentSimulatorServiceImpl.getUnresolvedIncidents());
		return "listAll";
	}
}
