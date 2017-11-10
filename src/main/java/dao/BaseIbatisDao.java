package dao;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import org.apache.log4j.Logger;

import java.io.Reader;

public class BaseIbatisDao {
    private static BaseIbatisDao instance = new BaseIbatisDao();
    private static Logger log = Logger.getLogger(BaseIbatisDao.class.getName());
    protected static final SqlMapClient sqlMap;

    static {
        try {
            log.debug("Attempting to initialize SqlMap");
            String resource = "dao/sql/SqlMapConfig.xml";
            Resources.setDefaultClassLoader(BaseIbatisDao.class.getClassLoader());
            Reader reader = Resources.getResourceAsReader(BaseIbatisDao.class.getClassLoader(),resource);
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
            log.debug("Initialized SqlMap");
        } catch (Exception e) {
            log.error("Error intializing BaseIbatisDao ", e);
            throw new RuntimeException("Error initializing BaseIbatisDao class. Cause: " + e);
        }
    }

    protected BaseIbatisDao() {
    }

    public static BaseIbatisDao getInstance() {
        return instance;
    }
}
