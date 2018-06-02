package com.asia;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018-05-19.
 */
public class Test2 {
    public static void main(String ar[]){
        try {
            Class<?> clz = Class.forName("com.asia.Test1");
            Object o = clz.newInstance();
            Method m = clz.getMethod("excute");
            m.invoke(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
