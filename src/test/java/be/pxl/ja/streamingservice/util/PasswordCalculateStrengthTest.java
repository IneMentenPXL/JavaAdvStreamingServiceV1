package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordCalculateStrengthTest {
    private int strength;
    private String password;

    @BeforeEach
    public void init() {
        strength = 0;
    }

    @Test
    public void shortPasswordTest() {
        password = "user";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 0);
    }

    @Test
    public void longPasswordOneExtraTest() {
        password = "useruseruser";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 4);
    }

    @Test
    public void longPasswordTwoExtraTest() {
        password = "USERUSERuser";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 6);
    }

    @Test
    public void LongPasswordThreeExtraTest() {
        password = "USERuser@@@@";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 8);
    }

    @Test
    public void longPasswordFourExtraTest() {
        password = "USer@@@@1234";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 10);
    }

    @Test
    public void mediumPasswordOneExtraTest() {
        password = "useruser";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 3);
    }

    @Test
    public void mediumPasswordTwoExtraTest() {
        password = "USERuser";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 5);
    }

    @Test
    public void mediumPasswordThreeExtraTest() {
        password = "USERus@@";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 7);
    }

    @Test
    public void mediumPasswordFourExtraTest() {
        password = "USer@@12";
        strength = PasswordUtil.calculateStrength(password);
        assertEquals(strength, 9);
    }
}
