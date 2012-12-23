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
import ee.itcollege.i377.model.PiirivalvurAuaste;
import ee.itcollege.i377.service.PiirivalvurAuasteServiceImpl;

@Controller
public class PiirivalvurAuasteController {
	
	Long originalPiirivalvurAuasteId;
	PiirivalvurAuaste originalPiirivalvurAuaste;
		
	@Resource
	private PiirivalvurAuasteServiceImpl piirivalvurauasteServiceImpl;
	
	
	@RequestMapping("/piirivalvurauaste/show")
	public String showVahtkonnaLiige(Model model) {
		List<PiirivalvurAuaste> piirivalvurauastes = piirivalvurauasteServiceImpl.getAllPiirivalvurAuastes();
		model.addAttribute("allPiirivalvurAuastes", piirivalvurauastes);
		return "showPiirivalvurAuaste";
	}
	
	@RequestMapping("/piirivalvurauaste/add")
	public String addVahtkonnaLiige(Model model) {
		model.addAttribute("vahtkonnaliige", new PiirivalvurAuaste());
		return "addPiirivalvurAuaste";
	}
	
	@RequestMapping(value="/piirivalvurauaste/add", method = RequestMethod.POST)
	public String addVahtkonnaLiige(@ModelAttribute PiirivalvurAuaste piirivalvurAuaste, Model model) {
		piirivalvurauasteServiceImpl.addPiirivalvurAuaste(piirivalvurAuaste);
		model.addAttribute("added", true);
		return "addPiirivalvurAuaste";
	}
	
	@RequestMapping("/piirivalvurauaste/update")
	public String updateVahtkond(@RequestParam("id") String updateId, Model model) {
		originalPiirivalvurAuasteId = Long.valueOf(updateId).longValue();
		originalPiirivalvurAuaste = piirivalvurauasteServiceImpl.getPiirivalvurAuasteById(originalPiirivalvurAuasteId);
		model.addAttribute("vahtkonnaliige", piirivalvurauasteServiceImpl.getPiirivalvurAuasteById(originalPiirivalvurAuasteId));
		return "updatePiirivalvurAuaste";
	}
	
	@RequestMapping(value="/piirivalvurauaste/update", method = RequestMethod.POST)
	public String updatePiirivalvurAuaste(@ModelAttribute PiirivalvurAuaste piirivalvurAuaste, Model model) {
		piirivalvurAuaste.setId(originalPiirivalvurAuasteId);
		piirivalvurAuaste.setAvaja(originalPiirivalvurAuaste.getAvaja());
		piirivalvurAuaste.setAvatud(originalPiirivalvurAuaste.getAvatud());
		piirivalvurauasteServiceImpl.updatePiirivalvurAuaste(piirivalvurAuaste);
		model.addAttribute("updated", true);
		return "updateVahtkonnaLiige";
	}
	
	@RequestMapping("/piirivalvurauaste/delete")
	public String deleteVahtkonnaLiige(@RequestParam("id") String deleteId, Model model) {
		piirivalvurauasteServiceImpl.deletePiirivalvurAuasteById(Long.valueOf(deleteId).longValue());
		return "redirect:/vahtkonnaliige/show";
	}
	
}
