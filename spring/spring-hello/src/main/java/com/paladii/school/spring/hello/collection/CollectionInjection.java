package com.paladii.school.spring.hello.collection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 06.09.15
 * Time: 20:54
 * To change this template use File | Settings | File Templates.
 */
@Service("injectCollection")
public class CollectionInjection {
    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-ann-collection.xml");
        ctx.refresh();
        CollectionInjection instance =
                (CollectionInjection) ctx.getBean("injectCollection");
        instance.displayInfo();
    }

    private void displayInfo() {
        // Отобразить карту.
        System.out.println("Map contents:\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: "
                    + entry.getValue());
        }
        // Отобразить свойства.
        System.out.println("\nProperties contents:\n");
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: "
                    + entry.getValue());
        }
        // Отобразить набор.
        System.out.println("\nSet contents:\n");
        for (Object obj : set) {
            System.out.println("Value: " + obj);
        }
        // Отобразить список.
        System.out.println("\nList contents:\n");
        for (Object obj : list) {
            System.out.println("Value: " + obj);
        }

    }


    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
