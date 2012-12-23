package ee.itcollege.i377.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.itcollege.i377.model.VahtkonnaLiige;
import ee.itcollege.i377.repository.VahtkonnaLiigeDao;

@Service
public class VahtkonnaLiigeServiceImpl implements VahtkonnaLiigeService {
	
	@Resource
	private VahtkonnaLiigeDao vahtkonnaLiigeDao;

	@Override
	public void addVahtkonnaLiige(VahtkonnaLiige vahtkonnaLiige) {
		vahtkonnaLiigeDao.addVahtkonnaLiige(vahtkonnaLiige);
	}

	@Override
	public void updateVahtkonnaLiige(VahtkonnaLiige vahtkonnaLiige) {
		vahtkonnaLiigeDao.updateVahtkonnaLiige(vahtkonnaLiige);
	}
	
	@Override
	public void deleteVahtkonnaLiigeById(Long id) {
		vahtkonnaLiigeDao.deleteVahtkonnaLiigeById(id);
	}
	
	@Override
	public VahtkonnaLiige getVahtkonnaLiigeById(Long id) {
		return vahtkonnaLiigeDao.getVahtkonnaLiigeById(id);
	}
	
	@Override
	public List<VahtkonnaLiige> getAllVahtkonnaLiiges() {
		return vahtkonnaLiigeDao.getAllVahtkonnaLiiges();
	}

}
