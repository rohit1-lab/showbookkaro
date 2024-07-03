package com.rohit.showBookKaro.services;

import lombok.Data;
import lombok.Getter;

import java.lang.ref.PhantomReference;
@Getter
public enum EmailTemplate {

    ACTIVATE_ACCOUNT("activate_account");

    private final String name;

    EmailTemplate(String name) {
        this.name = name;
    }

}
