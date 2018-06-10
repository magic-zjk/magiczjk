package top.magiczjk.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import top.magiczjk.entity.Lovely;

@Repository
public class DataDao extends BasicDAO<Lovely, Datastore> {

	private Logger log = Logger.getLogger(DataDao.class);

	@Autowired(required = true)
	public DataDao(@Qualifier("dataStore") Datastore ds) {
		super(ds);
	}

	public List<Lovely> getLovelys(String pageSize, String pageNum) {
		Query<Lovely> q = getDatastore().createQuery(Lovely.class);
		FindOptions options = new FindOptions();
		options.skip(Integer.valueOf(pageNum));
		options.limit(Integer.valueOf(pageSize));
		q.order("-createdAt");
		List<Lovely> asList = q.asList(options);
		return asList;
		
	}
	
	

}