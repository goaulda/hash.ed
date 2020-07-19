package com.hash.methods.impl;

import com.hash.endpoint.main.model.PasswordEntity;
import com.hash.endpoint.main.repo.PasswordsRepo;
import com.hash.methods.AllPossibleCombinatonsInterface;
import com.hash.methods.GeneratedHashToPasswordInterface;
import com.hash.exception.AnyErrorHandlingException;
import com.hash.methods.TxtResourceFileToListInterface;
import com.hash.mongoDB.model.PasswordsHashMD5Entity;
import com.hash.mongoDB.repo.PasswordsHashMD5Repo;
import com.hash.multiTread.crack.CrackMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@Component
public class MultiTreadDecoderHash extends Thread implements GeneratedHashToPasswordInterface {

    String lower = "abcdefghijklmnopqrstuvxyz";
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numbers = "0123456789";

    @Autowired
    CrackMethods crackMethods;

    @Autowired
    PasswordsRepo passwordsRepo;

    @Autowired
    PasswordsHashMD5Repo passwordsHashMD5Repo;

    @Autowired
    AllPossibleCombinatonsInterface allPossibleCombinatonsInterface;

    @Autowired
    TxtResourceFileToListInterface txtResourceFileToListInterface;

    @Override
    public String hashType(String hashType) {
        return hashType;
    }

    @Override
    public Map<String, String> hashToPassword(String hashPassword, String hasType) {

        Map<String, String> hashPasswordMap = new HashMap<>();
        List<PasswordsHashMD5Entity> passwordsHashMD5EntityList = new ArrayList<>();

        String pretendPassword="";
        String hashPretendPassword="";
        int numberCase = 0, count = 0;

        Thread thread = new Thread();
        thread.run();
        try {
            for (int i = 0 ; i < 1; i--) {
                PasswordEntity passwordEntity = new PasswordEntity();
                PasswordsHashMD5Entity passwordsHashMD5Entity = new PasswordsHashMD5Entity();
                if (hashPassword.equals(hashPretendPassword)){

                    passwordsHashMD5Repo.saveAll(passwordsHashMD5EntityList);
                    hashPasswordMap.put(pretendPassword, hashPretendPassword);
                    passwordsRepo.save(passwordEntity);
                    break;
                }


                int numberOfWords = numberOfWordsMethod();
                numberCase = numberCaseFunction(count, numberOfWords);
                pretendPassword = randomCharactersGenerator(numberOfWords, numberCase);


                hashPretendPassword = crackMethods.md5hash(pretendPassword);
                passwordEntity.setHash(hasType);
                passwordEntity.setPassword(pretendPassword);
                passwordEntity.setHash(hashPassword);
                count++;

                passwordsHashMD5Entity.setId(Long.valueOf(count));
                passwordsHashMD5Entity.setHashPassword(passwordEntity.getHash());
                passwordsHashMD5Entity.setPassword(passwordEntity.getPassword());

                passwordsHashMD5EntityList.add(passwordsHashMD5Entity);
                System.out.println(hashPassword + " = " + hashPretendPassword);
                System.out.println("haslo: "+pretendPassword +" cykl: "+ count);

            }

        } catch (NoSuchAlgorithmException e) {
            throw new AnyErrorHandlingException(e.getMessage());
        }

        return hashPasswordMap;
    }

    @Override
    public Map<String, String> hashToPasswordFromList(String hashPassword, String hashType, String whichList) {

        Map<String, String> hashPasswordMap = new HashMap<>();

        List<String> stringList = txtResourceFileToListInterface.txtToList(whichList);

        return null;

    }





    //
    //Private Methods to deal with override methods
    //
    private int numberCaseFunction(int count, int numberOfWords) {


        if (count<choose(26, 4)){
            count =1;
        }else if (count<choose(26, 4)+choose(26, 4)){
            count =2;
        }else if (count<choose(26, 4)+choose(26, 4)+choose(10, 4)){
            count =3;
        }

        return count;
    }

    private int numberOfWordsMethod() {
        return factorial(4);
    }

    private String randomCharactersGenerator(int numberOfWords, int numberCase) {

                // chose a Character random from this String

                String AlphaNumericArray = new String();

                switch (numberCase){
                    case 1:
                        AlphaNumericArray = lower;
                        break;
                    case 2:
                        AlphaNumericArray = lower+upper;
                        break;
                    case 3:
                        AlphaNumericArray = lower+upper+numbers;
                        break;
                }
                return allPossibleCombinatonsInterface.printCombinations(AlphaNumericArray, numberOfWords);
            }


    private static int factorial(int i)
    {
        if (i < 1)
            return 1;
        else
            return i * factorial(i - 1);
    }

    public static long choose(long total, long choose){
        if(total < choose)
            return 0;
        if(choose == 0 || choose == total)
            return 1;
        return choose(total-1,choose-1)+choose(total-1,choose);
    }
}
