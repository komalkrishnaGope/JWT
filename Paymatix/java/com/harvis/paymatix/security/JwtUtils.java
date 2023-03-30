//package com.harvis.paymatix.security;
//
//import java.security.SignatureException;
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.harvis.paymatix.dto.UserResponse;
//import com.harvis.paymatix.model.Users;
//import com.harvis.paymatix.service.UserService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.jsonwebtoken.*;
//
//@Component
//@RestController
//public class JwtUtils {
//  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
//
////  @Value("${paymatix.app.jwtSecret}")
////  private String jwtSecret;
////
////  @Value("${paymatix.app.jwtExpirationMs}")
////  private int jwtExpirationMs;
//  String jwtSecret= "bezKoderSecretKey";
//  int jwtExpirationMs = 86400000;
//
//  public String generateJwtToken(UserResponse user) {
//
////    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
//	  
//	  
//	  System.out.println("jwt secret::"+jwtSecret);
//	  System.out.println("jwtExpirationMs::"+jwtExpirationMs);
//
//    return Jwts.builder().setSubject((user.getUserName())).setIssuedAt(new Date())
//        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
//        .compact();
//  }
//
//  public String getUserNameFromJwtToken(String token) {
//    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
//  }
//
//  public boolean validateJwtToken(String authToken) {
//    try {
//      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//      return true;
//    } //catch (SignatureException e) {
//      //logger.error("Invalid JWT signature: {}", e.getMessage());
//   // } 
//    catch (MalformedJwtException e) {
//      logger.error("Invalid JWT token: {}", e.getMessage());
//    } catch (ExpiredJwtException e) {
//      logger.error("JWT token is expired: {}", e.getMessage());
//    } catch (UnsupportedJwtException e) {
//      logger.error("JWT token is unsupported: {}", e.getMessage());
//    } catch (IllegalArgumentException e) {
//      logger.error("JWT claims string is empty: {}", e.getMessage());
//    }
//
//    return false;
//  }
//}
