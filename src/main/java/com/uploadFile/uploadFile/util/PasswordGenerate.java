package com.uploadFile.uploadFile.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordGenerate {
    public String generate(){
        return new java.util.Random().ints(40, 0, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".length()).mapToObj("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"::charAt).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

}
