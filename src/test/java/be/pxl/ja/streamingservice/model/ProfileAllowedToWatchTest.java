package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileAllowedToWatchTest {

    @Test
    public void allowedToWatchTest() {
        Profile profile = new Profile("Ine Menten");
        profile.setDateOfBirth(LocalDate.of(2001, 8, 16));

        Movie movie = new Movie("Titanic", Rating.OLDER_KIDS);

        if (profile.getAge() == 0 || movie.getMaturityRating().getMinimumAge() > profile.getAge()) {
            assertFalse(profile.allowedToWatch(movie));
        } else {
            assertTrue(profile.allowedToWatch(movie));
        }
    }
}
