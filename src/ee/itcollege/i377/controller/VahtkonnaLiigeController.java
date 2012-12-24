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
import ee.itcollege.i377.model.Vahtkond;
import ee.itcollege.i377.model.VahtkonnaLiige;
import ee.itcollege.i377.service.PiirivalvurServiceImpl;
import ee.itcollege.i377.service.VahtkondServiceImpl;
import ee.itcollege.i377.service.VahtkonnaLiigeServiceImpl;

@Controller
public class VahtkonnaLiigeController {
	
	Long originalVahtkonnaLiigeId;
	VahtkonnaLiige originalVahtkonnaLiige;
		
	@Resource
	private VahtkonnaLiigeServiceImpl vahtkonnaLiigeServiceImpl;
	@Resource
	private VahtkondServiceImpl vahtkondServiceImpl;
	@Resource
	private PiirivalvurServiceImpl piirivalvurServiceImpl;
	
	
	@RequestMapping("/vahtkonnaLiige/show")
	public String showVahtkonnaLiige(Model model) {
		List<VahtkonnaLiige> vahtkonnaliiges = vahtkonnaLiigeServiceImpl.getAllVahtkonnaLiiges();
		model.addAttribute("allVahtkonnaLiiges", vahtkonnaliiges);
		return "showVahtkonnaLiige";
	}
	
	@RequestMapping("/vahtkonnaLiige/add")
	public String addVahtkonnaLiige(Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		List<Vahtkond> vahtkonds = vahtkondServiceImpl.getAllVahtkonds();
		model.addAttribute("allVahtkonds", vahtkonds);
		
		model.addAttribute("vahtkonnaLiige", new VahtkonnaLiige());
		return "addVahtkonnaLiige";
	}
	
	@RequestMapping(value="/vahtkonnaLiige/add", method = RequestMethod.POST)
	public String addVahtkonnaLiige(@ModelAttribute VahtkonnaLiige vahtkonnaLiige, Model model) {
		vahtkonnaLiigeServiceImpl.addVahtkonnaLiige(vahtkonnaLiige);
		model.addAttribute("added", true);
		return "addVahtkonnaLiige";
	}
	
	@RequestMapping("/vahtkonnaLiige/update")
	public String updateVahtkonnaLiige(@RequestParam("id") String updateId, Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		List<Vahtkond> vahtkonds = vahtkondServiceImpl.getAllVahtkonds();
		model.addAttribute("allVahtkonds", vahtkonds);
		
		originalVahtkonnaLiigeId = Long.valueOf(updateId).longValue();
		originalVahtkonnaLiige = vahtkonnaLiigeServiceImpl.getVahtkonnaLiigeById(originalVahtkonnaLiigeId);
		model.addAttribute("vahtkonnaLiige", vahtkonnaLiigeServiceImpl.getVahtkonnaLiigeById(originalVahtkonnaLiigeId));
		return "updateVahtkonnaLiige";
	}
	
	@RequestMapping(value="/vahtkonnaLiige/update", method = RequestMethod.POST)
	public String updateVahtkonnaLiige(@ModelAttribute VahtkonnaLiige vahtkonnaLiige, Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		List<Vahtkond> vahtkonds = vahtkondServiceImpl.getAllVahtkonds();
		model.addAttribute("allVahtkonds", vahtkonds);
		
		vahtkonnaLiige.setId(originalVahtkonnaLiigeId);
		vahtkonnaLiige.setAvaja(originalVahtkonnaLiige.getAvaja());
		vahtkonnaLiige.setAvatud(originalVahtkonnaLiige.getAvatud());
		vahtkonnaLiigeServiceImpl.updateVahtkonnaLiige(vahtkonnaLiige);
		model.addAttribute("updated", true);
		return "updateVahtkonnaLiige";
	}
	
	@RequestMapping("/vahtkonnaLiige/delete")
	public String deleteVahtkonnaLiige(@RequestParam("id") String deleteId, Model model) {
		vahtkonnaLiigeServiceImpl.deleteVahtkonnaLiigeById(Long.valueOf(deleteId).longValue());
		return "redirect:/vahtkonnaLiige/show";
	}
	
}
