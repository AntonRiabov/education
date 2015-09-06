package com.paladii.school.spring.hello.di;

import com.paladii.school.spring.hello.nodi.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 06.09.15
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */
public class HelloGenericXmlContext {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.load("classpath:META-INF/spring/app-context-xml.xml");
        context.load("classpath:META-INF/spring/app-context-annotated.xml");
        context.refresh();
        MessageProvider provider = context.getBean("provider", MessageProvider.class);
        System.out.println(provider.getMessage());
    }
}
