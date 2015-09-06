package com.paladii.school.spring.hello.nodi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 05.09.15
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
@Service("provider1")
public class HelloMessageProvider implements MessageProvider {

    private String message;
    @Autowired
    public HelloMessageProvider(@Value("Annotated consctructor injection Helloo")String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
