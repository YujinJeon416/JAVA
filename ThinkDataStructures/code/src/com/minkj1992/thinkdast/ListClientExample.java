package com.minkj1992.thinkdast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListClientExample {
    private List list;


    public ListClientExample() {
        this.list = new LinkedList();
//        this.list = new ArrayList();
    }

    public List getList() {
        return list;
    }

    public static void main(String[] args) {
        ListClientExample lce = new ListClientExample();
        // List type으로 값을 받고 있다.
        List list = lce.getList();
        System.out.println(list);
    }
}
