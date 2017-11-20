package com.example.android.playground.ui.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.android.playground.R;

public class WebViewFragment extends Fragment {

    private static final String AUTH_TOKEN = "auth_token";

    private String mAuthToken;


    public WebViewFragment() {
        // Required empty public constructor
    }

    public static WebViewFragment newInstance(String authToken) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(AUTH_TOKEN, authToken);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAuthToken = getArguments().getString(AUTH_TOKEN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_web_view, container, false);

        WebView webView = rootView.findViewById(R.id.web_view);
        webView.loadUrl("https://www.themoviedb.org/authenticate/" + mAuthToken);


        return rootView;
    }

}


