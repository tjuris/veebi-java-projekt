package ee.itcollege.i377.repository;

import java.util.List;
import ee.itcollege.i377.model.PiirivalvurAuaste;

public interface PiirivalvurAuasteDao {

	void addPiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste);
	void updatePiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste);
	void deletePiirivalvurAuasteById(Long id);
	List<PiirivalvurAuaste> getAllPiirivalvurAuastes();
	PiirivalvurAuaste getPiirivalvurAuasteById(Long id);
}
