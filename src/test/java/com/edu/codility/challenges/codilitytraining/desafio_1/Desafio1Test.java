package com.edu.codility.challenges.codilitytraining.desafio_1;

import org.junit.Assert;
import org.junit.Test;

public class Desafio1Test {


    @Test
    public void test1(){
        Assert.assertEquals("004-448-555-583-61", Desafio1.solution("00-44  48 5555 8361"));
    }

    @Test
    public void test2(){
        Assert.assertEquals("022-198-53-24", Desafio1.solution("0 - 22 1985--324"));

    }

    @Test
    public void test3(){
        Assert.assertEquals("555-372-654", Desafio1.solution("555372654"));

    }

    @Test
    public void test4(){
        Assert.assertEquals("123-456-78", Desafio1.solution("12345678"));
    }

    @Test
    public void test6(){
        Assert.assertEquals("004-448-555-583-61", Desafio1.solution("00-44  48 5555 8361"));
    }

    @Test
    public void test5(){
        Assert.assertEquals("123-456-78", Desafio1.solution("D3412531456156SD1F65ADS14F8941T1T56FDGDSFG0906-349506-93456"));
    }


}