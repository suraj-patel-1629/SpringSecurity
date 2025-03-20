package com.example.security.service;

import com.example.security.model.User;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String secrateKey ="";
    public JwtService(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secrateKey= Base64.getEncoder().encodeToString(sk.getEncoded());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();

        }
    }

    public String generateToken(String userName) {
        // generating token
        Map<String ,Object>claims = new HashMap<>();
        return Jwts.builder().claims().add(claims).subject(userName).issuedAt(new Date(System.currentTimeMillis())).
               expiration(new Date(System.currentTimeMillis()+60*60*10)).and().signWith(getKey()).compact() ;

    }
    public Key getKey(){
        //Decodes a Base64 secretKey into raw bytes.
        //Keys.hmacShaKeyFor(keyByte) -->	Converts bytes into a strong HMAC key.
        byte[] keyByte = Decoders.BASE64.decode(secrateKey);
        return Keys.hmacShaKeyFor(keyByte);
    }
}
