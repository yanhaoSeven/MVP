package com.example.mvp.model;

import java.io.IOException;

import com.example.mvp.callBack.HttpCallBack;
import com.example.mvp.util.OkHttpUtil;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

//viewҳ��ӿ�ʵ��
public class HttpModelImpl implements HttpInterfaceModel {

	@Override
	public void getHttp(String url, final HttpCallBack callback) {
		// TODO Auto-generated method stub
		Request request = new Request.Builder().url(url).build();
		OkHttpUtil.enqueue(request, new Callback() {

			@Override
			public void onResponse(Response arg0) throws IOException {
				// TODO Auto-generated method stub
				if (arg0.code() == 200) {
					String info = arg0.body().string();
					callback.onSuccess(info);
				} else {
					callback.onFail(OkHttpUtil.ERROR_HTTP_POST, "����code��Ϊ200");
				}
			}

			@Override
			public void onFailure(Request arg0, IOException arg1) {
				// TODO Auto-generated method stub
				callback.onFail(OkHttpUtil.ERROR_HTTP_EXCEPTION, "�����쳣" + arg1.getMessage());
			}
		});
	}

}
