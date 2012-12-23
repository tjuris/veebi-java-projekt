package ee.itcollege.i377.repository;

import java.util.List;
import ee.itcollege.i377.model.Piirivalvur;

public interface PiirivalvurDao {

	void addPiirivalvur(Piirivalvur piirivalvur);
	void updatePiirivalvur(Piirivalvur piirivalvur);
	void deletePiirivalvurById(Long id);
	List<Piirivalvur> getAllPiirivalvurs();
	Piirivalvur getPiirivalvurById(Long id);
}
