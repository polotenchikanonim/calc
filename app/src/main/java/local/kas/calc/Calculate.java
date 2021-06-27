package local.kas.calc;

import android.view.View;
import android.widget.Button;

import java.io.Serializable;


public class Calculate implements Serializable {

    private String operation;
    private String firstNumeralS;
    private String secondNumeralS;
    private String tv;

    public Calculate() {
        firstNumeralS = "";
        secondNumeralS = "";
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getTv() {
        return tv;
    }

    public String addSign(View v) {
        String operation = ((Button) v).getText().toString();
        setOperation(operation);
        setTv(getFirstNumeralS() + " " + getOperation());
        return getTv();
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

    public String addNumeral(View v) {
        String numeralS = ((Button) v).getText().toString();
        if (getOperation() == null) {
            setFirstNumeralS(getFirstNumeralS() + numeralS);
            setTv(getFirstNumeralS());
        } else {
            setSecondNumeralS(getSecondNumeralS() + numeralS);
            setTv(getFirstNumeralS() + " " + getOperation() + " " + getSecondNumeralS());
        }
        return getTv();
    }
}
