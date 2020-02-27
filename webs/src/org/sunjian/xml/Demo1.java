package org.sunjian.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        // 1 获取解析器
        SAXReader reader = new SAXReader();
        String path = Demo1.class.getResource("/books.xml").getPath();

        // 2 获取文档
        Document document = reader.read(new FileInputStream(new File(path)));
        System.out.println(document.getNodeType());
        System.out.println(document.getNodeTypeName());

        // 3 获取根目录
        Element rootEle = document.getRootElement();
        System.out.println(rootEle.getNodeType());
        System.out.println(rootEle.getNodeTypeName());
        System.out.println(rootEle.getName());

        // 4 获取子元素
        rootEle.element("book"); // 根据节点名获取第一个该名称的节点
        rootEle.elements();// 获取所有子标签

        List<Element> bookList = rootEle.elements("book"); // 获取所有该名称的子标签
        for(Element book: bookList){
            book.attribute(arg0); // 根据属性名获取属性
            book.attributes(); // 获取所有属性
        }
    }
}
