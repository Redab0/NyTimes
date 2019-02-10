package com.example.nytapplication.presenter;


import com.example.nytapplication.ApiManger;
import com.example.nytapplication.model.Response;
import com.example.nytapplication.view.ArticlesView;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ArticlesPresenter implements ArticlesView {

    @Inject
    ApiManger apiManger;

    ArticlesView articlesView;
    Retrofit retrofit;



    public ArticlesPresenter(ArticlesView articlesView) {
        this.articlesView = articlesView;
    }


    public void getCategories() {
        retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.nytimes.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiManger = retrofit.create(ApiManger.class);

        apiManger.getArticles().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                Response apiResponse = response.body();
                articlesView.FetchArticles(apiResponse);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }

    @Override
    public void FetchArticles(Response response) {

    }


}
