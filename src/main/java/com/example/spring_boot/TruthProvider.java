package com.example.spring_boot;

import org.springframework.stereotype.Component;

@Component
public class TruthProvider {

    public Boolean provide() {
        return true;
    }
}