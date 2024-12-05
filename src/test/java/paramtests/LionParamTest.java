package paramtests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import com.example.Feline;
import com.example.Lion;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class LionParamTest {

    Lion lion;

    @Mock
    Feline felineMock;

    private final String sex;
    private final boolean expectedHasMane;

    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0} Наличие гривы: {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true},
                { "Самка", false}
        });
    }

    @Test
    public void lionCreationTest() throws Exception {
        lion = new Lion(sex, felineMock);

        // Проверяем наличие гривы
        Assert.assertEquals("Грива должна быть", expectedHasMane, lion.doesHaveMane());
    }

}