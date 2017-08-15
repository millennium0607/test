package user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.istack.internal.logging.Logger;
import com.wjb.db.po.UserT;
import com.wjb.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void test1(){
		UserT userT= userService.getUserById(1);
		logger.info(userT.getUserName()+"---------------"+userT.getPassword()+"------------------"+userT.getAge());
	}
}
