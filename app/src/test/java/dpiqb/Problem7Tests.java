package dpiqb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Problem7Tests {
    @Test
    public void testThatRomeToArabicMethodWorksOk(){
        Map<String, Integer> testCases = new LinkedHashMap<>();
        testCases.put("I", 1);
        testCases.put("II", 2);
        testCases.put("III", 3);
        testCases.put("IV", 4);
        testCases.put("V", 5);
        testCases.put("VI", 6);
        testCases.put("VII", 7);
        testCases.put("VIII", 8);
        testCases.put("IX", 9);
        testCases.put("X", 10);

        testCases.put("C", 100);
        testCases.put("M", 1000);
        testCases.put("L", 50);
        testCases.put("D", 500);

        testCases.put("LIII", 53);
        testCases.put("XCVIII", 98);
        testCases.put("DLX", 560);

        testCases.forEach((rome, expectedArabic) ->
                Assertions.assertEquals(
                        expectedArabic,
                        new Problem7().romeToArabic(rome),
                        rome // это выведется если тест упадёт
                )
        );
    }
    @Test
    public void testThatArabicToRomeMethodWorksOk(){
        Map<Integer, String> testCases = new HashMap<>();
        testCases.put(1, "I");
        testCases.put(2, "II");
        testCases.put(3, "III");
        testCases.put(4, "IV");
        testCases.put(5, "V");
        testCases.put(6, "VI");
        testCases.put(7, "VII");
        testCases.put(8, "VIII");
        testCases.put(9, "IX");
        testCases.put(10, "X");

        testCases.put(98, "XCVIII");

        testCases.forEach((arabic, expectedRome) ->
                Assertions.assertEquals(
                        expectedRome,
                        new Problem7().arabicToRome(arabic),
                        Integer.toString(arabic)
                )
        );
    }

    @Test
    public void testThatCalculateMethodWorksOk(){
        Map<String, String> testCases = new HashMap<>();
        testCases.put("III+IV", "VII");
        testCases.put("II+II", "IV");
        testCases.put("I+X", "XI");

        testCases.forEach((expression, expected) -> {
            Assertions.assertEquals(
                    expected,
                    new Problem7().calculateRomanSum(expression),
                    expression
            );
        });
    }
}