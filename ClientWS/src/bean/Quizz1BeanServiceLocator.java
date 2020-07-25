/**
 * Quizz1BeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bean;

public class Quizz1BeanServiceLocator extends org.apache.axis.client.Service implements bean.Quizz1BeanService {

    public Quizz1BeanServiceLocator() {
    }


    public Quizz1BeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Quizz1BeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Quizz1beanPort
    private java.lang.String Quizz1beanPort_address = "http://toshiba-pc:8080/Quizz1beanService/Quizz1bean";

    public java.lang.String getQuizz1beanPortAddress() {
        return Quizz1beanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Quizz1beanPortWSDDServiceName = "Quizz1beanPort";

    public java.lang.String getQuizz1beanPortWSDDServiceName() {
        return Quizz1beanPortWSDDServiceName;
    }

    public void setQuizz1beanPortWSDDServiceName(java.lang.String name) {
        Quizz1beanPortWSDDServiceName = name;
    }

    public bean.Quizz1Bean getQuizz1beanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Quizz1beanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getQuizz1beanPort(endpoint);
    }

    public bean.Quizz1Bean getQuizz1beanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            bean.Quizz1BeanPortBindingStub _stub = new bean.Quizz1BeanPortBindingStub(portAddress, this);
            _stub.setPortName(getQuizz1beanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setQuizz1beanPortEndpointAddress(java.lang.String address) {
        Quizz1beanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (bean.Quizz1Bean.class.isAssignableFrom(serviceEndpointInterface)) {
                bean.Quizz1BeanPortBindingStub _stub = new bean.Quizz1BeanPortBindingStub(new java.net.URL(Quizz1beanPort_address), this);
                _stub.setPortName(getQuizz1beanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Quizz1beanPort".equals(inputPortName)) {
            return getQuizz1beanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bean/", "Quizz1beanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bean/", "Quizz1beanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Quizz1beanPort".equals(portName)) {
            setQuizz1beanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
