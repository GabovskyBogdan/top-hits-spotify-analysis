package com.example.tophitsanalysis.controller;

import com.example.tophitsanalysis.entity.Song;
import com.example.tophitsanalysis.service.SongService;
import com.example.tophitsanalysis.util.ColnameChecker;
import com.example.tophitsanalysis.util.SongsGenerator;
import com.google.common.collect.Range;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SongsController {

    private final SongService service;
    private final SongsGenerator songsGenerator;
    private final ColnameChecker colnameChecker;

    @GetMapping(params = {"colname", "year"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDeciles(@RequestParam String colname, @RequestParam String year) throws FileNotFoundException, NoSuchMethodException {
        List<Song> songs = songsGenerator.get(year);
        Range<Integer> range = Range.open(1998, 2020);
        if (colnameChecker.checkIfColnameAllowedReturnTrue(colname) && range.contains(Integer.parseInt(year))) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getDeciles(songs, colname, year));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide valid colname: duration_ms, year, popularity, danceability, energy, key");
        }
    }

    @GetMapping(params = {"colname"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDeciles(@RequestParam String colname) throws FileNotFoundException, NoSuchMethodException {
        List<Song> songs = songsGenerator.get();
        if (colnameChecker.checkIfColnameAllowedReturnTrue(colname)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getDeciles(songs, colname));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide valid colname: duration_ms, year, popularity, danceability, energy, key");
        }
    }
}