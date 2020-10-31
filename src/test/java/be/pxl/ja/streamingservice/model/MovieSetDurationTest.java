package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieSetDurationTest {
    @Test
    public void negativeDurationTest() {
        Movie movie = new Movie("Titanic", Rating.OLDER_KIDS);

        movie.setDuration(-125);

        assertEquals(125, movie.getDuration());
    }

    @Test
    public void positiveDurationTest() {
        Movie movie = new Movie("Titanic", Rating.OLDER_KIDS);

        movie.setDuration(125);

        assertEquals(125, movie.getDuration());
    }
}
