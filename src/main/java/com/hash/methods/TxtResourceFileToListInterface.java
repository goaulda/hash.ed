package com.hash.methods;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TxtResourceFileToListInterface {
    List<String> txtToList(String whichList);
}
