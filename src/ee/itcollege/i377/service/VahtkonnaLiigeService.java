package ee.itcollege.i377.service;

import java.util.List;

import ee.itcollege.i377.model.VahtkonnaLiige;

public interface VahtkonnaLiigeService {
	void addVahtkonnaLiige(VahtkonnaLiige vahtkonnaLiige);
	void updateVahtkonnaLiige(VahtkonnaLiige vahtkonnaLiige);
	void deleteVahtkonnaLiigeById(Long id);
	List<VahtkonnaLiige> getAllVahtkonnaLiiges();
	VahtkonnaLiige getVahtkonnaLiigeById(Long id);
}
