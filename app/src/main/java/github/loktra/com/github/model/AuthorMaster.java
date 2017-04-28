package github.loktra.com.github.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mihir on 4/28/2017.
 */

public class AuthorMaster {
    @SerializedName("id")
    private String authorID;
    @SerializedName("avatar_url")
    private String avatarURL;

    public String getAvatarURL() {
        return avatarURL;
    }

    public String getAuthorID() {
        return authorID;
    }
}
