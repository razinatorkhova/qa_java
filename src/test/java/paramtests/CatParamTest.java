package paramtests;

import com.example.Feline;
import com.example.Cat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CatParamTest {

    private final Feline feline;
    private final String expectedSound;
    private final List<String> expectedFood;

    public CatParamTest(Feline feline, String expectedSound, List<String> expectedFood) {
        this.feline = feline;
        this.expectedSound = expectedSound;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name = "Тестовые данные: Feline={0}, expectedSound={1}, expectedFood={2}")
    public static Iterable<Object[]> data() {
        Feline feline1 = new Feline();
        Feline feline2 = new Feline();
        return Arrays.asList(new Object[][]{
                        {feline1, "Мяу", Arrays.asList("Животные", "Птицы", "Рыба")},
                        {feline2, "Мяу", Arrays.asList("Животные", "Птицы", "Рыба")} // Тестовые данные для второй кошки}
                });
    }

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Неверный звук", expectedSound, cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        assertEquals("Неверная еда", expectedFood, cat.getFood());
    }
}
