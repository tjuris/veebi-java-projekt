package ee.itcollege.i377.repository;

import java.util.List;
import ee.itcollege.i377.model.Vahtkond;

public interface VahtkondDao {

	void addVahtkond(Vahtkond vahtkond);
	void updateVahtkond(Vahtkond vahtkond);
	void deleteVahtkondById(Long id);
	List<Vahtkond> getAllVahtkonds();
	Vahtkond getVahtkondById(Long id);
}
