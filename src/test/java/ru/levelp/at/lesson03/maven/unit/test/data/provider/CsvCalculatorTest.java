package ru.levelp.at.lesson03.maven.unit.test.data.provider;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.maven.unit.test.inheretence.CalculatorBaseTest;

public class CsvCalculatorTest extends CalculatorBaseTest {

    @DataProvider
    public Object[][] csvDataProvider() {
        List<String> testData = new ArrayList<>();
        try {
            testData = Files.readAllLines(Path.of(
                this.getClass().getResource("/ru/levelp/at/lesson03_04/unit/tests/data/sample_data.csv").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int size = testData.size();
        Object[][] data = new Object[size][3];

        for (int i = 0; i < size; i++) {
            var row = testData.get(i);
            var cells = row.split(",");
            data[i][0] = Integer.parseInt(cells[0]);
            data[i][1] = Integer.parseInt(cells[1]);
            data[i][2] = Integer.parseInt(cells[2]);
        }

        return data;
    }

    @Test(dataProvider = "csvDataProvider")
    public void sumCalculatorTest(Integer a, Integer b, Integer expectedResult) {
        int actualResult = calculator.sum(a, b);
        assertEquals(actualResult, expectedResult);
    }
}
