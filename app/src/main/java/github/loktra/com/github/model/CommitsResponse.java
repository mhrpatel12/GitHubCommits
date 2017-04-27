package github.loktra.com.github.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mihir on 4/28/2017.
 */

public class CommitsResponse {
    @SerializedName("commit")
    private Commit commit;
    @SerializedName("author")
    public AuthorMaster authorMaster;

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public AuthorMaster getAuthorMaster() {
        return authorMaster;
    }

    public void setAuthorMaster(AuthorMaster authorMaster) {
        this.authorMaster = authorMaster;
    }
}
