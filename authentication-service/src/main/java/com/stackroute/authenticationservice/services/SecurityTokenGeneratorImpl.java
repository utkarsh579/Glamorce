package com.stackroute.authenticationservice.services;

import com.stackroute.authenticationservice.model.Authentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String,String> generateToken(Authentication authentication) {
        Map<String,String> result=new HashMap<>();
        authentication.setPassword("");
        Map<String, Object> data=new HashMap<>();
//        userdata.put("user",user);

        data.put("emailId",authentication.getEmailId());
        data.put("role",authentication.getRole());
        String jwt= Jwts.builder()
                .setClaims(data)
                .setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime()+120000))
                .signWith(SignatureAlgorithm.HS512,"secretkey")
                .compact();
        result.put("token",jwt);
        result.put("message","login success");
        return result;
    }
}
