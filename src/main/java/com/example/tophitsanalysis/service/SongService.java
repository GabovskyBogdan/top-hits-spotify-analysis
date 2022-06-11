package com.example.tophitsanalysis.service;

import com.example.tophitsanalysis.entity.Song;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SongService {

    public List<String> getDeciles(List<Song> songs, String colname) throws NoSuchMethodException, FileNotFoundException {
        Method method = Song.class.getMethod("get" + colname.toUpperCase().charAt(0) + colname.substring(1));
        List colnames = songs.stream().map(s -> {
            try {
                return method.invoke(s);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return "Error";
        }).sorted().collect(Collectors.toList());
        int multiplier = colnames.size() / 10;
        return IntStream.range(0, 10)
                .mapToObj(i -> "min : " + colnames.get(i * multiplier) + ", max : " +
                        colnames.get(((i + 1) * multiplier) - 1) + ", count : " + (i + 1) * 10)
                .collect(Collectors.toList());
    }

    public List<String> getDeciles(List<Song> songs, String colname, String year) throws FileNotFoundException, NoSuchMethodException {
        List songsByYear = songs.stream()
                .filter(s -> s.getYear() == Integer.parseInt(year))
                .collect(Collectors.toList());
        return getDeciles(songsByYear, colname);
    }
}
