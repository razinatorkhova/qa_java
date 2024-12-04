package paramtests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import java.util.Arrays;
import java.util.List;


@RunWith(Parameterized.class)
public class LionParamTest {

    Lion lion;

    @Mock
    Feline felineMock;

    private final String sex;
    private final boolean expectedHasMane;
    private final List<String> expectedFood;

    public LionParamTest(String sex, boolean expectedHasMane, List<String> expectedFood) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name = "Пол: {0} Наличие гривы: {1}, ожидаемая еда: {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true, Arrays.asList("Животные", "Птицы", "Рыба") },
                { "Самка", false, Arrays.asList("Животные", "Птицы", "Рыба") }
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void lionCreationTest() throws Exception {
        lion = new Lion(sex, felineMock);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        // Проверяем список пищи
        Assert.assertEquals("Неверная список пищи", expectedFood, lion.getFood());
        // Проверяем наличие гривы
        Assert.assertEquals("Грива должна быть", expectedHasMane, lion.doesHaveMane());
    }

}