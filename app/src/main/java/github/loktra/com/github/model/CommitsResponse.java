package github.loktra.com.github.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mihir on 4/28/2017.
 */

public class CommitsResponse implements Comparable<CommitsResponse> {
    @SerializedName("author")
    public AuthorMaster authorMaster;
    @SerializedName("commit")
    private Commit commit;

    public Commit getCommit() {
        return commit;
    }

    public AuthorMaster getAuthorMaster() {
        return authorMaster;
    }

    @Override
    public int compareTo(@NonNull CommitsResponse o) {
        int i = authorMaster.getAuthorID().compareTo(o.getAuthorMaster().getAuthorID());
        if (i != 0) return i;

        i = commit.getAuthor().getDate().compareTo(o.getCommit().getAuthor().getDate());
        return i;
    }
}
