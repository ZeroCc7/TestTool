package dao;

import vo.Smdown;

import java.sql.SQLException;
import java.util.List;


public interface DataAccessDao {


	void insertSmdownList(List<Smdown> sm) throws SQLException;
	
	
	
}
