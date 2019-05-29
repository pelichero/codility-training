package com.edu.codility.challenges.codilitytraining.desafio_2;

import org.junit.Assert;
import org.junit.Test;

public class Desafio2Test {

    @Test
    public void test1(){
        Assert.assertEquals(0, Desafio2.minimalAdjacentValue(new int[]{0, 3, 3, 7, 5, 3, 11, 1}));
    }

    @Test
    public void test2(){
        Assert.assertEquals(1, Desafio2.minimalAdjacentValue(new int[]{1,8,4,9,45,79,6}));
    }

    @Test
    public void test3(){
        Assert.assertEquals(84, Desafio2.minimalAdjacentValue(new int[]{84,165981,15215,89478478,1111,151}));
    }

    @Test
    public void test4(){
        Assert.assertEquals(-1, Desafio2.minimalAdjacentValue(new int[]{100000001,101000000}));
    }
}