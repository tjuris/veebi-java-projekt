package ee.itcollege.i377.service;

import java.util.List;

import ee.itcollege.i377.model.Auaste;

public interface AuasteService {
	void addAuaste(Auaste auaste);
	void updateAuaste(Auaste auaste);
	void deleteAuasteById(Long id);
	List<Auaste> getAllAuastes();
	Auaste getAuasteById(Long id);
}
