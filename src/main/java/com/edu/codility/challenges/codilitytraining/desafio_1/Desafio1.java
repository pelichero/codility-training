package com.edu.codility.challenges.codilitytraining.desafio_1;


import java.util.Arrays;

/**

 We are given a string S representing a phone number, which we would like to reformat. String S consists of N characters: digits, spaces and/or dashes. It contains at least two digits.

 Spaces and dashes in string S can be ignored. We want to reformat the given phone number in such a way that the digits are grouped in blocks of length three, separated by single dashes. If necessary, the final block or the last two blocks can be of length two.

 For example, given string S = "00-44 48 5555 8361", we would like to format it as "004-448-555-583-61".

 Write a function:

 > class Solution { public String solution(String S); }

 that, given a string S representing a phone number, returns this phone number reformatted as described above.

 For example, given S = "00-44 48 5555 8361", the function should return "004-448-555-583-61". Given S = "0 - 22 1985--324", the function should return "022-198-53-24". Given S = "555372654", the function should return "555-372-654".

 Assume that:

 > * N is an integer within the range [2..100];
 >     * string S consists only of digits (0−9), spaces and/or dashes (-);
 >     * string S contains at least two digits.

 In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.


 */
public class Desafio1 {


    private static final String TOKEN = "-";
    private static final int INTERVAL = 3;
    private static final int ODD_INTERVAL = 2;
    public static final int FORBIDDEN_LENGTH = 1;

    public static String solution(String phone){

        phone = phone.replaceAll("[^a-zA-Z0-9]", "");

        for(int i = INTERVAL; i < phone.length(); i+=INTERVAL+1){
            phone = new StringBuilder(phone).insert(i,TOKEN).toString();
        }

        return correctOdds(phone);
    }

    private static String correctOdds(String phone) {
        return isCorrect(phone) ? phone : repair(phone);
    }

    private static String repair(String phone) {
        char shift = phone.charAt(phone.length()-INTERVAL);

        return new StringBuilder(phone)
               .replace(phone.length()-INTERVAL,phone.length()-ODD_INTERVAL, "")
               .insert(phone.length()-ODD_INTERVAL, shift)
               .toString();
    }


    private static boolean isCorrect(String phone) {
        return Arrays.stream(phone.split(TOKEN)).noneMatch(s -> s.length() == FORBIDDEN_LENGTH);
    }

}
