package us.codecraft.crawler.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.crawler.pipeline.PersonInfoDaoPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:28
 */

@Component
public class PersonProcess implements PageProcessor {

    @Autowired
    PersonInfoDaoPipeline personInfoDaoPipeline;

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
            .setRetryTimes(30)
            .setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36");


    @Override
    public void process(Page page) {
        Person person = new Person();
        String bd = page.getHtml().xpath("//*[@id=\"headline\"]/div[2]/ul/li[3]/text()").toString();
        String[] split = bd.split(" ");
        if (split.length < 4) {
            page.putField("birth",split[2]);
            person.setPerson_birth_day(split[2]);
            person.setPerson_death_day("还未死亡");
        }else {
            page.putField("birth",split[2]);
            page.putField("death",split[4]);
            person.setPerson_birth_day(split[2]);
            person.setPerson_death_day(split[4]);
        }
        String eh = page.getHtml().xpath("//*[@id=\"content\"]/h1/text()").toString();
        String[] s2 = eh.split(" ");
        page.putField("name",s2[0]);
        person.setPerson_name(s2[0]);
        page.putField("ename",s2[1]+" "+s2[2]);
        person.setPerson_english_name(s2[1]+" "+s2[2]);
        String intro1 = page.getHtml().xpath(("//*[@id=\"intro\"]/div[2]/span[2]/text()")).toString();
        String intro2 = page.getHtml().xpath(("//*[@id=\"intro\"]/div[2]/text()")).toString();
        if (intro1 != null) {
            person.setPerson_biography(intro1);
        }else {
            person.setPerson_biography(intro2);
        }
//        page.putField("person_biography",page.getHtml().xpath(("//*[@id=\"intro\"]/div[2]/span[1]/text()")).toString());
//        person.setPerson_biography(page.getHtml().xpath(("//*[@id=\"intro\"]/div[2]/span[1]/text()")).toString());
        page.putField("person_birth_place",page.getHtml().xpath((("//*[@id=\"headline\"]/div[2]/ul/li[4]/text()"))).toString());
        person.setPerson_birth_place(page.getHtml().xpath((("//*[@id=\"headline\"]/div[2]/ul/li[4]/text()"))).toString());

        if (person.getPerson_name() == null) {
            //skip this page
            page.setSkip(true);
        } else {
            page.putField("person", person);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void crawer(String url) {
        Spider.create(new PersonProcess())
                .addUrl(url)
                .thread(1)
                .addPipeline(personInfoDaoPipeline)
                //启动爬虫
                .run();
    }
}

