package com.example.joblisting.Model;
import java.util.Arrays;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



@Document(collection = "JobPost")
public class Post {
    @NotBlank(message = "Profile is required")
    private String profile;

    @NotBlank(message = "Description cannot be empty")
    private String desc;

    @Min(value = 0, message = "Experience must be 0 or greater")
    private int exp;

    @NotEmpty(message = "At least one technology is required")
    private String[] techs;

    // getters, setters, toString() ...

    public Post() {
    }

    public String getProfile() {
        return profile;
    }  
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public String[] getTechs() {
        return techs;
    }
    public void setTechs(String[] techs) {
        this.techs = techs;
    }
    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }

}