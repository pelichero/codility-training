package com.edu.codility.challenges.codilitytraining.desafio_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 Integer V _lies strictly_ between integers U and W if U < V < W or if U > V > W.

 A non-empty array A consisting of N integers is given. A pair of indices (P, Q), where 0 ≤ P < Q < N, is said to
 _have adjacent values_ if no value in the array lies strictly between values A[P] and A[Q].

 For example, in array A such that:
 A[0] = 0 A[1] = 3 A[2] = 3 A[3] = 7 A[4] = 5 A[5] = 3 A[6] = 11 A[7] = 1
 the following pairs of indices have adjacent values:
 (0, 7), (1, 2), (1, 4), (1, 5), (1, 7), (2, 4), (2, 5), (2, 7), (3, 4), (3, 6), (4, 5), (5, 7).
 For example, indices 4 and 5 have adjacent values because there is no value in array A that lies strictly between A[4] = 5 and A[5] = 3;
 the only such value could be the number 4, and it is not present in the array.

 Given two indices P and Q, their _distance_ is defined as abs(A[P] − A[Q]), where abs(X) = X for X ≥ 0, and abs(X) = −X for X < 0.
 For example, the distance between indices 4 and 5 is 2 because (A[4] − A[5]) = (5 − 3) = 2.

 Write a function:

 > class Solution { public int solution(int[] A); }

 that, given a non-empty array A consisting of N integers, returns the minimum distance between indices of this array that have adjacent values.
 The function should return −1 if the minimum distance is greater than 100,000,000. The function should return −2 if no adjacent indices exist.

 For example, given array A such that:
 A[0] = 0 A[1] = 3 A[2] = 3 A[3] = 7 A[4] = 5 A[5] = 3 A[6] = 11 A[7] = 1
 the function should return 0 because:

 > * indices 1 and 2 are adjacent, because the array does not contain any value that lies strictly between A[1] = 3 and A[2] = 3;
 >     * the distance between these indices is (A[1] − A[2]) = (3 − 3) = 0;
 >     * no other pair of adjacent indices that has smaller distance exists.

 Write an efficient algorithm for the following assumptions:

 > * N is an integer within the range [1..40,000];
 >     * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].


 */
public class Desafio2 {

    private static final int MAXIMUM_ADJACENT_VALUE = 100000000;
    private static final int DOESNT_CONTAIN_ANY_VALUE_STRICTLY_BETWEEN_2_INDICES = 0;

    public static int minimalAdjacentValue(int[] A) {

        List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());

        if(hasEqualValues(numbers)){
            return DOESNT_CONTAIN_ANY_VALUE_STRICTLY_BETWEEN_2_INDICES;
        }

        int minimumAdjacentFound = verifyAdjacents(numbers);

        return minimumAdjacentFound > MAXIMUM_ADJACENT_VALUE ? -1 : minimumAdjacentFound;
    }

    private static int verifyAdjacents(List<Integer> numbers, int index, int higherAdj) {

        if(numbers.size() <= index)
            return higherAdj;

        int adjacentValue = 0;

        for(int i = 0; i < numbers.size(); i++){
            if(index == i){
                continue;
            }

            int number = numbers.get(index) - numbers.get(i) * -1;

            adjacentValue = numbers.stream().filter(n -> n <= number).min(Integer::compareTo).orElse(0);

            System.out.println("O numero adjacente entre "+numbers.get(index)+"["+index+"] e "+numbers.get(i)+"["+i+"] é : " + adjacentValue);
        }

        return verifyAdjacents(numbers, ++index, (adjacentValue > higherAdj) ? adjacentValue : higherAdj);
    }

    private static boolean hasEqualValues(List<Integer> numbers) {
        return numbers.stream().anyMatch(i -> Collections.frequency(numbers, i) > 1);
    }

    private static int verifyAdjacents(List<Integer> numbers) {
        return verifyAdjacents(numbers, 0,0);
    }

}
