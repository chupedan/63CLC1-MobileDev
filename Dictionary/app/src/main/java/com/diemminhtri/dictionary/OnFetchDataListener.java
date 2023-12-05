package com.diemminhtri.dictionary;

import com.diemminhtri.dictionary.Modules.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);

}
