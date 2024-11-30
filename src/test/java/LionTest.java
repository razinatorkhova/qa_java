import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Lion lion;

    @Mock
    private Feline felineMock;

    @Before
    public void initFeline() {
        lion = new Lion(felineMock);
    }

    @Test
    public void lionCreationWithMaleSexTest() throws Exception {
        Lion maleLion = new Lion("Самец");
        assertTrue("Это Самец", maleLion.doesHaveMane());
    }

    @Test
    public void lionCreationWithFemaleSexTest() throws Exception {
        Lion femaleLion = new Lion("Самка");
        assertFalse("Это Самка", femaleLion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionCreationWithInvalidSexTest() throws Exception {
        new Lion("Некорректный пол");
    }

    @Test
    public void getKittensTest() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        assertEquals("Лев должен иметь 1 котенка по умолчанию", 1, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> mockFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(mockFood);
        assertEquals(mockFood, lion.getFood());
    }

}