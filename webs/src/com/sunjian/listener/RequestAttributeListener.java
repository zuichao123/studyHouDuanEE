package com.sunjian.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("添加了一个requestAttribute");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("删除了一个requestAttribute");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("修改了一个requestAttribute");
    }
}
