package id.ac.polinema.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P01MainOutputTest {

    @Test
    @Timeout(10)
    @DisplayName("Baris pertama output Main adalah 'Welcome to Polinema Library'")
    void firstLineIsWelcome() {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            Main.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        String first = buffer.toString(StandardCharsets.UTF_8).lines().findFirst().orElse("");
        assertEquals("Welcome to Polinema Library", first,
                "Baris pertama output harus persis 'Welcome to Polinema Library'");
    }
}
