package br.spei.cepagora;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ipagn on 03/05/2017.
 */

public interface RetrofitService {
    @GET("json")
    Call<Endereco> consultaCEP();
}
