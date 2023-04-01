package com.clmtra.javaexamples.message;

import com.clmtra.javaexamples.exception.TemplateNotFoundException;
import com.clmtra.javaexamples.provider.MessageTemplateProvider;

public class MessageBuilderImpl implements MessageBuilder {

    private final MessageTemplateProvider templateProvider;

    public MessageBuilderImpl(MessageTemplateProvider templateProvider) {
        this.templateProvider = templateProvider;
    }

    @Override
    public String buildMessage(String templateName, String text, String signature) {
        String messageTemplate = templateProvider.getMessageTemplate(templateName);
        if (messageTemplate == null || messageTemplate.isEmpty()) {
            throw new TemplateNotFoundException("Template not found");
        }
        return String.format(messageTemplate, text, signature);
    }
}
