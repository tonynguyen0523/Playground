package com.example.android.playground.ui.activity.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.playground.R;
import com.example.android.playground.WebService.Entities.PopularMoviesGson;
import com.example.android.playground.constant.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tonynguyen on 11/19/17.
 */

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private List<PopularMoviesGson.ResultsBean> mList;
    private Context mContext;

    public PopularAdapter(Context context, List<PopularMoviesGson.ResultsBean> list){
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String name = mList.get(position).getTitle();
        String releaseDate = mList.get(position).getRelease_date();
        String posterPath = mList.get(position).getPoster_path();

        holder.mPopularName.setText(name);
        holder.mReleaseDate.setText(releaseDate);

        Picasso.with(mContext).load(Constants.BASE_IMAGE_URL + posterPath)
                .into(holder.mPosterImage);
        Picasso.with(mContext).load(Constants.BASE_IMAGE_URL + posterPath)
                .into(holder.mThumbnail);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mPopularName;
        private TextView mReleaseDate;
        private ImageView mPosterImage;
        private ImageView mThumbnail;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mPopularName = itemView.findViewById(R.id.popular_name);
            mReleaseDate = itemView.findViewById(R.id.release_date);
            mPosterImage = itemView.findViewById(R.id.poster_image);
            mThumbnail = itemView.findViewById(R.id.poster_thumbnail);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
