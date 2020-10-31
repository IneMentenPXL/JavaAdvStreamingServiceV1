package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Profile {
    private static final int MAX_RECENTLY_WATCHED_SIZE = 5;
    private static final int MAX_CURRENTLY_WATCHING_SIZE = 3;

    private String name;
    private LocalDate dateOfBirth;
    private String avatar;
    private LinkedList<Content> recentlyWatched = new LinkedList<>();
    private LinkedList<Content> currentlyWatching = new LinkedList<>();
    private LinkedList<Content> myList = new LinkedList<>();

    public Profile(String name, String avatar) {
        new Profile(name);
        this.avatar = avatar;
    }

    public Profile(String name) {
        this.name = name;
        this.avatar = "profile1";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new InvalidDateException(dateOfBirth, "dateOfBirth", "Must be in the past.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        if (dateOfBirth == null) {
            return 0;
        }
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    public String getAvatar() {
        return avatar;
    }

    public LinkedList<Content> getRecentlyWatched() {
        return recentlyWatched;
    }

    public LinkedList<Content> getCurrentlyWatching() {
        return currentlyWatching;
    }

    public LinkedList<Content> getMyList() {
        return myList;
    }

    public void addToMyList(Content content) {
        if (isInMyList(content)) {
            myList.add(content);
        }
    }

    public boolean isInMyList(Content content) {
        return myList.contains(content);
    }

    public void removeFromMyList(Content content) {
        myList.remove(content);
    }

    public boolean allowedToWatch(Content content) {
        return dateOfBirth != null && content.getMaturityRating().getMinimumAge() <= getAge();
    }

    public void startWatching(Content content) {
        if (!currentlyWatching.contains(content)) {
            currentlyWatching.addFirst(content);
        }
    }

    public void finishWatching(Content content) {
        currentlyWatching.remove(content);
        recentlyWatched.addFirst(content);
    }
}
