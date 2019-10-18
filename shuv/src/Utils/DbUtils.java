package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
	public static Connection fetchconnection()throws Exception{
		
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@DATA:1521:orcl";
		String username="dbda24";
		String password="dbda24";
		return DriverManager.getConnection(url, username, password);
		
	}

}
