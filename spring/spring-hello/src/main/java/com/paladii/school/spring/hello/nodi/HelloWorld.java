package com.paladii.school.spring.hello.nodi;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 05.09.15
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
    public static void main(String[] args) {
       MessageSupportFactory factory = MessageSupportFactory.getInstance();
        MessageProvider provider = factory.getProvider();
        MessageRenderer renderer = factory.getRenderer();

        renderer.setProvider(provider);
        renderer.render();

//        renderer.setProvider(provider2);
//        renderer.render();
    }
}
