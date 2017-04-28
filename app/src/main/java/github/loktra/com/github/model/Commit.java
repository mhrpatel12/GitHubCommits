package github.loktra.com.github.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mihir on 4/28/2017.
 */

public class Commit {
    @SerializedName("author")
    public Author author;
    @SerializedName("message")
    private String commitMessage;

    public Author getAuthor() {
        return author;
    }

    public String getCommitMessage() {
        return commitMessage;
    }
}
