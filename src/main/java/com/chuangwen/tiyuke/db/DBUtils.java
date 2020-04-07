package db;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource dataSource;
	static {
		Properties properties = new Properties();
		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(is);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			
			dataSource.setMinIdle(3);
			dataSource.setMaxIdle(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws Exception{
		Connection conn = dataSource.getConnection();
		return conn;
	}


}
