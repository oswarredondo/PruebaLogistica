
package com.ws.interchange.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.4.2
 * Wed Apr 04 00:53:29 CDT 2012
 * Generated source version: 2.4.2
 */

@XmlRootElement(name = "isCorrectServer", namespace = "http://interchange.ws.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isCorrectServer", namespace = "http://interchange.ws.com/")

public class IsCorrectServer {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

