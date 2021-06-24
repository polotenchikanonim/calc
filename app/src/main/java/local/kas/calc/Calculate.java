package local.kas.calc;

import android.view.View;
import android.widget.Button;


public class Calculate {

    private String operation;
    private String firstNumeralS;
    private String secondNumeralS;

    public Calculate() {
        firstNumeralS = "";
        secondNumeralS = "";
    }

    public void addNumeralS(View v) {
        String numeralS = ((Button) v).getText().toString();
        if (getOperation() == null) {
            setFirstNumeralS(getFirstNumeralS() + numeralS);
            MainActivity.showToast(v.getContext(), getFirstNumeralS());
        } else {
            setSecondNumeralS(getSecondNumeralS() + numeralS);
            MainActivity.showToast(v.getContext(), getFirstNumeralS() + " " + getOperation() + " " + getSecondNumeralS());
        }
    }

    public void addSign(View v) {
        String operation = ((Button) v).getText().toString();
        setOperation(operation);
        MainActivity.showToast(v.getContext(), getFirstNumeralS() + " " + getOperation());
    }

    public String getFirstNumeralS() {
        return firstNumeralS;
    }

    public void setFirstNumeralS(String firstNumeralS) {
        this.firstNumeralS = firstNumeralS;
    }

    public String getSecondNumeralS() {
        return secondNumeralS;
    }

    public void setSecondNumeralS(String secondNumeralS) {
        this.secondNumeralS = secondNumeralS;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void calcAnswer(View v) {
        double firstNumeral, secondNumeral;
        firstNumeral = Double.parseDouble(getFirstNumeralS());
        secondNumeral = Double.parseDouble(getSecondNumeralS());
        double answer = 0;
        String operation = getOperation();
        switch (operation) {
            case "+":
                answer = firstNumeral + secondNumeral;
                break;
            case "-":
                answer = firstNumeral - secondNumeral;
                break;
            case "/":
                answer = firstNumeral / secondNumeral;
                break;
            case "*":
                answer = firstNumeral * secondNumeral;
                break;
        }
        if ((int) answer < answer) {
            showAnswer(v, String.valueOf(answer));
        } else {
            showAnswer(v, String.valueOf((int) answer));
        }
        clearVariables();
    }

    private void showAnswer(View v, String answer) {
        MainActivity.showToast(v.getContext(), getFirstNumeralS() + " " + getOperation() + " " + getSecondNumeralS() + " = " + answer);
        clearVariables();
    }


    private void clearVariables() {
        setFirstNumeralS("");
        setSecondNumeralS("");
        setOperation(null);
    }
}
