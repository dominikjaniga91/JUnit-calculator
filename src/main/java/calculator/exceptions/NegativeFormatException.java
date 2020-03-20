package calculator.exceptions;

public class NegativeFormatException extends RuntimeException{

    public NegativeFormatException(String negativeNumbers) {
        super("Negatives: " + negativeNumbers);
    }
}
