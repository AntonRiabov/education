package com.paladii.school.spring.hello.collection;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: PALADII
 * Date: 06.09.15
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
@Service("oracle")
public class Bookworm implements Oracle {

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - use the Internet";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
