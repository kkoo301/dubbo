package com.asia.common.rule;

/**
 * Created by admin on 2018-06-05.
 */
public interface Invoker<T> {

    Class<T> getInterface();

    Result invoke(Invocation invocation) ;
}
