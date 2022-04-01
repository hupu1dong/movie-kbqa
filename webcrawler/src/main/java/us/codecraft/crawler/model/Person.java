package us.codecraft.crawler.model;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.model.annotation.ExtractBy;

/**
 * @title: Person
 * @Author ZhangGuanYi
 * @Date: 2022/3/31 18:28
 * @Version 1.0
 */
@Component
public class Person {
    private String person_birth_day="";
    private String person_death_day="";
    private String person_name="";
    private String person_english_name="";
    private String person_biography="";
    private String person_birth_place="";

    @Override
    public String toString() {
        return "Person{" +
                "person_birth_day='" + person_birth_day + '\'' +
                ", person_death_day='" + person_death_day + '\'' +
                ", person_name='" + person_name + '\'' +
                ", person_english_name='" + person_english_name + '\'' +
                ", person_biography='" + person_biography + '\'' +
                ", person_birth_place='" + person_birth_place + '\'' +
                '}';
    }

    public String getPerson_birth_day() {
        return person_birth_day;
    }

    public void setPerson_birth_day(String person_birth_day) {
        this.person_birth_day = person_birth_day;
    }

    public String getPerson_death_day() {
        return person_death_day;
    }

    public void setPerson_death_day(String person_death_day) {
        this.person_death_day = person_death_day;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_english_name() {
        return person_english_name;
    }

    public void setPerson_english_name(String person_english_name) {
        this.person_english_name = person_english_name;
    }

    public String getPerson_biography() {
        return person_biography;
    }

    public void setPerson_biography(String person_biography) {
        this.person_biography = person_biography;
    }

    public String getPerson_birth_place() {
        return person_birth_place;
    }

    public void setPerson_birth_place(String person_birth_place) {
        this.person_birth_place = person_birth_place;
    }
}
