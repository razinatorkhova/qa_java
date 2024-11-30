import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void initFeline() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {

        List<String> food = feline.eatMeat();
        assertNotNull(food);
        assertEquals(3, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void getFamilyTest() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittensDefaultTest() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getKittensWithCountTest() {
        int expectedKittensCount = 5;
        int actualKittens = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, actualKittens);
    }
}