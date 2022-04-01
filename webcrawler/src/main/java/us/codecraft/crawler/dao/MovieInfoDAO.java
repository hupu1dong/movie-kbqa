package us.codecraft.crawler.dao;

import org.apache.ibatis.annotations.Insert;
import us.codecraft.crawler.model.MovieInfo;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:27
 */
public interface MovieInfoDAO {

    @Insert("insert into movie (`movie_title`,`movie_introduction`,`movie_rating`,`movie_release_date`) values (#{movie_title},#{movie_introduction},#{movie_rating},#{movie_release_date})")
    public int add(MovieInfo movieInfo);
}
