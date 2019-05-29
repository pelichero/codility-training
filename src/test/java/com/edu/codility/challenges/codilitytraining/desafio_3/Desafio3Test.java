package com.edu.codility.challenges.codilitytraining.desafio_3;

import org.junit.Assert;
import org.junit.Test;

public class Desafio3Test {

    @Test
    public void test1(){
        Assert.assertEquals(3, Desafio3.solution(new int[]{3, 4, 7, 7, 6, 6}));
    }

    @Test
    public void test2(){
        Assert.assertEquals(3, Desafio3.solution(new int[]{80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789}));
    }

    @Test
    public void test3(){
        Assert.assertEquals(5, Desafio3.solution(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    @Test
    public void test4(){
        Assert.assertEquals(1, Desafio3.solution(new int[]{1,1,1,1,1,1,1,1,1,1}));
    }

    @Test
    public void test5(){
        Assert.assertEquals(5, Desafio3.solution(new int[]{1,5,8,1,561,15,84,151,518,1}));
    }

    @Test
    public void test6(){
        Assert.assertEquals(1, Desafio3.solution(new int[]{1,2}));
    }

}