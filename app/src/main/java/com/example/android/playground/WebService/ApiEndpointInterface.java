package com.example.android.playground.WebService;

import com.example.android.playground.WebService.Entities.Authentication;
import com.example.android.playground.WebService.Entities.PopularMoviesGson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpointInterface {

    @GET("authentication/token/new?")
    Call<Authentication> getAuthToken(@Query("api_key") String apikey);

    @GET("movie/popular?")
    Call<PopularMoviesGson> getPopularMovies(@Query("api_key") String apiKey);
}
