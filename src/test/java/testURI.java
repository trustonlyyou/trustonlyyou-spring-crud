import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/config/*.xml"}
)
@WebAppConfiguration
public class testURI {

    private static final Logger logger = LoggerFactory.getLogger(testURI.class);

    @Test
    public void testURI() throws Exception {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/crowdfunding/free/board/deatail/")
                .queryParam("page", 2)
                .queryParam("perPageNum", 20)
                .build()
                ;
        logger.info("/crowdfunding/free/board/detail/?num=119");
        logger.info(uriComponents.toString());
        //http://localhost:8080/crowdfunding/free/board/detail/?num=119
    }
}
