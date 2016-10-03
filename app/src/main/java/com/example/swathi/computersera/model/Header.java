package com.example.swathi.computersera.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 9/30/2016.
 */
public class Header {

    @SerializedName("id")
    private Integer id;

    @SerializedName("heading")
    private String heading;

    public Header(Integer id, String heading)
    {
        this.id = id;

        this.heading = heading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
