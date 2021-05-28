package com.example.retrofitdemo.request;

import com.example.retrofitdemo.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestApi {
    @GET("/posts")
    Call<List<Post>> getPost();
}
