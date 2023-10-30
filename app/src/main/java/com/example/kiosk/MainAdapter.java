package com.example.kiosk;

import static androidx.core.content.res.TypedArrayUtils.getText;

import android.app.Activity;
import android.app.Dialog;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>
{
    private List<NewData> newList;
    private Activity context;
    private RoomDB database;


    public MainAdapter(Activity context, List<NewData> newList)
    {
        this.context = context;
        this.newList = newList;
        database = RoomDB.getInstance(context);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, int position) {

        final NewData data_n = newList.get(position);
        database = RoomDB.getInstance(context);
        View itemView = holder.itemView;
        TextView textView = itemView.findViewById(R.id.text_view);

        textView.setText(data_n.getText());
        ImageView profileImage = holder.profileImage;

        if (data_n.isImageSelected()) {
            profileImage.setImageResource(data_n.getImageResId());
        } else {
            // 기본 이미지(men_img)로 초기화
            profileImage.setImageResource(R.drawable.men_img);
        }

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("이미지 선택"); // 팝업의 제목 설정

                LinearLayout layout = new LinearLayout(v.getContext());
                layout.setOrientation(LinearLayout.HORIZONTAL);

                ImageView image1 = new ImageView(v.getContext());
                image1.setImageResource(R.drawable.men_img);
                layout.addView(image1);

                ImageView image2 = new ImageView(v.getContext());
                image2.setImageResource(R.drawable.women_img);
                layout.addView(image2);

                builder.setView(layout);

                // 확인 버튼 추가
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 이미지 선택 상태에 따라 이미지 리소스 ID 설정
                        if (data_n.isImageSelected()) {
                            profileImage.setImageResource(R.drawable.men_img);
                            data_n.setImageSelected(false);
                        } else {
                            profileImage.setImageResource(R.drawable.women_img);
                            data_n.setImageSelected(true);
                        }

                        // SharedPreferences를 사용하여 이미지 선택 상태 저장
                        SharedPreferences preferences = v.getContext().getSharedPreferences("image_preferences", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("is_image_selected_" + data_n.getId(), data_n.isImageSelected());
                        editor.apply();

                        dialog.dismiss(); // 다이얼로그 닫기
                    }
                });

                // 이미지를 클릭했을 때 선택 상태를 토글
                image1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        data_n.setImageSelected(false);
                        image1.setSelected(true);
                        image2.setSelected(false);

                        // 이미지 선택 상태를 SharedPreferences에 저장
                        saveImageSelectedState(data_n, false);
                    }
                });

                image2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        data_n.setImageSelected(true);
                        image1.setSelected(false);
                        image2.setSelected(true);

                        // 이미지 선택 상태를 SharedPreferences에 저장
                        saveImageSelectedState(data_n, true);
                    }
                });

                // 팝업 다이얼로그 보이기
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        // 초기 이미지 설정
        SharedPreferences preferences = holder.profileImage.getContext().getSharedPreferences("image_preferences", Context.MODE_PRIVATE);
        boolean isImageSelected = preferences.getBoolean("is_image_selected_" + data_n.getId(), false);
        data_n.setImageSelected(isImageSelected);



        holder.btEdit.setOnClickListener(new View.OnClickListener()                                 //수정할 때
        {
            @Override
            public void onClick(View v)
            {

                NewData newData = newList.get(holder.getAdapterPosition());
                final int sID = newData.getId();
                String sText = newData.getText();

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);

                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;

                dialog.getWindow().setLayout(width, height);

                dialog.show();

                final EditText editText = dialog.findViewById(R.id.dialog_edit_text);
                Button bt_update = dialog.findViewById(R.id.bt_update);

                editText.setText(sText);



                bt_update.setOnClickListener(new View.OnClickListener()                             //수정
                {
                    @Override
                    public void onClick(View v)
                    {
                        dialog.dismiss();
                        String uText = editText.getText().toString().trim();



                        database.newDao().update(sID, uText);
                        newList.clear();
                        newList.addAll(database.newDao().getAll());

                        notifyDataSetChanged();
                    }
                });
            }
        });

        /* 삭제 클릭 */
        holder.btDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                NewData newData = newList.get(holder.getAdapterPosition());

                database.newDao().delete(newData);
                String delete_text = newData.getText();

                database.mainDao().deleteName(delete_text);

                int position = holder.getAdapterPosition();
                newList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, newList.size());

            }
        });
    }

    @Override
    public int getItemCount()
{
    return newList.size();
}

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView btEdit, btDelete,  profileImage;
        Button start_btn;

        public ViewHolder(@NonNull View view)
        {
            super(view);

            btEdit = view.findViewById(R.id.bt_edit);
            btDelete = view.findViewById(R.id.bt_delete);
            profileImage = view.findViewById(R.id.profileImage);
            start_btn = view.findViewById(R.id.start_btn);

            start_btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    int selectedPosition = getAdapterPosition();
                    NewData selectedData = newList.get(selectedPosition);

                    String name;
                    name = selectedData.getText();
                    int id_value = database.mainDao().search_name(name);
                    String isTime = database.mainDao().search_is(id_value);

                    if(isTime != null)
                    {
                        MainData data = new MainData();
                        data.setText(name);
                        data.setTime(null);
                        data.setCredit(null);
                        data.setDetail(null);
                        data.setUserdate(null);
                        database.mainDao().insert(data);
                        Intent it = new Intent(v.getContext(), Kiosk_R_Part.class);
                        v.getContext().startActivity(it);
                    }

                    selectedData.setMD_id(id_value);
                    database.newDao().MD_id(id_value,name);

                    Intent it = new Intent(v.getContext(), Kiosk_R_Part.class);
                    v.getContext().startActivity(it);
                    }
            });
        }
    }
    private void saveImageSelectedState(NewData data, boolean isImageSelected) {
        SharedPreferences preferences = context.getSharedPreferences("image_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("is_image_selected_" + data.getId(), isImageSelected);
        editor.apply();
    }
}

