package github.loktra.com.github.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import github.loktra.com.github.R;
import github.loktra.com.github.adapter.CommitsAdapter;
import github.loktra.com.github.model.CommitsResponse;
import github.loktra.com.github.rest.ApiClient;
import github.loktra.com.github.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerViewCommits = (RecyclerView) findViewById(R.id.recycler_view_commits);
        recyclerViewCommits.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<CommitsResponse>> call = apiService.getCommits();
        call.enqueue(new Callback<List<CommitsResponse>>() {
            @Override
            public void onResponse(Call<List<CommitsResponse>> call, Response<List<CommitsResponse>> response) {
                List<CommitsResponse> commitsResponseList = new ArrayList<CommitsResponse>(response.body());
                // Grouping
                Collections.sort(commitsResponseList);
                recyclerViewCommits.setAdapter(new CommitsAdapter(commitsResponseList, R.layout.list_item_commit, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<CommitsResponse>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
