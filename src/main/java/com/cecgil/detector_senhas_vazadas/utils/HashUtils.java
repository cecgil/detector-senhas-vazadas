package com.cecgil.detector_senhas_vazadas.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

    public static String hashSha1(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] resultado = md.digest(senha.getBytes());

        StringBuilder sb = new StringBuilder();
        for(byte bytes : resultado) {
            sb.append(String.format("%02x", bytes));
        }
        
        return sb.toString();

    }

     


    
}
