package user;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.istack.internal.logging.Logger;
import com.wjb.db.po.Post;
import com.wjb.db.po.User;
import com.wjb.service.PostService;
import com.wjb.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	@Autowired
	private PostService postService;

	//
	@Test
	public void test1() {
	
		List<Post> listAllPost = postService.listAllPost();

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();

		System.out.println(date);
		List<Post> outtimePostList = postService.getOuttimePostList(date);
		for (Post post : outtimePostList) {
			System.out.println(post.getPostTitle()+"----------"+post.getPostCreateTime());
		}
//		for (Post post : listAllPost) {
//			post.setPostCreateTime(date);
//			post.setPostUpdateTime(date);
//			postService.updatePoset(post);
//		}

	}
}
