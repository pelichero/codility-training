package com.edu.codility.challenges.codilitytraining.desafio_3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 Mary has N candies. The i-th candy is of a type represented by an integer T[i].

 Mary's parents told her to share the candies with her brother. She must give him exactly half the candies. Fortunately,
 the number of candies N is even.

 After giving away half the candies, Mary will eat the remaining ones. She likes variety, so she wants to have candies of various types.
 Can you find the maximum number of different types of candy that Mary can eat?

 Write a function:

 > class Solution { public int solution(int[] T); }

 that, given an array T of N integers, representing all the types of candies, returns the maximum possible number of different types of candy that Mary can eat after she has given N/2 candies to her brother.

 For example, given:
 T = [3, 4, 7, 7, 6, 6]
 the function should return 3. One optimal strategy for Mary is to give away one candy of type 4, one of type 7 and one of type 6. The remaining candies would be [3, 7, 6]: three candies of different types.

 Given:
 T = [80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789]
 the function should also return 3. Here, Mary starts with ten candies. She can give away five candies of type 80 and the remaining candies would be [1000000000, 123456789, 80, 80, 80]. There are only three different types in total, i.e. 80, 1000000000 and 123456789.

 Write an efficient algorithm for the following assumptions:

 > * N is an integer within the range [2..100,000];
 >     * N is even;
 >     * each element of array T is an integer within the range [1..1,000,000,000].

 Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Desafio3 {

    public static final int KIDS_TO_SHARE = 2;

    public static int solution(int[] T) {
        List<Integer> candies = Arrays.stream(T).boxed().collect(Collectors.toList());

        Map<Integer, Integer> candiesFrequency = candies.stream().collect(groupingBy(Function.identity(), summingInt(e -> 1)));

        System.out.println(candiesFrequency);

        final int AMOUNT_MARY_CAN_KEEP = candies.size() / KIDS_TO_SHARE;

        final int TYPES_OF_CANDIES = candiesFrequency.keySet().size();

        return TYPES_OF_CANDIES > AMOUNT_MARY_CAN_KEEP ? AMOUNT_MARY_CAN_KEEP : TYPES_OF_CANDIES;
    }

}
