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
import ee.itcollege.i377.model.Auaste;
import ee.itcollege.i377.model.Piirivalvur;
import ee.itcollege.i377.model.PiirivalvurAuaste;
import ee.itcollege.i377.model.Vahtkond;
import ee.itcollege.i377.service.AuasteServiceImpl;
import ee.itcollege.i377.service.PiirivalvurAuasteServiceImpl;
import ee.itcollege.i377.service.PiirivalvurServiceImpl;

@Controller
public class PiirivalvurAuasteController {
	
	Long originalPiirivalvurAuasteId;
	PiirivalvurAuaste originalPiirivalvurAuaste;
		
	@Resource
	private PiirivalvurAuasteServiceImpl piirivalvurauasteServiceImpl;
	@Resource
	private PiirivalvurServiceImpl piirivalvurServiceImpl;
	@Resource
	private AuasteServiceImpl auasteServiceImpl;
	
	
	@RequestMapping("/piirivalvurAuaste/show")
	public String showPiirivalvurAuaste(Model model) {
		List<PiirivalvurAuaste> piirivalvurAuastes = piirivalvurauasteServiceImpl.getAllPiirivalvurAuastes();
		model.addAttribute("allPiirivalvurAuastes", piirivalvurAuastes);
		return "showPiirivalvurAuaste";
	}
	
	@RequestMapping("/piirivalvurAuaste/add")
	public String addPiirivalvurAuaste(Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		List<Auaste> auastes = auasteServiceImpl.getAllAuastes();
		model.addAttribute("allAuastes", auastes);
		
		model.addAttribute("piirivalvurAuaste", new PiirivalvurAuaste());
		return "addPiirivalvurAuaste";
	}
	
	@RequestMapping(value="/piirivalvurAuaste/add", method = RequestMethod.POST)
	public String addPiirivalvurAuaste(@ModelAttribute PiirivalvurAuaste piirivalvurAuaste, Model model) {
		piirivalvurauasteServiceImpl.addPiirivalvurAuaste(piirivalvurAuaste);
		model.addAttribute("added", true);
		return "addPiirivalvurAuaste";
	}
	
	@RequestMapping("/piirivalvurAuaste/update")
	public String updatePiirivalvurAuaste(@RequestParam("id") String updateId, Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		List<Auaste> auastes = auasteServiceImpl.getAllAuastes();
		model.addAttribute("allAuastes", auastes);
		
		originalPiirivalvurAuasteId = Long.valueOf(updateId).longValue();
		originalPiirivalvurAuaste = piirivalvurauasteServiceImpl.getPiirivalvurAuasteById(originalPiirivalvurAuasteId);
		model.addAttribute("piirivalvurAuaste", piirivalvurauasteServiceImpl.getPiirivalvurAuasteById(originalPiirivalvurAuasteId));
		return "updatePiirivalvurAuaste";
	}
	
	@RequestMapping(value="/piirivalvurAuaste/update", method = RequestMethod.POST)
	public String updatePiirivalvurAuaste(@ModelAttribute PiirivalvurAuaste piirivalvurAuaste, Model model) {
		List<Piirivalvur> piirivalvurs = piirivalvurServiceImpl.getAllPiirivalvurs();
		model.addAttribute("allPiirivalvurs", piirivalvurs);
		List<Auaste> auastes = auasteServiceImpl.getAllAuastes();
		model.addAttribute("allAuastes", auastes);
		
		piirivalvurAuaste.setId(originalPiirivalvurAuasteId);
		piirivalvurAuaste.setAvaja(originalPiirivalvurAuaste.getAvaja());
		piirivalvurAuaste.setAvatud(originalPiirivalvurAuaste.getAvatud());
		piirivalvurauasteServiceImpl.updatePiirivalvurAuaste(piirivalvurAuaste);
		model.addAttribute("updated", true);
		return "updatePiirivalvurAuaste";
	}
	
	@RequestMapping("/piirivalvurAuaste/delete")
	public String deletePiirivalvurAuaste(@RequestParam("id") String deleteId, Model model) {
		piirivalvurauasteServiceImpl.deletePiirivalvurAuasteById(Long.valueOf(deleteId).longValue());
		return "redirect:/piirivalvurAuaste/show";
	}
	
}
