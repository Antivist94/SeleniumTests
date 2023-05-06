import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    @Test
    @Description("Тест на определение нормального веса")
    public void testNormalWeight() {
        var actualResult = getIMTResult(180f,75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }
    @Test
    @Description("Тест на определение избыточного веса")
    public void testOverWeight() {
        var actualResult = getIMTResult(181f,102f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }
    @Test
    @Description("Тест на определение недостаточного веса")
    public void testSmallWeight() {
        var actualResult = getIMTResult(150f, 40f);
        Assert.assertEquals("недостаточной массе тела", actualResult);

    }
    @Test
    @Description("Тест на определение выраженного дефицита веса")
    public void testRealySmallWeight() {
        var actualResult = getIMTResult(190f, 50f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);

    }
    @Test
    @Description("Негативный тест на рост - указан рост 0 см")
    public void negativeWeightTest1() {
        var actualResult = getIMTResult(0f,40f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }
    @Test
    @Description("Негативный тест на рост - указан рост 350 см")
    public void negativeWeightTest2() {
        var actualResult = getIMTResult(350f,40f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }
    @Test
    @Description("Негативный тест на вес - указан вес 0 кг")
    public void negativeHeightTest1() {
        var actualResult = getIMTResult(160f,0f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }
    @Test
    @Description("Негативный тест на вес - указан вес 1000 кг")
    public void negativeHeightTest2() {
        var actualResult = getIMTResult(160f,1000f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    @Description("Тест на граничные значения: поле рост - 1см и вес 1кг")
    public void boundaryTest1() {
        var actualResult = getIMTResult(1f,1f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения: поле рост - 349см и вес 999кг")
    public void boundaryTest2() {
        var actualResult = getIMTResult(3490f,999f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения. Определение ИМТ для самой малой границы выраженного дефицита массы тела .")
    public void boundaryTest3() {
        var actualResult = getIMTResult(180f,42f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения. Определение ИМТ для самой малой границы выраженного дефицита массы тела .")
    public void boundaryTest4() {
        var actualResult = getIMTResult(160f,44f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения. Определение ИМТ для самой малой границы недостаточного веса.")
    public void boundaryTest5() {
        var actualResult = getIMTResult(190f,61f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения. Определение ИМТ для самой большой границы недостаточного веса.")
    public void boundaryTest6() {
        var actualResult = getIMTResult(190f,69f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения. Определение ИМТ для самой малой границы нормального  веса.")
    public void boundaryTest7() {
        var actualResult = getIMTResult(190f,70f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения. Определение ИМТ для самой большой границы нормального  веса.")
    public void boundaryTest8() {
        var actualResult = getIMTResult(182f,85f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }
    @Test
    @Description("Тест на граничные значения. Определение ИМТ для самой большой границы избыточного  веса.")
    public void boundaryTest9() {
        var actualResult = getIMTResult(181f,81f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }
    private String getIMTResult(Float heightCm, Float weightKg) {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19) {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult += "указан некорректный рост";
        return userResult;
    }
}
