package us.codecraft.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.crawler.model.MovieInfo;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:19
 */
@Component
public class MovieCrawler {

    @Qualifier("MovieInfoDaoPipeline")
    @Autowired
    private PageModelPipeline movieInfoDaoPipeline;

    public void crawl() {
        OOSpider.create(Site.me()
                        .setSleepTime(1000)
                        .setRetryTimes(80)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36"),movieInfoDaoPipeline, MovieInfo.class)
                .addUrl("https://movie.douban.com/top250?start=0")
                .thread(5)
                .run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final MovieCrawler movieCrawler = applicationContext.getBean(MovieCrawler.class);
        movieCrawler.crawl();
    }
}
