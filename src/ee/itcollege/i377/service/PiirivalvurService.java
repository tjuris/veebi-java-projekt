package ee.itcollege.i377.service;

import java.util.List;

import ee.itcollege.i377.model.Piirivalvur;

public interface PiirivalvurService {
	void addPiirivalvur(Piirivalvur piirivalvur);
	void updatePiirivalvur(Piirivalvur piirivalvur);
	void deletePiirivalvurById(Long id);
	List<Piirivalvur> getAllPiirivalvurs();
	Piirivalvur getPiirivalvurById(Long id);
}
