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

    @Mock
    Feline felineMock;

    Lion maleLion;
    Lion femaleLion;

    @Before
    public void setUp() throws Exception {
        maleLion = new Lion("Самец", felineMock);
        femaleLion = new Lion("Самка", felineMock);
    }

    @Test
    public void lionCreationWithMaleSexTest() throws Exception {
        assertTrue("Мужской лев должен иметь гриву", maleLion.doesHaveMane());
    }

    @Test
    public void lionCreationWithFemaleSexTest() throws Exception {
        assertFalse("Женский лев не должен иметь гривы", femaleLion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionCreationWithInvalidSexTest() throws Exception {
        new Lion("Некорректный пол", felineMock); // Передаем пол и объект Feline
    }

    @Test
    public void getKittensTest() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        int kittens = maleLion.getKittens();
        assertEquals("Лев должен иметь 1 котенка по умолчанию", 1, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> mockFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(mockFood);
        assertEquals("Неверный список еды", mockFood, maleLion.getFood());
    }
}
