package top.a1bum.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

public class VersionInformation {

	public String getSysInfo() {
		Properties props = System.getProperties();
		return props.getProperty("os.name");
	}

	public String getMysqlInfo() {
		Properties props = new Properties();
		String mysqlVersion = "";
		try {
			props.load(VersionInformation.class.getResourceAsStream("/dbconfig.properties"));
			Class.forName(props.getProperty("driver"));
			Connection con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"),
					props.getProperty("pwd"));
			DatabaseMetaData dmd = con.getMetaData();
			mysqlVersion = dmd.getDatabaseProductVersion().split("-0")[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mysqlVersion;
	}

	public String getCpuInfo() {
		OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
		Integer cpuLoad = (int) (osMxBean.getSystemLoadAverage()*100);
		return cpuLoad.toString();
	}
	
	public String getMemInfo() {
		Long total = Runtime.getRuntime().totalMemory();
		Long free = Runtime.getRuntime().freeMemory();
		Long memLoad = (total-free)*100/total;
		return memLoad.toString();
	}

}
