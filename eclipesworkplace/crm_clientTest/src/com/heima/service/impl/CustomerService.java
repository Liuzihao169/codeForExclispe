
package com.heima.service.impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.heima.service.Customer;
import com.heima.service.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerService", targetNamespace = "http://service.heima.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerService {


    /**
     * 
     * @return
     *     returns java.util.List<com.heima.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.heima.com/", className = "com.heima.service.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.heima.com/", className = "com.heima.service.FindAllResponse")
    public List<Customer> findAll();

}
