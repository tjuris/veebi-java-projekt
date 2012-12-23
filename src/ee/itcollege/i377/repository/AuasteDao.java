package ee.itcollege.i377.repository;

import java.util.List;
import ee.itcollege.i377.model.Auaste;

public interface AuasteDao {

	void addAuaste(Auaste auaste);
	void updateAuaste(Auaste auaste);
	void deleteAuasteById(Long id);
	List<Auaste> getAllAuastes();
	Auaste getAuasteById(Long id);
}
