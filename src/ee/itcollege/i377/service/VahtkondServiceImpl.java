package ee.itcollege.i377.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.itcollege.i377.model.Vahtkond;
import ee.itcollege.i377.repository.VahtkondDao;

@Service
public class VahtkondServiceImpl implements VahtkondService {
	
	@Resource
	private VahtkondDao vahtkondDao;

	@Override
	public void addVahtkond(Vahtkond vahtkond) {
		vahtkondDao.addVahtkond(vahtkond);
	}

	@Override
	public void updateVahtkond(Vahtkond vahtkond) {
		vahtkondDao.updateVahtkond(vahtkond);
	}
	
	@Override
	public void deleteVahtkondById(Long id) {
		vahtkondDao.deleteVahtkondById(id);
	}
	
	@Override
	public Vahtkond getVahtkondById(Long id) {
		return vahtkondDao.getVahtkondById(id);
	}
	
	@Override
	public List<Vahtkond> getAllVahtkonds() {
		return vahtkondDao.getAllVahtkonds();
	}

}
