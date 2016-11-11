package com.fengbin.testmvp.retrofit;

import com.fengbin.testmvp.bean.User;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 作者：冯彬 on 2016/11/8 0008 11:37
 * 邮箱：jinbindeveloper@gmail.com
 * 描述：
 */
public interface GithubService {
    @GET("/users/{user}")
    Observable<User> getUser(@Path("user")String username);
}
