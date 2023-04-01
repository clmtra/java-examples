package com.clmtra.javaexamples.message;

import com.clmtra.javaexamples.exception.TemplateNotFoundException;
import com.clmtra.javaexamples.provider.MessageTemplateProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.clmtra.javaexamples.provider.DefaultMessageTemplateProvider.DEFAULT_TEMPLATE;

class MessageBuilderImplTest {

    public static final String DEFAULT_TEMPLATE_NAME = "defaultTemplateName";
    public static final String DEFAULT_MESSAGE_TEXT = "defaultMessageText";
    public static final String DEFAULT_SIGNATURE = "defaultSignature";

    private MessageTemplateProvider provider;
    private MessageBuilderImpl messageBuilder;

    @BeforeEach
    void setUp() {
        provider = Mockito.mock(MessageTemplateProvider.class);
        messageBuilder = new MessageBuilderImpl(provider);
    }

    @Test
    void buildMessageTest1() {
        Mockito.when(provider.getMessageTemplate(DEFAULT_TEMPLATE_NAME)).thenReturn(DEFAULT_TEMPLATE);
        String expected = String.format(DEFAULT_TEMPLATE, DEFAULT_MESSAGE_TEXT, DEFAULT_SIGNATURE);
        String actual = messageBuilder.buildMessage(DEFAULT_TEMPLATE_NAME, DEFAULT_MESSAGE_TEXT, DEFAULT_SIGNATURE);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void buildMessageTest2() {
        Mockito.when(provider.getMessageTemplate(Mockito.anyString())).thenReturn(" ");
        messageBuilder.buildMessage(DEFAULT_TEMPLATE_NAME, null, null);
        Mockito.verify(provider, Mockito.times(1)).getMessageTemplate(DEFAULT_TEMPLATE_NAME);
    }

    @Test
    void buildMessageTest3() {
        Mockito.when(provider.getMessageTemplate(Mockito.anyString())).thenReturn(null);
        Assertions.assertThrows(TemplateNotFoundException.class,
                () -> messageBuilder.buildMessage(null, null, null));
    }
}