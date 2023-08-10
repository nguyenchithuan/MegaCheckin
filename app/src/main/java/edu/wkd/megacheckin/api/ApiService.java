package edu.wkd.megacheckin.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.wkd.megacheckin.models.postdata.DataForgotPass;
import edu.wkd.megacheckin.models.postdata.DataLogin;
import edu.wkd.megacheckin.models.postdata.DataRegister;
import edu.wkd.megacheckin.models.response.ResponseForgotPass;
import edu.wkd.megacheckin.models.response.ResponseLogin;
import edu.wkd.megacheckin.models.response.ResponseRegister;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://14.225.7.221:3002/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("login")
    Call<ResponseLogin> login(@Body DataLogin dataLogin);

    @POST("register")
    Call<ResponseRegister> register(@Body DataRegister dataRegister);

    @POST("resetpass")
    Call<ResponseForgotPass> forgetPassword(@Body DataForgotPass dataForgetPass);
}
