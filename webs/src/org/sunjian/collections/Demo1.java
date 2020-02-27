package org.sunjian.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List l1 = new ArrayList<>();
        l1.add(1);
        l1.add("");
        l1.add(new Date());

        l1.get(1);

    }
}
