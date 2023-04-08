package app.webApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CashCardApplicationTest
{
    @Test
    public void myFirstTest() {
        assertThat(1).isEqualTo(1);
    }
}
