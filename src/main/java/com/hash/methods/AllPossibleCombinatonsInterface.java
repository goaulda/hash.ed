package com.hash.methods;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface AllPossibleCombinatonsInterface {

    String printCombinations(String AlphaNumericString, int possibleSize);
}
