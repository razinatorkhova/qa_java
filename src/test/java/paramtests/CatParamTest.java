package paramtests;

import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Cat;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class CatParamTest {

    private Cat cat;
    private Predator predatorMock;
    private List<String> expectedFood;
    private Class<? extends Exception> expectedException;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new PredatorMock(Arrays.asList("Курица", "Рыба")), Arrays.asList("Курица", "Рыба"), null},
                {new PredatorMock(Collections.emptyList()), Collections.emptyList(), null},
                {new PredatorMockWithException(), null, Exception.class}
        };
    }

    public CatParamTest(Predator predatorMock, List<String> expectedFood, Class<? extends Exception> expectedException) {
        this.predatorMock = predatorMock;
        this.expectedFood = expectedFood;
        this.expectedException = expectedException;
    }

    @Before
    public void setUp() {
        cat = new Cat(predatorMock);
    }

    @Test
    public void testGetFood() throws Exception {
        if (expectedException != null) {
            assertThrows(expectedException, () -> cat.getFood());
        } else {
            assertEquals(expectedFood, cat.getFood());
        }
    }

    // Мок классы для тестирования
    private static class PredatorMock implements Predator {
        private final List<String> food;

        public PredatorMock(List<String> food) {
            this.food = food;
        }

        @Override
        public List<String> eatMeat() {
            return food;
        }
    }

    private static class PredatorMockWithException implements Predator {
        @Override
        public List<String> eatMeat() throws Exception {
            throw new Exception("Ошибка при получении еды");
        }
    }
}


