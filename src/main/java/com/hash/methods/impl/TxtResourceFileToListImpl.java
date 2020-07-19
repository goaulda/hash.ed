package com.hash.methods.impl;

import com.hash.methods.TxtResourceFileToListInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;

public class TxtResourceFileToListImpl implements TxtResourceFileToListInterface {
    @Override
    public List<String> txtToList(String whichList) {

        String fileName = "/Users/pankaj/source.txt";
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:application.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        try {
            while((line = br.readLine()) != null){
                //process the line
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }

}
