package com.example.tophitsanalysis.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Getter
public class Song {
    @CsvBindByName
    private String artist;
    @CsvBindByName
    private String song;
    @CsvBindByName
    private Integer duration_ms;
    @CsvBindByName
    private boolean explicit;
    @CsvBindByName
    private int year;
    @CsvBindByName
    private int popularity;
    @CsvBindByName
    private double danceability;
    @CsvBindByName
    private double energy;
    @CsvBindByName
    private int key;
    @CsvBindByName
    private double loudness;
    @CsvBindByName
    private int mode;
    @CsvBindByName
    private double speechiness;
    @CsvBindByName
    private double acousticness;
    @CsvBindByName
    private double instrumentalness;
    @CsvBindByName
    private double liveness;
    @CsvBindByName
    private double valence;
    @CsvBindByName
    private double tempo;
    @CsvBindByName
    private String genre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song1 = (Song) o;
        return explicit == song1.explicit && year == song1.year && popularity == song1.popularity && Double.compare(song1.danceability, danceability) == 0 && Double.compare(song1.energy, energy) == 0 && key == song1.key && Double.compare(song1.loudness, loudness) == 0 && mode == song1.mode && Double.compare(song1.speechiness, speechiness) == 0 && Double.compare(song1.acousticness, acousticness) == 0 && Double.compare(song1.instrumentalness, instrumentalness) == 0 && Double.compare(song1.liveness, liveness) == 0 && Double.compare(song1.valence, valence) == 0 && Double.compare(song1.tempo, tempo) == 0 && Objects.equals(artist, song1.artist) && Objects.equals(song, song1.song) && Objects.equals(duration_ms, song1.duration_ms) && Objects.equals(genre, song1.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, song, duration_ms, explicit, year, popularity, danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, genre);
    }
}
