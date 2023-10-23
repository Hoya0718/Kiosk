package com.example.kiosk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>
{
    private List<MainData> dataList;
    private Activity context;
    private RoomDB database;
    private MainDao mainDataDao;
    public MainAdapter(Activity context, List<MainData> dataList)
    {
        this.context = context;
        this.dataList = dataList;
        database = RoomDB.getInstance(context);
        mainDataDao = database.mainDao();
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
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, int position)
    {


        final MainData data = dataList.get(position);
        database = RoomDB.getInstance(context);
        View itemView = holder.itemView;
        TextView user_list_date = itemView.findViewById(R.id.user_list_date);
        TextView textView = itemView.findViewById(R.id.text_view);
        TextView text_time = itemView.findViewById(R.id.text_time);
        TextView credit_time = itemView.findViewById(R.id.credit_time);
        TextView detail_time = itemView.findViewById(R.id.detail_time);

        textView.setText(data.getText());
        text_time.setText(data.getTime());
        credit_time.setText(data.getCredit());
        detail_time.setText(data.getDetail());
        user_list_date.setText(data.getUserdate());

        holder.btEdit.setOnClickListener(new View.OnClickListener()                                 //수정할 때
        {
            @Override
            public void onClick(View v)
            {
                MainData mainData = dataList.get(holder.getAdapterPosition());

                final int sID = mainData.getId();
                String sText = mainData.getText();

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

                        database.mainDao().update(sID, uText);

                        dataList.clear();
                        dataList.addAll(database.mainDao().getAll());
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
                MainData mainData = dataList.get(holder.getAdapterPosition());

                database.mainDao().delete(mainData);

                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataList.size());
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
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

                    //MainData data = new MainData();

                    int selectedPosition = getAdapterPosition();
                    MainData selectedData = dataList.get(selectedPosition);
                    int x =  selectedData.getId();

                    //MainData data = mainDataDao.getMainDataById(14);
                    copyAndAddData(x);
                    Intent it = new Intent(v.getContext(), Kiosk_R_Part.class);
                    v.getContext().startActivity(it);
                }
            });

            profileImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("이미지 선택"); // 팝업의 제목 설정


                    LinearLayout layout = new LinearLayout(v.getContext());
                    layout.setOrientation(LinearLayout.HORIZONTAL);

                    ImageView image1 = new ImageView(v.getContext());
                    image1.setImageResource(R.drawable.grandpa);
                    layout.addView(image1);

                    ImageView image2 = new ImageView(v.getContext());
                    image2.setImageResource(R.drawable.grandma);
                    layout.addView(image2);

                    ImageView image3 = new ImageView(v.getContext());
                    image3.setImageResource(R.drawable.edit_img);
                    layout.addView(image3);

                    builder.setView(layout);

                    // 확인 버튼 추가
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (image1.isSelected()) {
                                profileImage.setImageResource(R.drawable.grandpa);
                            } else if (image2.isSelected()) {
                                profileImage.setImageResource(R.drawable.grandma);
                            } else if (image3.isSelected()) {
                                profileImage.setImageResource(R.drawable.edit_img);
                            }
                            dialog.dismiss(); // 다이얼로그 닫기
                        }
                    });

                    // 이미지를 클릭했을 때 선택 상태를 토글
                    image1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            image1.setSelected(!image1.isSelected());
                        }
                    });

                    image2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            image2.setSelected(!image2.isSelected());
                        }
                    });

                    image3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            image3.setSelected(!image3.isSelected());
                        }
                    });

                    // 팝업 다이얼로그 보이기
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
//                    // 취소 버튼 추가
//                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            // 취소 버튼을 클릭했을 때 수행할 동작
//                            dialog.dismiss(); // 다이얼로그 닫기
//                        }
//                    });
//
//                    // 팝업 다이얼로그 보이기
//                    builder.show();
//                }
//            });
        }
    }
    public void copyAndAddData(int originalId) {
        MainData originalData = mainDataDao.getMainDataById(originalId);
        if (originalData != null) {
            MainData newData = new MainData();
            newData.setText(originalData.getText());
            newData.setTime(originalData.getTime());
            newData.setDetail(originalData.getDetail());
            newData.setCredit(originalData.getCredit());
            newData.setUserdate(originalData.getUserdate());
            newData.setId(0); // 또는 다른 ID 할당
            long newRowId = mainDataDao.insert(newData);
            if (newRowId != -1) {
                // 새로운 행 추가 성공
                Log.d("tjdrhd","tjdrhd");
                dataList.clear();
                dataList.addAll(mainDataDao.getAll());
                notifyDataSetChanged();
            } else {
                Log.d("tlfvo","실패");
            }
        }
    }
}

