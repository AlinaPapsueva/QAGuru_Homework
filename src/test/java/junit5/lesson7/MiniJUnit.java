package junit5.lesson7;

import org.junit.jupiter.api.*;

import java.lang.reflect.Method;

public class MiniJUnit {
    public static void main(String[] args) throws Exception {
        // 1) Ищет классы с аннотацией @Test

        Method[] methods = DemoTest.class.getDeclaredMethods();
        for (Method method : methods) {
            Test annotationTest = method.getAnnotation(Test.class);
            if (annotationTest != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("TEST BROKEN!!!");
                    return;
                }
                System.out.println("TEST PASSED!!!");
            }

            BeforeEach annotationBeforeEach = method.getAnnotation(BeforeEach.class);
            if (annotationBeforeEach != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("BeforeEach BROKEN!!!");
                    return;
                }
                System.out.println("BeforeEach PASSED!!!");
            }

            AfterEach annotationAfterEach = method.getAnnotation(AfterEach.class);
            if (annotationAfterEach != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("AfterEach BROKEN!!!");
                    return;
                }
                System.out.println("AfterEach PASSED!!!");
            }

            BeforeAll annotationBeforeAll = method.getAnnotation(BeforeAll.class);
            if (annotationBeforeAll != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("BeforeAll BROKEN!!!");
                    return;
                }
                System.out.println("BeforeAll PASSED!!!");
            }

            AfterAll annotationAfterAll = method.getAnnotation(AfterAll.class);
            if (annotationAfterAll != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("AfterAll BROKEN!!!");
                    return;
                }
                System.out.println("AfterAll PASSED!!!");
            }
        }
    }
}
