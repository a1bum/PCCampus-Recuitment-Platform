
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {
	
	
	public static void main(String[]args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/wxminiprogram";
		String user = "root";
		String pwd = "toor";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pwd);
			Statement stat = con.createStatement();
			String sql = "select * from admin_info";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
