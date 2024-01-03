package com.diemminhtri.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.diemminhtri.dictionary.Modules.APIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class RequestManager {
    Context context;

    // Tạo đối tượng Retrofit để gửi và nhận dữ liệu từ API
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            //Thiết lập địa chỉ cơ sở cho API. Tất cả các endpoint sẽ được nối thêm vào địa chỉ cơ sở này để tạo địa chỉ hoàn chỉnh.
            .addConverterFactory(GsonConverterFactory.create())
            // "GsonConverterFactory.create()" được sử dụng để chuyển đổi JSON thành các đối tượng Java bằng thư viện Gson.
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    // Đây là phương thức chính để gửi yêu cầu API và nhận phản hồi.
    public void getWordMeaning(OnFetchDataListener listener, String word) {
        // Tạo đối tượng gọi đến API thông qua Retrofit
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);

        // Tạo cuộc gọi để lấy nghĩa của từ
        Call<List<APIResponse>> call = callDictionary.callMeanings(word);

        try {
            // Thực hiện cuộc gọi bất đồng bộ
            call.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                    // Xử lý phản hồi từ server khi thành công
                    if (!response.isSuccessful()) {
                        // Hiển thị thông báo lỗi nếu có lỗi
                        Toast.makeText(context, "Error!!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Gọi sự kiện onFetchData để thông báo về việc nhận dữ liệu mới
                    listener.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<APIResponse>> call, Throwable t) {
                    // Xử lý khi có lỗi trong quá trình gửi hoặc nhận dữ liệu
                    listener.onError("Request Failed!!");
                }
            });
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có lỗi
            e.printStackTrace();
            Toast.makeText(context, "An Error Occurred!!", Toast.LENGTH_SHORT).show();
        }
    }

    // Định nghĩa interface để gọi các phương thức từ API
    public interface CallDictionary {
        @GET("entries/en/{word}")
        // Định nghĩa endpoint của API, có dạng "entries/en/{word}" với {word} là tham số có thể thay đổi.
        Call<List<APIResponse>> callMeanings(
                @Path("word") String word
        );
    }

}
