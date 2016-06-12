package ru.artezio.beans;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@Singleton
@Startup
public class MessageBean implements MessageBeanMBean {


    private MBeanServer platformMBeanServer;
    private ObjectName objectName = null;

    private String message = "FIRST_JMX";

    @PostConstruct
    public void registerInJMX() {
        try {
            objectName = new ObjectName("JMX_MY:full_name=" + this.getClass().getName());
            platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
            platformMBeanServer.registerMBean(this, objectName);
        } catch (Exception e) {
            throw new IllegalStateException("Problem during registration of Monitoring into JMX:" + e);
        }
    }

    @Override
    public String takeMessage() {
        return message;
    }

    @Override
    public void inputMessage(String message) {
        this.message = message;
    }

    @PreDestroy
    public void unregisterFromJMX() {
        try {
            platformMBeanServer.unregisterMBean(this.objectName);
        } catch (Exception e) {
            throw new IllegalStateException("Problem during unregistration of Monitoring into JMX:" + e);
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
