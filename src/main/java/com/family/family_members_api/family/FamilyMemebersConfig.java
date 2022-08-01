package com.family.family_members_api.family;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FamilyMemebersConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            FamilyMembersRepository repository) {
        return args -> {

        };
    }
}
