package com.asia.common.rule;

/**
 * Created by admin on 2018-06-05.
 */
public interface Filter {
    Result invoke(Invoker<?> invoker, Invocation invocation);
}
