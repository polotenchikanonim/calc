package local.kas.calc;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    //    Вы использовали app:layout_constraintVertical_bias="0.68"
//    При этом задав "жесткий" размер в 400dp
//    нужно понимать, что таким побразом, вы на notlong устройствах(поиграйтесь в дизайне, для
//    разных типов экранов. Прижимаете свои кнопки к нижней части экрана, а то и вовсе выдавливаете
//    их за пределы экрана. попробуйте поиграть с
//    android:layout_height="0dp"
//    app:layout_constraintHeight_percent="[0-1]"
//    посмотрите на сколько это гибче выглядит на разных экранах
    //    Вы воспользовались хитростью, и установили жетскую ориентаци.
//    Это допустимо, многие так поступают в своих ЛИЧНЫХ проектах, или когда дизайнеры сговорчивые
//    Но нужно понимать, что если вы планируете устраиваться на галеру, то там от вас будут
//    требовать грести в унисон с остальными гребцами. Поэтому давайте все же напишем макет land
//    для горизотнтальной ориентации. Будем выводить значения не только в тост, но и в какой-нибудь
//    тексвью, При этом от вас требуется, чтобы при повороте экрана, значения в текствью не менялись
//    Иначе пользователь будет расстроен, увидев что вся его работа потеряна
    private Calculate calculate;
    private TextView textView;
    private final String KEY = "key_calculate";

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
        textView = findViewById(R.id.textView2);
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
                calculate.calcAnswer(v);
                break;
        }
    }


    private void initView() {
        ConstraintLayout layout = findViewById(R.id.ConstraintLayout);
        layout.setBackgroundColor(ContextCompat.getColor(this, R.color.darkThemeColorTV));
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

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//    }

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