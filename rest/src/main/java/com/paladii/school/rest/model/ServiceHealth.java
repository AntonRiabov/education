package com.paladii.school.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by anton.riabov on 8/13/2015.
 */
@XmlRootElement
public class ServiceHealth {


    @XmlElement(name = "health")
    private String health;

    @XmlElement(name ="name")
    private String name;

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
