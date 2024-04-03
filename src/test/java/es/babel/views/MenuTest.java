package es.babel.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Mock
    private Menu sut;
    @TempDir
    private File tempDir;

    @BeforeEach
    public void setup() {
        sut = new Menu();
    }

    @Test
    void test_shouldMenu_when() throws IOException {
        // GIVEN
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String formattedDate = dateFormat.format(currentDate);
        String fileName = "password_" + formattedDate + ".txt";
        String path = "C:\\Users\\andrea.aunon\\Desktop\\entorno\\sesion18-ej2";

        // WHEN
        sut.readFile(path);

        // THEN
        assertTrue("File should exist", Files.exists(path.toPath()));
    }

}