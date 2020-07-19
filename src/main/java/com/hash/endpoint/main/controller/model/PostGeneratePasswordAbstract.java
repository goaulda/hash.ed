package com.hash.endpoint.main.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostGeneratePasswordAbstract {

    private String hash;
    private String hashType;
    private String methodType;
}
