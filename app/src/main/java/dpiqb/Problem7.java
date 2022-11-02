package dpiqb;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public int romeToArabic(String rome) {
        Map<Character, Integer> romeArabicValues = new HashMap<>();
        romeArabicValues.put('I', 1);
        romeArabicValues.put('V', 5);
        romeArabicValues.put('X', 10);
        romeArabicValues.put('L', 50);
        romeArabicValues.put('C', 100);
        romeArabicValues.put('D', 500);
        romeArabicValues.put('M', 1000);

        int result = 0;

        char[] romeDigits = rome.toCharArray();

        for (int i = 0; i < romeDigits.length; i++) {
            char currentDigit = romeDigits[i];
            int currentArabicValue = romeArabicValues.get(currentDigit);
            if(i == romeDigits.length - 1){
                result += currentArabicValue;
            }else{
                char nextDigit = romeDigits[i + 1];
                int nextArabicValue = romeArabicValues.get(nextDigit);
                if(nextArabicValue > currentArabicValue){
                    result += nextArabicValue - currentArabicValue;
                }else{
                    result += nextArabicValue + currentArabicValue;
                }
                i++;
            }
        }
        return result;
    }

    public String arabicToRome(int arabic) {
        if ((arabic <= 0) || (arabic > 4000)) {
            throw new IllegalArgumentException(arabic + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((arabic > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= arabic) {
                sb.append(currentSymbol.name());
                arabic -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public String calculateRomanSum(String expression) {
        int arabicSum = Arrays.stream(expression.split("\\+"))
                .mapToInt(it -> romeToArabic(it))
                .sum();
        return arabicToRome(arabicSum);
//        String[] romeNumbers = expression.split("\\+");
//
//        int result = 0;
//        for (String romeNum: romeNumbers) {
//            result += romeToArabic(romeNum);
//        }
//        return arabicToRome(result);
    }

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }
}
