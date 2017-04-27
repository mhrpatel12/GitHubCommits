package github.loktra.com.github.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mihir on 4/28/2017.
 */

public class Author {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
