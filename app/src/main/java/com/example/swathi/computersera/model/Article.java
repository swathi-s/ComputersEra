package com.example.swathi.computersera.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 9/30/2016.
 */
public class Article {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("posted_date")
    private String postedDate;

    @SerializedName("posted_by")
    private String postedBy;

    public Article(Integer id, String title, String description, String postedDate, String postedBy)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postedDate = postedDate;
        this.postedBy = postedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
