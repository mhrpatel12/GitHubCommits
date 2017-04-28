package github.loktra.com.github.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Mihir on 4/28/2017.
 */

public class Author {
    @SerializedName("name")
    private String name;

    @SerializedName("date")
    private Date date;

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
