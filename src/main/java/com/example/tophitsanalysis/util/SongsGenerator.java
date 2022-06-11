package com.example.tophitsanalysis.util;

import com.example.tophitsanalysis.entity.Song;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class SongsGenerator {
    public List<Song> get() throws FileNotFoundException {
        return new CsvToBeanBuilder<Song>(new BufferedReader(new InputStreamReader(Objects.requireNonNull(
                getClass().getResourceAsStream("/songs_normalize.csv"))))).withType(Song.class).build().parse();
    }

    public List<Song> get(String year) throws FileNotFoundException {
        return get().stream()
                .filter(s -> s.getYear() == Integer.parseInt(year))
                .collect(Collectors.toList());
    }
}
