package com.hash.endpoint.main.service.impl;

import com.hash.endpoint.main.controller.model.PostGeneratePasswordAbstract;
import com.hash.methods.GeneratedHashToPasswordInterface;
import com.hash.endpoint.main.model.PasswordEntity;
import com.hash.endpoint.main.repo.PasswordsRepo;
import com.hash.endpoint.main.service.MainServiceInterface;
import com.hash.exception.AnyErrorHandlingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class MainServiceImpl implements MainServiceInterface {

    @Autowired
    private PasswordsRepo passwordsRepo;

    @Autowired
    GeneratedHashToPasswordInterface generatedHashToPassword;

    @Override
    public Page<PasswordEntity> getListOfPassedPassowordByHash(String hashType, HttpServletRequest requestInfo) {

        Pageable pageable = Pageable.unpaged();
        Page<PasswordEntity> entityPassword = passwordsRepo.findAllByHashType(hashType, pageable );
                //.onErrorReturn( () -> throw new  NoResourceFoundException("Putted hash type: " + hashType+ " doesn't found in database"));
        return entityPassword;
    }

    @Override
    public Map<String, String> postHashAndGeneratePasswordWithHashType(PostGeneratePasswordAbstract postGeneratePasswordAbstract, HttpServletRequest request){

        Map<String, String> passwordMap = new HashMap<>();
        String hashPassword = postGeneratePasswordAbstract.getHash();
        String hasType = postGeneratePasswordAbstract.getHashType();
        String methodType = postGeneratePasswordAbstract.getMethodType();
        try {
            hasType = generatedHashToPassword.hashType(hasType);
        }catch (Exception e){
            throw new AnyErrorHandlingException(e.getMessage());
        }
        try {

           if (methodType.equals("crack")){
               passwordMap = generatedHashToPassword.hashToPassword(hashPassword, hasType);
           }
           if (methodType.equals("list")){
               passwordMap = generatedHashToPassword.hashToPasswordFromList(hashPassword, hasType);
           }
        }catch (Exception e){
            throw new AnyErrorHandlingException(e.getMessage());
        }
        return passwordMap;
    }
}
