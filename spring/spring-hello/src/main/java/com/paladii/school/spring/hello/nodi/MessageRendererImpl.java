package com.paladii.school.spring.hello.nodi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 05.09.15
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */
@Service("renderer")
public class MessageRendererImpl implements MessageRenderer {

    MessageProvider provider;

    @Override
    public void render() {
        if (provider == null){
            throw new RuntimeException("no provider eas set");
        }
        System.out.println(provider.getMessage());
    }

    @Override
    public MessageProvider getProvider() {
        return provider;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Autowired
//    @javax.annotation.Resource(name = "provider")
    @Override
    public void setProvider(MessageProvider provider) {
        this.provider = provider;
    }
}
