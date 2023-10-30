package com.example.kiosk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {

    private Context context;
    private List<String> userNames;
    private RecordAdapter secondAdapter; // 두 번째 리사이클러뷰 어댑터
    private MainDao mainDao;

    public NameAdapter(Context context, List<String> userNames, RecordAdapter secondAdapter) {
        this.context = context;
        this.userNames = userNames;
        this.secondAdapter = secondAdapter; // 두 번째 리사이클러뷰 어댑터 할당
        this.mainDao = RoomDB.getInstance(context).mainDao(); // MainDao 초기화
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button user_btn;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            user_btn = itemView.findViewById(R.id.user_btn);

            user_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = textView.getText().toString();
                    List<MainData> matchingDates = mainDao.getMatchingItems(text);
                    secondAdapter.updateData(matchingDates);
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_user_name, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String userName = userNames.get(position);
        holder.textView.setText(userName);
    }

    @Override
    public int getItemCount() {
        return userNames.size();
    }
}
