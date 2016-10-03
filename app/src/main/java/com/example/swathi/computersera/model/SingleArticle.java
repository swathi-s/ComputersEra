package com.example.swathi.computersera.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 10/3/2016.
 */
public class SingleArticle {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("postedDate")
    private String postedDate;

    @SerializedName("PostedBy")
    private String postedBy;

    @SerializedName("article_pic")
    private String articalPic;

    @SerializedName("about_author")
    private String aboutAuthor;

    public SingleArticle(Integer id, String title, String description, String postedDate, String postedBy, String image, String aboutAuthor)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postedDate = postedDate;
        this.postedBy = postedBy;
        this.articalPic = image;
        this.aboutAuthor = aboutAuthor;
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

    public String getArticalPic() {
        return articalPic;
    }

    public void setArticalPic(String articalPic) {
        this.articalPic = articalPic;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }
}
