package com.example.android.playground.ui.activity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.android.playground.R;
import com.example.android.playground.WebService.Entities.PopularMoviesGson;
import com.example.android.playground.WebService.PopularAsyncTaskLoader;
import com.example.android.playground.ui.activity.Adapter.PopularAdapter;

import java.util.List;

public class PopularFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<PopularMoviesGson.ResultsBean>> {

    private static final int LOADER = 1;

    private RecyclerView mPopularListView;
    private FloatingActionButton mFab;
    private Toolbar mToolbar;

    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.popular_fragment, container, false);

        mPopularListView = rootView.findViewById(R.id.popular_list);
        mToolbar = rootView.findViewById(R.id.popular_toolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        mFab = rootView.findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction()
                        .setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
                        .replace(R.id.container,secondFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(LOADER, null, this);

    }

    @Override
    public Loader<List<PopularMoviesGson.ResultsBean>> onCreateLoader(int id, Bundle args) {
        return new PopularAsyncTaskLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<PopularMoviesGson.ResultsBean>> loader, List<PopularMoviesGson.ResultsBean> data) {

        int resId = R.anim.layout_fall;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(),resId);
        mPopularListView.setLayoutAnimation(animation);
        mPopularListView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        mPopularListView.setAdapter(new PopularAdapter(getContext(), data));


    }

    @Override
    public void onLoaderReset(Loader<List<PopularMoviesGson.ResultsBean>> loader) {

    }
}
