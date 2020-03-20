package calculator;

import calculator.exceptions.NegativeFormatException;
import org.assertj.core.api.Assertions;
import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void shouldReturnNumber_whenGivenNumber(){
        Assertions.assertThat(calculator.add("1")).isEqualTo(1);
    }

    @Test
    void shouldReturnZero_whenGivenNumberIsEmpty(){
        Assertions.assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    void shouldReturnSumOfNumbers_whenGivenTwoNumbers(){
        Assertions.assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    void shouldReturnSumOfNumbers_whenGivenSeveralNumbers(){
        Assertions.assertThat(calculator.add("1,2,3,4,5")).isEqualTo(15);
    }

    @Test
    void shouldReturnSumOfNumbers_whenGivenSeveralNumbersAndNewLine(){

        Assertions.assertThat(calculator.add("1,2,3,4,5\n6")).isEqualTo(21);

    }

    @Test
    void shouldReturnNumberFormatException_whenGivenNewLineAfterComa(){

        assertThrows( NumberFormatException.class, () -> calculator.add("1,2,3,4,\n10"));

    }

    @Test
    void shouldReturnNegativeFormatException_whenGivenNegativeNumber(){

        assertThrows(NegativeFormatException.class, () -> calculator.add("-1,2,3,-4,7\n10"));
    }

    @Test
    void shouldReturnAllNegativeNumbersInExceptionMessage_whenGivenNegativeNumbers(){

        NegativeFormatException exception =  assertThrows(NegativeFormatException.class, () -> calculator.add("-1,2,3,-4,7\n10"));
        Assertions.assertThat(exception.getMessage()).isEqualTo("Negatives: -1 -4");
    }
}
