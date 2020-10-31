package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieToStringTest {
    private Movie movie;

    @BeforeEach
    public void init() {
        movie = new Movie("Titanic", Rating.TEENS);
    }

    @Test
    public void testToStringWithoutReleaseDate() {
        String result = movie.getTitle();

        assertEquals(result, movie.toString());
    }

    @Test
    public void testToStringWithReleaseDate() {
        movie.setReleaseDate(LocalDate.of(2000, 1, 2));

        String result = movie.getTitle() + " (" + movie.getReleaseDate().getYear() + ")";

        assertEquals(result, movie.toString());
    }
}
