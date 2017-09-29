package io.rr.scala.core.start.tests;

/**
 * @author rrudenko on 18.09.2017.
 */
public class Test {
    public static void main(String[] args) {
        String a = "Test";
        String b = new String("Test");
        String c = new String("Test");
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
    }
}
