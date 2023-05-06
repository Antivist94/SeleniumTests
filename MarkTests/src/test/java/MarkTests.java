import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class MarkTests {
    @Test
    @Description("Тест на граничные значения, 0 баллов - оценка 2")
    public void BoundaryTestMark1() {
        var actualResult = getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }
    @Test
    @Description("Тест на граничные значения, 35 баллов - оценка 2")
    public void BoundaryTestMark2() {
        var actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }
    @Test
    @Description("Тест на граничные значения, 36 баллов - оценка 3")
    public void BoundaryTestMark3() {
        var actualResult = getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }
    @Test
    @Description("Тест на граничные значения, 56 баллов - оценка 3")
    public void BoundaryTestMark4() {
        var actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }
    @Test
    @Description("Тест на граничные значения, 57 баллов - оценка 4")
    public void BoundaryTestMark5() {
        var actualResult = getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }
    @Test
    @Description("Тест на граничные значения, 71 балл - оценка 4")
    public void BoundaryTestMark6() {
        var actualResult = getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    @Description("Тест на граничные значения, 72 балла - оценка 5")
    public void BoundaryTestMark7() {
        var actualResult = getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }
    @Test
    @Description("Тест на граничные значения, 100 баллов - оценка 5")
    public void BoundaryTestMark8() {
        var actualResult = getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    @Description("Негативный тест: ввод отрицательного значение (-1)")
    public void NegativeTestMark() {
        var actualResult = getMarkResult(-1);
        Assert.assertEquals("no mark result", actualResult);
    }
    @Test
    @Description("Негативный тест: ввод значения больше 100 (101)")
    public void NegativeTestMark2() {
        var actualResult = getMarkResult(101);
        Assert.assertEquals("no mark result", actualResult);
    }

    private String getMarkResult(Integer mark) {

        if(mark>=0 && mark <=35) return "2";

        if(mark>35 && mark <=56) return "3";

        if(mark>56 && mark<71) return "4";

        if(mark>72 && mark<100) return "5";

        return "no mark result";

    }
}
