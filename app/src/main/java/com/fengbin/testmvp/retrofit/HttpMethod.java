package com.fengbin.testmvp.retrofit;

import com.fengbin.testmvp.bean.User;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：冯彬 on 2016/11/8 0008 11:39
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public class HttpMethod {

    public static final String BASE_URL = "https://api.github.com";
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private GithubService mGithubService;

    private HttpMethod() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        mGithubService = retrofit.create(GithubService.class);
    }
    private static class SingletonHolder{
        private static final HttpMethod instance = new HttpMethod();
    }
    public static HttpMethod getInstance(){
        return SingletonHolder.instance;
    }

    public void getUser(String loginName, Subscriber<User> subscriber){
        mGithubService.getUser(loginName)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
