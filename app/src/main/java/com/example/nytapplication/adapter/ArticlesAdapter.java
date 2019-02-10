package com.example.nytapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.nytapplication.R;
import com.example.nytapplication.model.Articles;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    List<Articles> articles;
    Context context;


    public ArticlesAdapter(List<Articles> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView txtHeader;
    public TextView date;
    public ImageView icon;
    public View layout;
    public TextView byLine;
    public TextView details;
    public LinearLayout detailsLayout;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        layout = itemView;
        txtHeader = (TextView) itemView.findViewById(R.id.title);
        date = (TextView) itemView.findViewById(R.id.date);
        icon = (ImageView) itemView.findViewById(R.id.img_article_icon);
        byLine = (TextView) itemView.findViewById(R.id.byLine);
        details = (TextView) itemView.findViewById(R.id.article_details);
        detailsLayout = (LinearLayout) itemView.findViewById(R.id.details_layout);
    }
}

    @Override
    public ArticlesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.article_item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final String name = articles.get(position).getTitle();
        final String date = articles.get(position).getPublishedDate();
        final String byline = articles.get(position).getByline();
        final String details = articles.get(position).getAbstract();
        String url ="";
        if(articles.get(position).getMultimedia().size() != 0){
        url = articles.get(position).getMultimedia().get(0).getUrl();
        }


        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (viewHolder.detailsLayout.getVisibility() == View.GONE) {
                    viewHolder.detailsLayout.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.detailsLayout.setVisibility(View.GONE);
                }
            }
        });


        viewHolder.txtHeader.setText(name);
        viewHolder.date.setText(date);
        viewHolder.byLine.setText(byline);
        viewHolder.details.setText(details);

            Glide.with(context)
                    .asDrawable()
                    .load(url)
                    .into(viewHolder.icon);

    }


    @Override
    public int getItemCount() {

       return articles.size();

    }
}
