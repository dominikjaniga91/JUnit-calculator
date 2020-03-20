package calculator;

import calculator.exceptions.NegativeFormatException;

import java.util.*;

public class Calculator {

    public int add(String number) {

        String[] numbers = number.split("[,\\n]");


        int sum = 0;

        if(number.isEmpty()){
            return 0;
        }else{
            for (String tempNumber: numbers) {

                if(isNegative(tempNumber)){
                    throw new NegativeFormatException(returnNegativeNumbers(numbers));
                }
                sum += Integer.parseInt(tempNumber);

            }
        }
        return sum;
    }

    private boolean isNegative(String tempNumber) {
        return Integer.parseInt(tempNumber) < 0;
    }

    private String returnNegativeNumbers(String[] numbers){
        StringJoiner joiner = new StringJoiner(" ");
        for (String number: numbers) {
            if (Integer.parseInt(number) < 0)
                joiner.add(number);
        }
        return  joiner.toString();
    }

}
