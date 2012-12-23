package ee.itcollege.i377.service;

import java.util.List;

import ee.itcollege.i377.model.PiirivalvurAuaste;

public interface PiirivalvurAuasteService {
	void addPiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste);
	void updatePiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste);
	void deletePiirivalvurAuasteById(Long id);
	List<PiirivalvurAuaste> getAllPiirivalvurAuastes();
	PiirivalvurAuaste getPiirivalvurAuasteById(Long id);
}
