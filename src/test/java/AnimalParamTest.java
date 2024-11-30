import com.example.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Predator;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    private final String animalKind;
    private final List<String> expectedFood;
    private final String expectedExceptionMessage;

    public AnimalParamTest(String animalKind, List<String> expectedFood, String expectedExceptionMessage) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения"), null },
                { "Хищник", List.of("Животные", "Птицы", "Рыба"), null },
                { "Неизвестное животное", null, "Неизвестный вид животного, используйте значение Травоядное или Хищник" }
        });
    }

    @Test
    public void testGetFood() {
        Animal animal = new Animal();
        if (expectedExceptionMessage != null) {
            Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
            assertEquals(expectedExceptionMessage, exception.getMessage());
        } else {
            try {
                List<String> food = animal.getFood(animalKind);
                assertEquals(expectedFood, food);
            } catch (Exception e) {
                fail("Unexpected Exception: " + e.getMessage());
            }
        }
    }
}

@RunWith(Parameterized.class)
class LionClassGetSexParamTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionClassGetSexParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false }
        });
    }

    }

@RunWith(Parameterized.class)
class CatClassGetFoodParamTest {

    private final List<String> mockFood;
    private final Exception expectedException;

    public CatClassGetFoodParamTest(List<String> mockFood, Exception expectedException) {
        this.mockFood = mockFood;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("Мясо", "Рыба"), null},
                {Arrays.asList("Курица", "Говядина"), null},
                {null, new Exception("Пустой ответ")}
        });
    }

    @Test
    public void testGetFood() throws Exception {
        // Создание мока для Predator
        Predator predatorMock = mock(Predator.class);

        // Определение поведения мока
        if (expectedException == null) {
            when(predatorMock.eatMeat()).thenReturn(mockFood);
        } else {
            when(predatorMock.eatMeat()).thenThrow(expectedException);
        }

        Cat cat = new Cat(predatorMock);

        // Проверка результата
        if (expectedException == null) {
            assertEquals(mockFood, cat.getFood());
        } else {
            try {
                cat.getFood();
                fail("Ожидается исключение, но его не было");
            } catch (Exception e) {
                assertEquals(expectedException.getMessage(), e.getMessage());
            }
        }
    }
}
