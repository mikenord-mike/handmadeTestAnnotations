package ru.gb.mikenord;

public class MyThirdClass {

    @Test(4)
    public  static void mySThirdMethod04() {
        System.out.println("mySThird-04");
    }
    @BeforeSuite
    public  static void mySThirdMethodBefore() {
        System.out.println("mySThird-Before");
    }
    @Test(5)
    public  static void mySThirdMethod051() {
        System.out.println("mySThird-051");
    }
}
