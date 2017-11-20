package com.example.android.playground.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.playground.R;

public class LoginActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Gson gson = new GsonBuilder().create();
//
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create(gson))
//                        .build();
//
//                final ApiEndpointInterface apiEndpointInterface =
//                        retrofit.create(ApiEndpointInterface.class);
//
//                Call<Authentication> call = apiEndpointInterface
//                        .getAuthToken(BuildConfig.OPEN_MOVIE_API_KEY);
//
//                call.enqueue(new Callback<Authentication>() {
//                    @Override
//                    public void onResponse(@NonNull Call<Authentication> call, @NonNull Response<Authentication> response) {
//                        Authentication authentication = response.body();
//                        String token = authentication.getRequestToken();
//
//                        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
//                                Uri.parse("https://www.themoviedb.org/authenticate/" + token));
//                        startActivity(browserIntent);
//
//                    }
//
//                    @Override
//                    public void onFailure(@NonNull Call<Authentication> call, @NonNull Throwable t) {
//
//                    }
//                });

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
