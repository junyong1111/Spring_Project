package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.junit.MyMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathtest {
    @BeforeEach
    void beforeEach(){
        System.out.println("BeforeEach");
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }
    @AfterEach
    void afterEach(){
        System.out.println("AfterEach");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("After All");
    }
    @Test
    void test1(){
        System.out.println("test1");
    }

    @Test
    void test2(){
        System.out.println("test2");
    }
    @Test
    void test3(){
        System.out.println("test3");
    }
}
