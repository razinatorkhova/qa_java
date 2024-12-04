import org.junit.Before;
import org.junit.Test;
import java.util.List;
import com.example.Feline;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void initFeline() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Неправильный список еды", expectedFood, actualFood);
    }

    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Неправильное семейство", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensDefaultTest() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals("Количество котят по умолчанию не соответствует ожидаемому значению", expectedKittens, actualKittens);
    }

    @Test
    public void getKittensWithCountTest() {
        int expectedKittensCount = 5;
        int actualKittens = feline.getKittens(expectedKittensCount);
        assertEquals("Количество котят не совпадает с заданным значением", expectedKittensCount, actualKittens);
    }
}