package com.asia.common.rule;

import java.util.Map;

/**
 * Created by admin on 2018-06-05.
 */
public interface Invocation {

    String getMethodName();

    Class<?>[] getParameterTypes();

    Object[] getArguments();

    Map<String, String> getAttachments();

    String getAttachment(String key);

    String getAttachment(String key, String defaultValue);

    Invoker<?> getInvoker();
}
