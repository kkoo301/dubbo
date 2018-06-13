package com.asia.common.rule;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by admin on 2018-06-05.
 */
public class RuleInvocation implements Invocation , Serializable {

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] arguments;

    private Map<String, String> attachments;

    private transient Invoker<?> invoker;



    @Override
    public String getMethodName() {
        return this.methodName;
    }

    @Override
    public Class<?>[] getParameterTypes() {
        return this.parameterTypes;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Map<String, String> getAttachments() {
        return this.attachments;
    }

    @Override
    public String getAttachment(String key) {
        return this.attachments.get(key);
    }

    @Override
    public String getAttachment(String key, String defaultValue) {
        String result = this.attachments.get(key);
        if(StringUtils.isEmpty(result)){
            return defaultValue;
        }
        return result;
    }

    @Override
    public Invoker<?> getInvoker() {
        return this.invoker;
    }
}
