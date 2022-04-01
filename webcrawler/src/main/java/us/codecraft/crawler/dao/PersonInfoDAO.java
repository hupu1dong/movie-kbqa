package us.codecraft.crawler.dao;

import org.apache.ibatis.annotations.Insert;
import us.codecraft.crawler.model.MovieInfo;
import us.codecraft.crawler.model.Person;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:27
 */
public interface PersonInfoDAO {

    @Insert("insert into person (`person_birth_day`,`person_death_day`,`person_name`,`person_english_name`,`person_biography`,`person_birth_place`) values (#{person_birth_day},#{person_death_day},#{person_name},#{person_english_name},#{person_biography},#{person_birth_place})")
    public int add(Person person);
}
