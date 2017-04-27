package github.loktra.com.github.rest;

import github.loktra.com.github.model.CommitsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;


public interface ApiInterface {
    @GET("rails/commits")
    Call<List<CommitsResponse>> getCommits();
}
