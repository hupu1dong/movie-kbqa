package us.codecraft.crawler.model;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.crawler.MovieCrawler;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:28
 */
@TargetUrl("https://movie.douban.com/subject/*")
@HelpUrl("https://movie.douban.com/top250?start=\\d+")
public class MovieInfo implements AfterExtractor {
    @ExtractBy("//*[@id=\"content\"]/h1/span[1]/text()")
    private String movie_title="";
    @ExtractBy("//*[@id=\"link-report\"]/span[1]/text()")
    private String movie_introduction="";
    @ExtractBy("//*[@id=\"interest_sectl\"]/div[1]/div[2]/strong/text()")
    private String movie_rating="";
    @ExtractBy("//*[@id=\"info\"]/span[10]/text()")
    private String movie_release_date="";
    @ExtractBy("//*[@id=\"celebrities\"]/ul/li[2]/div/span[1]/a/@href")
    private String person_url="";




    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_introduction() {
        return movie_introduction;
    }

    public void setMovie_introduction(String movie_introduction) {
        this.movie_introduction = movie_introduction;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }

    public String getMovie_release_date() {
        return movie_release_date;
    }

    public void setMovie_release_date(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "movie_title='" + movie_title + '\'' +
                ", movie_introduction='" + movie_introduction + '\'' +
                ", movie_rating='" + movie_rating + '\'' +
                ", movie_release_date='" + movie_release_date + '\'' +
                '}';
    }

    @Override
    public void afterProcess(Page page) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final PersonProcess personProcess = applicationContext.getBean(PersonProcess.class);
        Selectable url = page.getUrl();
        System.err.println("当前爬取的链接为："+url);
        personProcess.crawer(person_url);

    }
}
