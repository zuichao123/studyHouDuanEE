package com.sunjian.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class applicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("创建了一个application对象");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁了一个application对象");
    }
}
