package top.magiczjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.magiczjk.dao.DataDao;
import top.magiczjk.entity.Lovely;

@Service
public class DataService {

	@Autowired
	private DataDao dataDao;

	public List<Lovely> getLovelys(String pageSize, String pageNum) {
		return dataDao.getLovelys(pageSize, pageNum);
	}

	public void save(Lovely lovely) {
		dataDao.save(lovely);
	}

}
