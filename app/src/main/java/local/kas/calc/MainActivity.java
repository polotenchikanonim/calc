package local.kas.calc;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

//1. Напишите обработку каждой кнопки из макета калькулятора.

//2. Создайте объект с данными и операциями калькулятора.
// Продумайте, каким образом будете хранить введённые пользователем данные.

    private Calculate calculate;

    public static void showToast(Context context, String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calculate = new Calculate();

        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.fab);
        imageView.setBackground(AppCompatResources.getDrawable(this, R.drawable.example));
        initButtons();
    }


    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one:
            case R.id.three:
            case R.id.two:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
            case R.id.zero:
                calculate.addNumeralS(v);
                break;
            case R.id.divide:
            case R.id.plus:
            case R.id.multiply:
            case R.id.minus:
                calculate.addSign(v);
                break;
            case R.id.equals:
                calculate.calcAnswer(v);
                break;

        }

    }


    private void initButtons() {
        ConstraintLayout layout = findViewById(R.id.ConstraintLayout);

        for (int i = 0; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) instanceof AppCompatButton) {
                layout.getChildAt(i).setOnClickListener(this::onClick);
            }
        }
    }
}