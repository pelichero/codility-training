package com.edu.codility.challenges.codilitytraining.lesson_1;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BinnaryGap{

    @Autowired
    private BinnaryGap service;

    @Test
    public void binnaryGap() {
        service.getBinnaryGap(147);
    }
}
