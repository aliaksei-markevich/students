package ru.artezio.clients;

import ru.artezio.ejb.beans.FirstBeanRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientEJB {

    public static void main(String[] args) {
        try {
            InitialContext ic = new InitialContext();
            FirstBeanRemote firstBeanRemote =(FirstBeanRemote) ic.lookup(getLookupName());
            System.out.println(firstBeanRemote.getGreetingMessage("Kola"));
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    private static String getLookupName() {
        String appName = "";
        String moduleName = "ejb-1.0-SNAPSHOT";
        String distinctName = "";
        String beanName = "FirstBean";
        String interfaceName = FirstBeanRemote.class.getName();
        String fullLookupName = String.format("%s/%s/%s/%s!%s", appName, moduleName, distinctName, beanName, interfaceName);
        System.out.println(fullLookupName);
        return fullLookupName;
    }
}
