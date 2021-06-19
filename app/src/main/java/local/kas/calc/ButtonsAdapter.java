package local.kas.calc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ButtonsAdapter extends RecyclerView.Adapter<ButtonsAdapter.MyViewholder> {


    private final Context context;
    private final ArrayList<MyButton> myTask;
    private MyButton task;

    public ButtonsAdapter(Context context, ArrayList<MyButton> myTask) {
        this.context = context;
        this.myTask = myTask;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.item_does, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder myViewHolder, int position) {
        String coordinats;
        task = myTask.get(position);

        myViewHolder.num_task.setText(String.valueOf(position + 1));
        myViewHolder.title_route.setText(myTask.get(position).getView());

        coordinats = task.getCoordinats();


        DecimalFormat df = new DecimalFormat("0.000");
        if (!coordinats.equals("")) {
            myViewHolder.volume_1.setText(
                    df.format(Float.parseFloat(coordinats))
            );
        }


        myViewHolder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Да будут счёты", Toast.LENGTH_SHORT).show();
//            if (checkQueue(position)){
//                changeIntent(position);
//            }
        });
    }

    static class MyViewholder extends RecyclerView.ViewHolder {
        TextView num_task, title_route, volume_1, volume_2;
        LinearLayout volumes;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            title_route = itemView.findViewById(R.id.title_route);
        }
    }

//    private boolean checkQueue(int position) {
//        int start = 0;
//        for (MyButton task : myTask) {
//            if (position>start){
//                if (MyConstants.LAST_STAGE>task.getStage()) {
//                    showDialog(position);
//                    return false;
//                }
//                start += 1;
//            }
//        }
//        return true;
//    }

//    private void showDialog(int position) {
//        new AlertDialog.Builder(context)
//                .setTitle("Не заполнены данные по предыдущему рейсу.")
//                .setMessage("Уверены, что хотите перейти к заполнению этого рейса?")
//                .setPositiveButton(R.string.yes, (dialog, which) -> changeIntent(position))
//                .setNegativeButton(R.string.no, (dialog, which) -> dialog.cancel())
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show();
//    }

//    private void changeIntent(int position) {
//        task = myTask.get(position);
//        Intent intent = new Intent(context, TaskActivity.class);
//        intent.putExtra("position", (byte) position)
//                .putExtra(MyConstants.ID_TASK, task.getIdTask())
//        ;
//        ((Activity)context).finish();
//        context.startActivity(intent);
//    }

    @Override
    public int getItemCount() {
        return myTask.size();
    }

//
//    @NonNull
//    @Override
//    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.item_does, viewGroup, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewholder myViewHolder, int position) {
//        String volume_1,volume_2;
//        task = myTask.get(position);
//
//        myViewHolder.num_task.setText(String.valueOf(position + 1));
//        myViewHolder.title_route.setText(myTask.get(position).getRoute());
//
//        volume_1 = task.getVolume_1();
//        volume_2 = task.getVolume_2();
//
//        DecimalFormat df = new DecimalFormat("0.000");
//        if (!volume_1.equals("")) {
//            myViewHolder.volume_1.setText(
//                    df.format(Float.parseFloat(volume_1))
//            );
//        }
//        if (task.getDual().equals("1")) {
//            if (!volume_2.equals("")) {
//                myViewHolder.volume_2.setText(
//                        df.format(Float.parseFloat(volume_2))
//                );
//            }
//        }
//
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    static class MyViewholder extends RecyclerView.ViewHolder {
//        TextView num_task, title_route, volume_1, volume_2;
//        LinearLayout volumes;
//        public MyViewholder(@NonNull View itemView) {
//            super(itemView);
//            num_task = itemView.findViewById(R.id.num_task);
//            title_route = itemView.findViewById(R.id.title_route);
//            volumes = itemView.findViewById(R.id.volumes);
//            volume_1 = itemView.findViewById(R.id.volume_1);
//            volume_2 = itemView.findViewById(R.id.volume_2);
//        }
//    }
//    static class MyViewholder extends RecyclerView.ViewHolder {
//        TextView num_task, title_route, volume_1, volume_2;
//        LinearLayout volumes;
//        public MyViewholder(@NonNull View itemView) {
//            super(itemView);
////            num_task = itemView.findViewById(R.id.num_task);
////            title_route = itemView.findViewById(R.id.title_route);
////            volumes = itemView.findViewById(R.id.volumes);
////            volume_1 = itemView.findViewById(R.id.volume_1);
////            volume_2 = itemView.findViewById(R.id.volume_2);
//        }
//    }
}
