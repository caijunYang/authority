package com.itplayer.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by caijun.yang on 2018/3/31
 */
public class JsonUtils {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {

    }

    /**
     * 将对象转换为字符转
     *
     * @param object
     * @return
     */
    public static String obj2Str(Object object) {
        String str = "";
        try {
            str = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 将字符串转换为对象
     *
     * @param str
     * @param cls
     * @return
     */
    public static <T> T str2Obj(String str, Class<T> cls) {
        T object = null;
        try {
            object = objectMapper.readValue(str, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
