package org.voting;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Demo demo = new Demo();

//        demo.getParametrizedData(20);
        demo.postStudent();
        demo.simpleGetData();
    }
}