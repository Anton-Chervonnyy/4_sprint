import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters (name = "Test if {0} returns {1}")
    public static Object[][] testData(){
        return new Object[][] {
                { null, false },
                { "Василий", false },
                { "ВасилийИванович", false },
                { " Василий Иванович", false },
                { "Василий Иванович ", false },
                { "Василий Елесеевскийъ", false },
                { "", false },
                { "   ", false },
                { "  ", false },
                { "Я Н", true },
                { "Василий Иванович", true }
        };
    }

    @Test
    @DisplayName("Validation test")
    @Description("Validate if the input returns correct output")
    public void cardNameTest(){

        Account account = new Account(name);
        Assert.assertEquals(expected, account.checkNameToEmboss());
    }


}