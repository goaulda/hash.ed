package com.hash.multiTread.crack;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Md5Method extends CrackMethods {

    //
    @Override
    Map<String, String> md5hash(String password) throws NoSuchAlgorithmException {

        Map<String, String> output = new HashMap<>();

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }

        output.put(password, sb.toString() );

    }
}
