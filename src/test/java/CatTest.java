import com.example.Cat;

import com.example.Predator;
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
    private Predator predatorMock;

    @Before
    public void initCat() {
        cat=new Cat(predatorMock);
    }

    @Test
    public void getSoundTest() {
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        // Проверяем, что метод getSound возвращает правильный звук
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        // Задаем поведение мок-объекта predator
        List<String> mockFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(mockFood);

        // Проверяем, что метод getFood возвращает правильный список еды
        assertEquals(mockFood, cat.getFood());
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionTest() throws Exception {
        // Проверяем, что при вызове метода eatMeat возникает исключение
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка получения пищи"));

        cat.getFood(); // Здесь должно произойти исключение
    }
}

