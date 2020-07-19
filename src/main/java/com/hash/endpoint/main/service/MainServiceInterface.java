package com.hash.endpoint.main.service;

import com.hash.endpoint.main.controller.model.PostGeneratePasswordAbstract;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public interface MainServiceInterface {

    Page<?> getListOfPassedPassowordByHash(String hashType, HttpServletRequest requestInfo);

    Map<String, String> postHashAndGeneratePasswordWithHashType(PostGeneratePasswordAbstract postGeneratePasswordAbstract, HttpServletRequest request);
}
