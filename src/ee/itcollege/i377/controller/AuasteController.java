package ee.itcollege.i377.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import ee.itcollege.i377.service.AuasteServiceImpl;
import org.springframework.context.MessageSource;

@Controller
public class AuasteController {
	
	Long originalAuasteId;
	Auaste originalAuaste;
		
	@Resource
	private AuasteServiceImpl auasteServiceImpl;
	
	@RequestMapping("/auaste/show")
	public String showAuaste(Model model) {
		List<Auaste> auastes = auasteServiceImpl.getAllAuastes();
		model.addAttribute("allAuastes", auastes);
		return "showAuaste";
	}
	
	@RequestMapping("/auaste/add")
	public String addAuaste(Model model) {
		model.addAttribute("auaste", new Auaste());
		return "addAuaste";
	}
	
	@RequestMapping(value="/auaste/add", method = RequestMethod.POST)
	public String addAuaste(@ModelAttribute Auaste auaste, Model model) {
		auasteServiceImpl.addAuaste(auaste);
		model.addAttribute("added", true);
		return "addAuaste";
	}
	
	@RequestMapping("/auaste/update")
	public String updateAuaste(@RequestParam("id") String updateId, Model model) {
		originalAuasteId = Long.valueOf(updateId).longValue();
		originalAuaste = auasteServiceImpl.getAuasteById(originalAuasteId);
		model.addAttribute("auaste", auasteServiceImpl.getAuasteById(originalAuasteId));
		return "updateAuaste";
	}
	
	@RequestMapping(value="/auaste/update", method = RequestMethod.POST)
	public String updateAuastePost(@ModelAttribute Auaste auaste, Model model) {
		auaste.setId(originalAuasteId);
		auaste.setAvaja(originalAuaste.getAvaja());
		auaste.setAvatud(originalAuaste.getAvatud());
		auasteServiceImpl.updateAuaste(auaste);
		model.addAttribute("updated", true);
		return "updateAuaste";
	}
	
	@RequestMapping("/auaste/delete")
	public String deleteAuaste(@RequestParam("id") String deleteId, Model model) {
		auasteServiceImpl.deleteAuasteById(Long.valueOf(deleteId).longValue());
		return "redirect:/auaste/show";
	}
	
}
