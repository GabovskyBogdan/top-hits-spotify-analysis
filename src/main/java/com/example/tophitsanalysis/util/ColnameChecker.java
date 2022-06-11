package com.example.tophitsanalysis.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ColnameChecker {

    private List<String> allowedColnameToEvaluateDeciles;

    public boolean checkIfColnameAllowedReturnTrue(String colname) {
        allowedColnameToEvaluateDeciles = List.of("duration_ms", "year", "popularity", "danceability", "energy", "key");
        if (allowedColnameToEvaluateDeciles.contains(colname.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
