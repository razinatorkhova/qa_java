package paramtests;

import org.junit.Test;
import com.example.Lion;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParamTest {

    private String sex;
    private boolean expectedHasMane;
    private boolean shouldThrowException;

    public LionParamTest(String sex, boolean expectedHasMane, boolean shouldThrowException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true, false },  // ожидается, что у самца есть грива
                { "Самка", false, false }, // ожидается, что у самки нет гривы
                { "Некорректное значение", false, true } // ожидается выброс исключения
        });
    }

    @Test
    public void testLionConstructor() {
        if (shouldThrowException) {
            try {
                new Lion(sex);
                fail("Ожидалось исключение, но его не было.");
            } catch (Exception e) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            }
        } else {
            try {
                Lion lion = new Lion(sex);
                assertEquals(expectedHasMane, lion.doesHaveMane());
            } catch (Exception e) {
                fail("Не должно было возникнуть исключение: " + e.getMessage());
            }
        }
    }
}
