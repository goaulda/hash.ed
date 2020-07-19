package com.hash.methods;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface GeneratedHashToPasswordInterface {

    String hashType(String hashType);

    Map<String, String> hashToPassword(String hashPassword, String hasType);

    Map<String,String> hashToPasswordFromList(String hashPassword, String hashType, String whichList);
}
