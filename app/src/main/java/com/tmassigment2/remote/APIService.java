package com.tmassigment2.remote;




import com.tmassigment2.model.InformationResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sumedha Vats on 26-03-2019.
 */
public interface APIService {
    String BASE_URL = "https://app.deltaapp.in";

    @GET("/api/v2/meta/data")
    Call<InformationResponse> getApiInformation();

}
