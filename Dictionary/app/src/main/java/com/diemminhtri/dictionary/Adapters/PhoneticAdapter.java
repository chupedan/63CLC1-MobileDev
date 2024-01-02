package com.diemminhtri.dictionary.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diemminhtri.dictionary.Modules.Phonetics;
import com.diemminhtri.dictionary.R;
import com.diemminhtri.dictionary.ViewHolders.PhoneticViewHolder;

import java.util.List;

public class PhoneticAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Phương thức này tạo mới một PhoneticViewHolder khi RecyclerView cần hiển thị một item view mới.
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, @SuppressLint("RecyclerView") int i) {
        // Phương thức này được gọi khi RecyclerView muốn hiển thị dữ liệu của một item tại vị trí cụ thể.

        holder.tv_phonetic.setText(phoneticsList.get(i).getText());

        // Xử lý sự kiện lắng nghe cho nút phát âm
        holder.imgBtn_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi nút âm thanh được nhấn, tạo một đối tượng MediaPlayer để phát âm thanh từ đường dẫn trong danh sách.
                MediaPlayer player = new MediaPlayer();
                try {
                    player.setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            // Xác định âm thanh sẽ được sử dụng cho nội dung đa phương tiện như âm nhạc hoặc video.
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            // Xác định nội dung là âm nhạc.
                            .build());
                    player.setDataSource(phoneticsList.get(i).getAudio());
                    // Đặt nguồn dữ liệu âm thanh cho đối tượng MediaPlayer. phoneticsList.get(i).getAudio()
                    // là đường dẫn của file âm thanh được lấy từ danh sách phoneticsList tại vị trí i
                    player.prepare();
                    player.start();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Couldn't play audio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // Phương thức này trả về số lượng total items trong danh sách.
        return phoneticsList.size();
    }

}
