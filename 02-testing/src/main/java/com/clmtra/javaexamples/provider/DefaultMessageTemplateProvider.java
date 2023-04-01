package com.clmtra.javaexamples.provider;

public class DefaultMessageTemplateProvider implements MessageTemplateProvider {

    public static final String DEFAULT_TEMPLATE = "HI\n %s \n With best regards, %s";

    @Override
    public String getMessageTemplate(String templateName) {
        return DEFAULT_TEMPLATE;
    }
}
