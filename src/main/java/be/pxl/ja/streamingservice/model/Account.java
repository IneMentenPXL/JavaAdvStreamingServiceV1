package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.util.PasswordUtil;

import java.util.*;
import java.util.regex.Pattern;

public class Account {
    public static final int MINIMUM_PASSWORD_STRENGTH = 5;

    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();

    public Account(String email, String password) {
        if (email.equals("") || password.equals("")) {
            throw new IllegalArgumentException("Het e-mailadres en het wachtwoord moeten ingevuld zijn.");
        }
        this.email = email;
        this.password = password;
        Profile profile = new Profile("Profile 1");
        streamingPlan = StreamingPlan.BASIC;
        try {
            addProfile(profile);
        } catch (TooManyListenersException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addProfile(Profile profile) throws TooManyListenersException{
        if (profiles.size() == streamingPlan.getNumberOfScreens()) {
            throw new TooManyListenersException("Je kan niet zoveel profielen toevoegen.");
        }
        profiles.add(profile);
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    public boolean verifyPassword(String password) {
        return PasswordUtil.isValid(password, this.password);
    }

    public String getEmail() {
        return email;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPassword(String password) {
        if (PasswordUtil.calculateStrength(password) < MINIMUM_PASSWORD_STRENGTH) {
            throw new IllegalArgumentException("Het wachtwoord moet minstens 5 tekens lang zijn.");
        }
        this.password = password;
    }

    public int getNumberOfProfiles() {
        return profiles.size();
    }

    public List<Profile> getProfiles() {
        profiles.sort(Comparator.comparing(Profile::getName));
        //Het volgende is hetzelfde, maar langer
        /*profiles.sort(new Comparator<Profile>() {
            @Override
            public int compare(Profile profile1, Profile profile2) {
                return profile1.getName().compareTo(profile2.getName());
            }
        });*/
        return profiles;
    }

    public void setEmail(String email) {
        String pattern = "^(.+)@(.+)$";
        if (!email.matches(pattern)) {
            throw new IllegalArgumentException("Het e-mailadres moet een gelig formaat hebben.");
        }
        this.email = email;
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
