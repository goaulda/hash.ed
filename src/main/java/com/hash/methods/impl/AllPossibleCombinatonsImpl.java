package com.hash.methods.impl;

import com.hash.methods.AllPossibleCombinatonsInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class AllPossibleCombinatonsImpl implements AllPossibleCombinatonsInterface{

    @Override
    public String printCombinations(String AlphaNumericString, int n) {

            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {

                // generate a random number between
                // 0 to AlphaNumericString variable length
                int index
                        = (int)(AlphaNumericString.length()
                        * Math.random());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }

        return sb.toString();
    }

}