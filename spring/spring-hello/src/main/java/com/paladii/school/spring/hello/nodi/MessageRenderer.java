package com.paladii.school.spring.hello.nodi;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 05.09.15
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 */
public interface MessageRenderer {
    void render();
    MessageProvider getProvider();
    void setProvider(MessageProvider provider);
}
