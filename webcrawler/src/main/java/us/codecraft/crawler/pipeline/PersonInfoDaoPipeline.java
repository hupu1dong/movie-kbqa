package us.codecraft.crawler.pipeline;


import org.springframework.stereotype.Component;
import us.codecraft.crawler.dao.PersonInfoDAO;
import us.codecraft.crawler.model.Person;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component
public class PersonInfoDaoPipeline implements Pipeline {

    @Resource
    PersonInfoDAO personInfoDAO;
    @Override
    public void process(ResultItems resultItems, Task task) {
        Person person = (Person) resultItems.get("person");
        personInfoDAO.add(person);
    }



}
