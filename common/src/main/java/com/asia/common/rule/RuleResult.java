package com.asia.common.rule;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by admin on 2018-06-05.
 */
public class RuleResult implements Result, Serializable {

    private Object result;

    private Throwable exception;

    private Map<String, String> attachments = Maps.newHashMap();

    public RuleResult() {
    }

    @Override
    public Object getValue() {
        return null;
    }

    public void setException(Throwable e) {
        this.exception = e;
    }

    @Override
    public Throwable getException() {
        return exception;
    }

    @Override
    public boolean hasException() {
        return null != exception;
    }

    @Override
    public Object recreate() throws Throwable {
        if(null!=exception){
            throw exception;
        }
        return result;
    }

    @Override
    public Map<String, String> getAttachments() {
        return attachments;
    }

    @Override
    public String getAttachment(String key) {
        return attachments.get(key);
    }

    @Override
    public String getAttachment(String key, String defaultValue) {
        String result = attachments.get(key);
        if(StringUtils.isEmpty(result)){
            return defaultValue;
        }
        return result;
    }

    @Override
    public String toString() {
        return "RuleResult [result=" + result + ", exception=" + exception + "]";
    }
}
