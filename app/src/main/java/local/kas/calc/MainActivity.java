package local.kas.calc;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

//  1. С этого урока будем писать приложение «Калькулятор». Выберите макет для работы с
//  калькулятором. Обоснуйте, почему будете использовать именно этот тип макета.

//  2. Сверстайте главный экран калькулятора. На нём должны быть кнопки, обозначающие цифры и знаки
// действия: «Плюс», «Умножить», «Разделить», «Вычесть» и т. п.

//  3. * Добавьте фоновый рисунок для экрана калькулятора. Следите, чтобы рисунок был для общего
//  использования. Ресурсы: https://pxhere.com/, https://pixabay.com/ru/.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.fab);
        imageView.setBackground(AppCompatResources.getDrawable(this, R.drawable.example));
//        ConstraintLayout layout = findViewById(R.id.ConstraintLayout);
//        layout.setBackground(AppCompatResources.getDrawable(this, R.drawable.example));
    }

}