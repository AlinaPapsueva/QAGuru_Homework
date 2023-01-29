package files.lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import files.lesson8.model.Cat;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParsingTest {

    ClassLoader cl = JsonParsingTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonParsingTest() throws Exception {

        try (
                InputStream resource = cl.getResourceAsStream("cat.json");
                InputStreamReader reader = new InputStreamReader(resource)
        ) {
            Cat jsonCat = objectMapper.readValue(reader, Cat.class);
            assertThat(jsonCat.name).contains("Бусинка");
            assertThat(jsonCat.breed).contains("siberian");
            assertThat(jsonCat.color).contains("gray");
            assertThat(jsonCat.age).isEqualTo(1.5);
            assertThat(jsonCat.relatives).contains("Мурзик");
        }
    }
}
