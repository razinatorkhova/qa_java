import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    Cat cat;

    @Mock
    Feline felineMock;

    @Before
    public void initCat() {
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundTest() {
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();

        assertEquals("Неверный звук", expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        // Задаем поведение мок-объекта felineMock
        List<String> mockFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(mockFood);

        assertEquals("Неверный список еды", mockFood, cat.getFood());
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionTest() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка получения пищи"));

        cat.getFood(); // Здесь должно произойти исключение
    }
}
