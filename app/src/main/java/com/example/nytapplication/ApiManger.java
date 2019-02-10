package com.example.nytapplication;

import com.example.nytapplication.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiManger {
    @GET("svc/topstories/v2/science.json?api-key=XLi7PKTGDQftpFOhpN2NiPQ3uyd81iXx")
    Call<Response> getArticles();
}
