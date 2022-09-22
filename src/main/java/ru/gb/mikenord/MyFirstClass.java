package ru.gb.mikenord;

public class MyFirstClass {

    @Test(5)
    public static void myFirstMethod052() {
        System.out.println("myFirst-052dd");
    }
    @Test(6)
    public static void myFirstMethod06() {
        System.out.println("myFirst-06");
    }
    @AfterSuite
    public  static void myFirstMethodAfter() {
        System.out.println("myFirst-After");
    }
    @Test(1)
    public  static void myFirstMethod01() {
        System.out.println("myFirst-01");
    }
    @Test(9)
    public  static void myFirstMethod09() {
        System.out.println("myFirst-09");
    }
    @Test(3)
    public static  void myFirstMethod03() {
        System.out.println("myFirst-03");
    }
    @Test(2)
    public static  void myFirstMethod02() {
        System.out.println("myFirst-02");
    }
    @Test(8)
    public static  void myFirstMethod08() {
        System.out.println("myFirst-08");
    }
    @Test(10)
    public  static void myFirstMethod10() {
        System.out.println("myFirst-10");
    }
    @Test(4)
    public static  void myFirstMethod04() {
        System.out.println("myFirst-04");
    }
    @BeforeSuite
    public static  void myFirstMethodBefore() {
        System.out.println("myFirst-Before");
    }
//    @BeforeSuite
//    public static  void myFirstMethodBefore2() {
//        System.out.println("myFirst-Before");
//    }
    @Test(5)
    public static  void myFirstMethod051() {
        System.out.println("myFirst-051");
    }

}