package paramtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Feline;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int inputKittensCount;
    private final int expectedKittens;

    public FelineParamTest(int inputKittensCount, int expectedKittens) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} котенков, ожидается: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},     // Тест с 1 котенком
                {2, 2},     // Тест с 2 котенками
                {5, 5},     // Тест с 5 котенками
        });
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        assertEquals("Количество котят должно соответствовать заданному числу", expectedKittens, feline.getKittens(inputKittensCount));
    }
}
