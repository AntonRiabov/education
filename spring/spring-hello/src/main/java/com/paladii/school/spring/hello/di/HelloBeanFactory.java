package com.paladii.school.spring.hello.di;

import com.paladii.school.spring.hello.nodi.MessageRenderer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 06.09.15
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public class HelloBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);

        definitionReader.loadBeanDefinitions(new FileSystemResource("D:\\WORKSPACE\\JavaSchool\\spring\\spring-hello\\src\\main\\resources\\META-INF\\spring\\app-context.xml"));

        MessageRenderer renderer = beanFactory.getBean("renderer", MessageRenderer.class);
        renderer.render();
        renderer.render();
    }
}
