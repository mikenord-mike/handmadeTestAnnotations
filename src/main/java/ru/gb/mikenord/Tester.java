package ru.gb.mikenord;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Tester {

    public static void main(String[] args) {
        MyFirstClass firstClass = new MyFirstClass();
        MySecondClass secondClass = new MySecondClass();
        MyThirdClass thirdClass = new MyThirdClass();

        start(firstClass.getClass());
        System.out.println();
        start(secondClass.getClass());
        System.out.println();
        start(thirdClass.getClass());
    }

    public static void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();

        if (methods.length == 0) {
            return;
        }


        final long beforeSuiteCount = Arrays.stream(methods)
                .filter(m -> m.getAnnotations()[0].annotationType() == BeforeSuite.class)
                .count();
        final long afterSuiteCount = Arrays.stream(methods)
                .filter(m -> m.getAnnotations()[0].annotationType() == AfterSuite.class)
                .count();


        if (beforeSuiteCount > 1) {
            throw new RuntimeException("'@BeforeSuite' annotation occurs more than once");
        }

        if (afterSuiteCount > 1) {
            throw new RuntimeException("'@AfterSuite' annotation occurs more than once");
        }

        if (beforeSuiteCount == 1) {
            try {
                Arrays.stream(methods)
                        .filter(m -> m.getAnnotations()[0].annotationType() == BeforeSuite.class)
                        .findAny().get().invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        Arrays.stream(methods)
                .filter(m -> m.getAnnotations()[0].annotationType() == Test.class)
                .sorted(Comparator.comparingInt(m -> (m.getAnnotation(Test.class).value())))
                .forEach(m -> {
                    try {
                        m.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });

        if (afterSuiteCount == 1) {
            try {
                Arrays.stream(methods)
                        .filter(m -> m.getAnnotations()[0].annotationType() == AfterSuite.class)
                        .findAny().get().invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

    }



}
