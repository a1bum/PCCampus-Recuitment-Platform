package top.a1bum.utils;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

@SuppressWarnings("restriction")
public class VersionInformation {
	OperatingSystemMXBean osMxBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

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
		Integer cpuLoad = (int) (osMxBean.getSystemCpuLoad()*100);
		return cpuLoad.toString();
	}
	
	public String getMemInfo() {
		double total = osMxBean.getTotalPhysicalMemorySize();
		double free = osMxBean.getFreePhysicalMemorySize();
		Integer memLoad = (int) ((total-free)/total*100);
		return memLoad.toString();
	}

}
