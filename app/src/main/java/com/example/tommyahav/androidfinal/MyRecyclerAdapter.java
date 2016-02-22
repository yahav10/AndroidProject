package com.example.tommyahav.androidfinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by TomGoldberg on 24.12.15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter< MyRecyclerAdapter.CustomViewHolder > {
    private List<group_info_recycle_item> feedItemList;
    private Context mContext;

    public MyRecyclerAdapter(Context context, List<group_info_recycle_item> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        System.out.println("-->onBindViewHolder");
        group_info_recycle_item feedItem = feedItemList.get(i);

        //Download image using picasso library
        Picasso.with(mContext).load(feedItem.getPersonPic())
                .error(R.drawable.logonew1)
                .placeholder(R.drawable.logonew1)
                .into(customViewHolder._personPic);

        Picasso.with(mContext).load(feedItem.getPersonThumbnail())
                .error(R.drawable.logonew1)
                .placeholder(R.drawable.logonew1)
                .into(customViewHolder._personIcon);


        //Setting text view title
        //customViewHolder._h1.setText(Html.fromHtml(feedItem.getPersonH1()));
        customViewHolder._h1.setText("Some initial text one");
        customViewHolder._h2.setText("Some initial text two");

        //customViewHolder._h1.setOnClickListener(clickListener);
        //customViewHolder._personPic.setOnClickListener(clickListener);
        customViewHolder.itemView.setOnClickListener(clickListener);
        //(RecyclerView.ViewHolder)this.setOnClickListener(clickListener);

        //customViewHolder._h1.setTag(customViewHolder);
        //customViewHolder._personPic.setTag(customViewHolder);
        customViewHolder.itemView.setTag(customViewHolder);

    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CustomViewHolder holder = (CustomViewHolder) view.getTag();
            int position = holder.getPosition();
            group_info_recycle_item feedItem = feedItemList.get(position);
            Toast.makeText(mContext, feedItem.getPersonH1(), Toast.LENGTH_SHORT).show();

            removeAt(position);
        }
    };

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView _h1;
        protected TextView _h2;
        protected ImageView _personPic;
        protected ImageView _personIcon;

        public CustomViewHolder(View view) {
            super(view);
            this._personPic = (ImageView) view.findViewById(R.id.listItemPersonPic);
            this._h1 = (TextView) view.findViewById(R.id.itemh1);
            this._h2 = (TextView) view.findViewById(R.id.itemh2);
            this._personIcon = (ImageView) view.findViewById(R.id.item_icon);
            System.out.println("Original CustomViewHolder C'tor with" + this.toString());
        }


    }

    public void removeAt(int position) {
        feedItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, feedItemList.size());
    }

}