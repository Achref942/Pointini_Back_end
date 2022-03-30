package com.example.pointini;

import com.example.pointini.entities.Pointage;
import com.example.pointini.entities.User;
import com.example.pointini.services.PointageService;
import com.example.pointini.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class PointiniApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointiniApplication.class, args);

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start (UserService userService, PointageService pointageService){
        return args -> { User user=userService.createUser(new User(1L,null,null,"null",null,22,null,null,null,null,null,null,null,null));
            Pointage pointage=pointageService.createPointage(new Pointage(),user.getId());
            pointageService.updatePointage(pointage,user.getId());
//        pointageService.checkPointage(user.getId());
        };




    }



}
