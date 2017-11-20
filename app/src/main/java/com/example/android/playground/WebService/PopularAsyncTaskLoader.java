package com.example.android.playground.WebService;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.android.playground.BuildConfig;
import com.example.android.playground.WebService.Entities.PopularMoviesGson;
import com.example.android.playground.constant.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PopularAsyncTaskLoader extends AsyncTaskLoader<List<PopularMoviesGson.ResultsBean>> {

    private List<PopularMoviesGson.ResultsBean> result;

    public PopularAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {

        if (result != null) {
            deliverResult(result);
        } else {
            forceLoad();
        }
    }

    @Override
    public List<PopularMoviesGson.ResultsBean> loadInBackground() {

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiEndpointInterface apiEndpointInterface =
                retrofit.create(ApiEndpointInterface.class);
        Call<PopularMoviesGson> call = apiEndpointInterface.getPopularMovies(BuildConfig.OPEN_MOVIE_API_KEY);

        String mResponse = null;
        List<PopularMoviesGson.ResultsBean> popularList = null;

        try {
            Response<PopularMoviesGson> response = call.execute();
            if (response.isSuccessful()) {
                popularList = response.body().getResults();
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return popularList;
    }


    @Override
    public void deliverResult(List<PopularMoviesGson.ResultsBean> data) {
        result = data;
        super.deliverResult(data);
    }
}
