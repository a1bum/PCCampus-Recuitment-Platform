import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.a1bum.dao.LoginHistoryMapper;
import top.a1bum.entity.LoginHistory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestLoginHistory {
	@Autowired
	LoginHistoryMapper mapper;
	
	
	@Test
	public void testAdd() {
		System.out.println(mapper.addLoginHistory(new LoginHistory("root", "chrome", "123", "73", "windows10", "computer", "127.0.0.1", 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))));
	}
}
