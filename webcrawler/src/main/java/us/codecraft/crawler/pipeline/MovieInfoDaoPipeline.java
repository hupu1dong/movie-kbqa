package us.codecraft.crawler.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.crawler.dao.MovieInfoDAO;
import us.codecraft.crawler.model.MovieInfo;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午8:56
 */
@Component("MovieInfoDaoPipeline")
public class MovieInfoDaoPipeline implements PageModelPipeline<MovieInfo> {

    @Resource
    private MovieInfoDAO movieInfoDAO;

    @Override
    public void process(MovieInfo movieInfo, Task task) {
        movieInfoDAO.add(movieInfo);
    }
}
