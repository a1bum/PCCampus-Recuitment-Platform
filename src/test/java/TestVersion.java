import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.a1bum.utils.VersionInformation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestVersion {
	VersionInformation versioninfo = new VersionInformation();
	
	@Test
	public void testGetSysInfo() {
		System.out.println(versioninfo.getSysInfo());
	}
	@Test
	public void testGetServerInfo() {
		System.out.println(versioninfo.getMysqlInfo());
	}
	
	@Test
	public void testGetCpuInfo() {
		System.out.println(versioninfo.getCpuInfo());
	}
	
	@Test
	public void testGetMemInfo() {
		System.out.println(versioninfo.getMemInfo());
	}
	
}
