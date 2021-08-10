package com.example.apiexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("repositories")
    Call<ItemList> getItem(@Query("q")String query
            ,@Query("sort")String sort
            ,@Query("order")String order
            ,@Query("page")int page
            ,@Query("limit")int limit);
}
