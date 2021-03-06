package top.a1bum.utils;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

@SuppressWarnings("restriction")
public class VersionInformation {
	// 获取管理构件
	OperatingSystemMXBean osMxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

	public String getSysInfo() {
		Properties props = System.getProperties();
		//获取操作系统名称
		return props.getProperty("os.name");
	}

	public String getMysqlInfo() {
		Properties props = new Properties();
		String mysqlVersion = "";
		try {
			props.load(VersionInformation.class.getResourceAsStream("/dbconfig.properties"));
			Class.forName(props.getProperty("jdbc-driver"));
			Connection con = DriverManager.getConnection(props.getProperty("jdbc-url"), props.getProperty("jdbc-user"),
					props.getProperty("jdbc-pwd"));
			// 通过数据库元信息获取数据库版本
			DatabaseMetaData dmd = con.getMetaData();
			mysqlVersion = dmd.getDatabaseProductVersion().split("-0")[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mysqlVersion;
	}

	public String getCpuInfo() {
		Integer cpuLoad = (int) (osMxBean.getSystemCpuLoad()*100);
		return cpuLoad.toString();
	}
	
	public String getMemInfo() {
		// 获取物理内存总量
		double total = osMxBean.getTotalPhysicalMemorySize();
		// 获取物力内存剩余
		double free = osMxBean.getFreePhysicalMemorySize();
		Integer memLoad = (int) ((total-free)/total*100);
		return memLoad.toString();
	}
}
