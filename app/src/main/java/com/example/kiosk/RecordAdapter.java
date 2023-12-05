package com.example.kiosk;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private Context context;
    private List<MainData> recordList;

    public RecordAdapter(Context context, List<MainData> recordList) {
        this.context = context;
        this.recordList = recordList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView timeTextView;
        TextView detailTextView;
        TextView creditTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.date);
            timeTextView = itemView.findViewById(R.id.time);
            detailTextView = itemView.findViewById(R.id.detail);
            creditTextView = itemView.findViewById(R.id.credit);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_user_rec, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainData data = recordList.get(position);
        holder.dateTextView.setText(data.getUserdate());
        holder.timeTextView.setText(data.getTime());
        holder.detailTextView.setText(data.getDetail());
        holder.creditTextView.setText(data.getCredit());
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public void updateData(List<MainData> newData) {
        recordList.clear();
        recordList.addAll(newData);
        notifyDataSetChanged();
    }

    private boolean isValidData(MainData data) {
        return !TextUtils.isEmpty(data.getUserdate()) &&
                !TextUtils.isEmpty(data.getDetail()) &&
                !TextUtils.isEmpty(data.getCredit()) &&
                !TextUtils.isEmpty(data.getTime());
    }

    private long convertDateToMillis(String userDate) {
        // 예시로 현재는 0L을 반환하도록 설정되어 있습니다.
        return 0L;
    }

    private long parseTimeToMillis(String timeString) {
        if (timeString == null || timeString.isEmpty()) {
            return 0; // 빈 문자열이나 null일 경우 0으로 반환
        }

        String[] timeParts = timeString.split("분"); // "00분00초"를 "00"과 "00초"로 분리
        int minutes = Integer.parseInt(timeParts[0]); // 분을 정수형으로 파싱

        // "00초"에서 "초"를 제거하고 정수로 파싱
        int seconds = Integer.parseInt(timeParts[1].replace("초", "").trim());

        // 밀리초로 변환하고 더해줌
        return (minutes * 60 + seconds) * 1000L;
    }

    public List<Entry> getChartData() {
        List<Entry> chartData = new ArrayList<>();

        for (int i = 0; i < recordList.size(); i++) {
            MainData data = recordList.get(i);
            if (data != null && isValidData(data)) {
                long millis = convertDateToMillis(data.getUserdate());
                float time1 = (parseTimeToMillis(data.getTime()))/1000;
                float time2 = (parseTimeToMillis(data.getDetail()))/1000;
                float time3 = (parseTimeToMillis(data.getCredit()))/1000;

                chartData.add(new Entry(millis, time1));
                chartData.add(new Entry(millis, time2));
                chartData.add(new Entry(millis, time3));
            }
        }

        return chartData;
    }
}