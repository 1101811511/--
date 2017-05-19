package com.swipe.demo.utils;

/**
 * Created by Administrator on 2017/5/16.
 */
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;
/*
Gson的封装，持续扩展中。。。。
 */
public class GsonUtils {
    private static Gson gson;
    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
        builder.registerTypeAdapter(Date.class, new JsonDeserializer() {
            @Override
            public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

           return  json == null ? null : new Date(json.getAsLong() * 1000L);
            }
        });
    gson = builder.create();
    }
    public static <T> T  fromJson(String json,Type type){
        return gson.fromJson( json,type);
    }
    public static <T> T fromeJson(JsonElement json,Type type){
        return gson.fromJson(json,type);
    }
    public static <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json,clazz);
    }
}
