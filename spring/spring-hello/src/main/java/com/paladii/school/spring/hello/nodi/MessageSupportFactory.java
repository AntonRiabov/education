package com.paladii.school.spring.hello.nodi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 05.09.15
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public class MessageSupportFactory {
    private static MessageSupportFactory factory = null;
    private Properties properties = null;
    private MessageRenderer renderer;
    private MessageProvider provider;

    static {
        factory = new MessageSupportFactory();
    }

    public MessageRenderer getRenderer(){
        return renderer;
    }

    public MessageProvider getProvider(){
        return provider;
    }

    public static MessageSupportFactory getInstance(){
        return factory;
    }

    private MessageSupportFactory(){
        properties = new Properties();

        try {
            properties.load(new FileInputStream("spring/spring-hello/src/main/resources/config.properties"));

            String rendererClass = properties.getProperty("renderer");
            String providerClass = properties.getProperty("provider");

            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
