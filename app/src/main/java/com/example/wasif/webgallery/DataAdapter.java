package com.example.wasif.webgallery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
* Created by wasif on 7/24/16.
*/

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<WebImage> imageUrlList;
    private Context context;

    public DataAdapter(Context context, ArrayList<WebImage> imageUrlList) {
        this.imageUrlList = imageUrlList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context).load(imageUrlList.get(position).getImage_thumb_url()).resize(200, 200).into(holder.iv);
        holder.setWebImage(imageUrlList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageUrlList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView iv;
        private WebImage webimg;

        public ViewHolder(View itemView) {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.web_image);
            iv.setOnClickListener(this);
        }

        private void setWebImage(WebImage webimg)
        {
            this.webimg = webimg;
        }
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), DisplayImageActivity.class);

            intent.putExtra("url", webimg.getImage_url());
            view.getContext().startActivity(intent);


        }
    }
}


