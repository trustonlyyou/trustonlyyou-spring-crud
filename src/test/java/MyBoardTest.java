import com.crowdfunding.commons.util.Criteria;
import com.crowdfunding.free.myboard.repository.MyBoardDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/config/*.xml"}
)
@WebAppConfiguration
public class MyBoardTest {

    @Autowired
    private MyBoardDao dao;

    @Test
    public void read() throws Exception {
        Map<String, Object> map = new HashMap<>();
        Criteria criteria = new Criteria();

        map.put("userId", "sszz6904");
        map.put("pageStart", criteria.getPageStart());
        map.put("perPageNum", criteria.getPerPageNum());


        System.out.println(dao.getMyBoardList(map).toString());
    }
}
