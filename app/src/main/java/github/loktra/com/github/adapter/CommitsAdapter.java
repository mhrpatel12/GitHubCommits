package github.loktra.com.github.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import github.loktra.com.github.R;
import github.loktra.com.github.model.CommitsResponse;

/**
 * Created by Mihir on 4/28/2017.
 */

public class CommitsAdapter extends RecyclerView.Adapter<CommitsAdapter.CommitsViewHolder> {

    private List<CommitsResponse> commits;
    private int rowLayout;
    private Context mContext;

    public static class CommitsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout commitsLayout;
        TextView txtAuthorName;
        TextView txtCommit;
        TextView txtCommitMessage;
        CircleImageView imgAuthorAvatar;


        public CommitsViewHolder(View v) {
            super(v);
            commitsLayout = (LinearLayout) v.findViewById(R.id.commits_layout);
            txtAuthorName = (TextView) v.findViewById(R.id.txtAuthorName);
            txtCommit = (TextView) v.findViewById(R.id.txtCommit);
            txtCommitMessage = (TextView) v.findViewById(R.id.txtCommitMessage);
            imgAuthorAvatar = (CircleImageView) v.findViewById(R.id.imgAuthorAvatar);
        }
    }

    public CommitsAdapter(List<CommitsResponse> commits, int rowLayout, Context context) {
        this.commits = commits;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @Override
    public CommitsAdapter.CommitsViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CommitsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CommitsViewHolder holder, final int position) {
        holder.txtAuthorName.setText(commits.get(position).getCommit().getAuthor().getName() + "");
        //holder.txtCommit.setText(commits.get(position).);
        holder.txtCommitMessage.setText(commits.get(position).getCommit().getCommitMessage() + "");
        Glide.with(mContext)
                .load(commits.get(position).getAuthorMaster().getAvatarURL() + "")
                .into(holder.imgAuthorAvatar);
    }

    @Override
    public int getItemCount() {
        return commits.size();
    }
}
