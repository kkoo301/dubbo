package com.asia.common.rule;

import java.util.Map;

/**
 * Created by admin on 2018-06-05.
 */
public interface Result {
    Object getValue();
    Throwable getException();
    boolean hasException();
    Object recreate() throws Throwable;
    Map<String, String> getAttachments();
    String getAttachment(String key);
    String getAttachment(String key, String defaultValue);
}
