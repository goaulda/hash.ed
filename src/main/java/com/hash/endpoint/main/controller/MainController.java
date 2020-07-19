package com.hash.endpoint.main.controller;

import com.hash.endpoint.main.controller.model.PostGeneratePasswordAbstract;
import com.hash.endpoint.main.service.MainServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainServiceInterface mainServiceInterface;


    @RequestMapping(value = "/password/crack", method =  RequestMethod.POST)
    @ResponseBody
    public Map<String, String> postHashAndGeneratePasswordWithHashType(
            @RequestBody PostGeneratePasswordAbstract postGeneratePasswordAbstract,
            HttpServletRequest request
    ){
            logger.info("OK");
            return mainServiceInterface.postHashAndGeneratePasswordWithHashType(postGeneratePasswordAbstract, request);
    }



}
