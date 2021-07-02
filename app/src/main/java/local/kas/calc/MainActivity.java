package local.kas.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private Calculate calculate;
    private TextView textView;
    private final String KEY = "key_calculate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = new Calculate();

        initView();
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
                textView.setText(calculate.addNumeral(v));
                break;
            case R.id.divide:
            case R.id.plus:
            case R.id.multiply:
            case R.id.minus:
                textView.setText(calculate.addSign(v));
                break;
            case R.id.equals:
                textView.setText(calculate.calcAnswer(v));
                break;
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
        }
    }


    private void initView() {
        ImageView imageView = findViewById(R.id.fab);
        imageView.setBackground(AppCompatResources.getDrawable(this, R.drawable.example));
        findViewById(R.id.settings).setOnClickListener(this::onClick);
        textView = findViewById(R.id.textView);

        ConstraintLayout layout = findViewById(R.id.ConstraintLayout);
        for (int i = 0; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) instanceof AppCompatButton) {
                layout.getChildAt(i).setOnClickListener(this::onClick);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, calculate);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculate = (Calculate) savedInstanceState.getSerializable(KEY);
        restoreView();
    }

    private void restoreView() {
        textView.setText(calculate.getTv());
    }

}