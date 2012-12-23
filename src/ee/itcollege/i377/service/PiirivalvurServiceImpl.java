package ee.itcollege.i377.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.itcollege.i377.model.Piirivalvur;
import ee.itcollege.i377.repository.PiirivalvurDao;

@Service
public class PiirivalvurServiceImpl implements PiirivalvurService {
	
	@Resource
	private PiirivalvurDao piirivalvurDao;

	@Override
	public void addPiirivalvur(Piirivalvur piirivalvur) {
		piirivalvurDao.addPiirivalvur(piirivalvur);
	}

	@Override
	public void updatePiirivalvur(Piirivalvur piirivalvur) {
		piirivalvurDao.updatePiirivalvur(piirivalvur);
	}
	
	@Override
	public void deletePiirivalvurById(Long id) {
		piirivalvurDao.deletePiirivalvurById(id);
	}
	
	@Override
	public Piirivalvur getPiirivalvurById(Long id) {
		return piirivalvurDao.getPiirivalvurById(id);
	}
	
	@Override
	public List<Piirivalvur> getAllPiirivalvurs() {
		return piirivalvurDao.getAllPiirivalvurs();
	}

}
