package local.kas.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

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
        ArrayList<String> buttons = null;
        buttons.add("A");
        buttons.add("B");
        buttons.add("C");
        showButtons(buttons);

    }

    private void showButtons(ArrayList<String[]> tasks) {
        ConstraintLayout layout = findViewById(R.id.relative);
        ArrayList<MyButton> list = convertTasksToHolders(tasks);
        ButtonsAdapter taskAdapter = new ButtonsAdapter(this, list);

//        public void showTasksAT(Context mContext, ArrayList<String[]> tasks, LinearLayout layout){

//            ArrayList<Task> list = convertTasksToHolders(tasks);
//            TaskAdapter taskAdapter = new TaskAdapter(mContext, list);
//
//            RecyclerView myTasks = layout.findViewById(R.id.myTasksRV);
//            myTasks.setLayoutManager(new LinearLayoutManager(mContext));
//            myTasks.setAdapter(taskAdapter);
//        }

    }

    private ArrayList<MyButton> convertTasksToHolders(ArrayList<String[]> buttons) {
        String route, volume_1, volume_2, dual, stage, id_task;
        ArrayList<MyButton> list = new ArrayList<>();
        for(String[] i : buttons){
            stage = i[2];
            dual = i[3];

            MyButton task = new MyButton(
                    text, id, stage, dual,
                    volume_1
            );
            list.add(task);
        }
        return list;
    }
}