package com.example.nytapplication.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.nytapplication.R;
import com.example.nytapplication.adapter.ArticlesAdapter;
import com.example.nytapplication.model.Response;
import com.example.nytapplication.presenter.ArticlesPresenter;
import com.example.nytapplication.view.ArticlesView;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ArticlesView {

    RecyclerView recyclerView;
    ArticlesAdapter articlesAdapter;

    @Inject
    ArticlesPresenter articlesPresenter;
    @Inject
    ArticlesView articlesView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articlesPresenter = new ArticlesPresenter(this);
        articlesPresenter.getCategories();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void FetchArticles(Response response) {

        articlesAdapter = new ArticlesAdapter(response.getResults(), getApplicationContext());
        recyclerView.setAdapter(articlesAdapter);
    }

}
