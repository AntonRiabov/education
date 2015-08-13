package com.paladii.school.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by anton.riabov on 8/13/2015.
 */
@XmlRootElement
public class Info {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
