package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieIsLongPlayingTimeTest {
    private Movie movie;

    @BeforeEach
    public void init() {
        movie = new Movie("Titanic", Rating.OLDER_KIDS);
    }

    @Test
    public void returnsFalseIfDurationLessThanLongPlayingTime() {
        movie.setDuration(Movie.LONG_PLAYING_TIME - 1);

        boolean result = movie.isLongPlayingTime();

        assertFalse(result);
    }

    @Test
    public void returnsTrueIfDurationMoreThanLongPlayingTime() {
        movie.setDuration(Movie.LONG_PLAYING_TIME + 1);

        assertTrue(movie.isLongPlayingTime());
    }

    @Test
    public void returnsTrueIfDurationExactlyLongPlayingTime() {
        movie.setDuration(Movie.LONG_PLAYING_TIME);

        assertTrue(movie.isLongPlayingTime());
    }
}
