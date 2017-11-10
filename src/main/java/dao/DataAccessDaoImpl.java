package dao;

import vo.Smdown;

import java.sql.SQLException;
import java.util.List;

public class DataAccessDaoImpl extends BaseIbatisDao implements DataAccessDao {


	public void insertSmdownList(List<Smdown> smList) throws SQLException {
		sqlMap.startBatch();
		for(Smdown sm : smList){
		    sqlMap.insert("DataAccess.insertSmdown", sm);
		}
		sqlMap.executeBatch();
		
	}

	
	

}
