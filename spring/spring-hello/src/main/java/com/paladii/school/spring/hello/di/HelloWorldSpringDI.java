package com.paladii.school.spring.hello.di;

import com.paladii.school.spring.hello.nodi.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 05.09.15
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
