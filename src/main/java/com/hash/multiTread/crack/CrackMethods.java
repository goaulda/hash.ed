package com.hash.multiTread.crack;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public abstract class CrackMethods {

    abstract Map<String, String> md5hash(String password) throws NoSuchAlgorithmException;
}
