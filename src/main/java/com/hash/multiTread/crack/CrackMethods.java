package com.hash.multiTread.crack;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface CrackMethods {

    String md5hash(String password) throws NoSuchAlgorithmException;
}
