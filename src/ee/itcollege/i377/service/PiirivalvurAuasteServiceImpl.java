package ee.itcollege.i377.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.itcollege.i377.model.PiirivalvurAuaste;
import ee.itcollege.i377.repository.PiirivalvurAuasteDao;

@Service
public class PiirivalvurAuasteServiceImpl implements PiirivalvurAuasteService {
	
	@Resource
	private PiirivalvurAuasteDao piirivalvurAuasteDao;

	@Override
	public void addPiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste) {
		piirivalvurAuasteDao.addPiirivalvurAuaste(piirivalvurAuaste);
	}

	@Override
	public void updatePiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste) {
		piirivalvurAuasteDao.updatePiirivalvurAuaste(piirivalvurAuaste);
	}
	
	@Override
	public void deletePiirivalvurAuasteById(Long id) {
		piirivalvurAuasteDao.deletePiirivalvurAuasteById(id);
	}
	
	@Override
	public PiirivalvurAuaste getPiirivalvurAuasteById(Long id) {
		return piirivalvurAuasteDao.getPiirivalvurAuasteById(id);
	}
	
	@Override
	public List<PiirivalvurAuaste> getAllPiirivalvurAuastes() {
		return piirivalvurAuasteDao.getAllPiirivalvurAuastes();
	}

}
