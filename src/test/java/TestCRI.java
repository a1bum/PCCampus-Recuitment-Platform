import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.a1bum.service.CRIService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestCRI {
	@Autowired
	CRIService criService;
	
	@Test
	public void testGetByCampusAndIsExpired() {
		System.out.println(criService.getByCampusAndIsExpired("兰州交通大学", 1, "2019-04-11", "00:00"));
	}
}
