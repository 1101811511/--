package com.swipe.demo.utils;

import com.swipe.demo.Bean.UserQQ;

/**
 * Created by Administrator on 2017/5/16.
 */
public class LoginManager {
    private static  final  LoginManager loginManager = new LoginManager();
    UserQQ mUser;
    public  static  LoginManager getInstance(){
       return loginManager;
    }
    public void setUser(UserQQ user){
        mUser = user;
    }
    public UserQQ getmUser(){
        if (null == mUser){
            return null;
        }
            return mUser;
    }
    public boolean isValiabLogin(){
        if (mUser!=null){
            return true;
        }
    }
}
