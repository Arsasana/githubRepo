package com.ks.riskcontrol.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TimedTask {
    public static void main(String args[]){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.getBean("xmlTask");
    }
}
