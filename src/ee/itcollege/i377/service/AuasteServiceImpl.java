package ee.itcollege.i377.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.itcollege.i377.model.Auaste;
import ee.itcollege.i377.repository.AuasteDao;

@Service
public class AuasteServiceImpl implements AuasteService {
	
	@Resource
	private AuasteDao auasteDao;

	@Override
	public void addAuaste(Auaste auaste) {
		auasteDao.addAuaste(auaste);
	}

	@Override
	public void updateAuaste(Auaste auaste) {
		auasteDao.updateAuaste(auaste);
	}
	
	@Override
	public void deleteAuasteById(Long id) {
		auasteDao.deleteAuasteById(id);
	}
	
	@Override
	public Auaste getAuasteById(Long id) {
		return auasteDao.getAuasteById(id);
	}
	
	@Override
	public List<Auaste> getAllAuastes() {
		return auasteDao.getAllAuastes();
	}

}
