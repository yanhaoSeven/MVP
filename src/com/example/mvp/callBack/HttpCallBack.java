package com.example.mvp.callBack;

//数据请求的回调
public interface HttpCallBack {
	
	void onSuccess(String info);// 成功

	void onFail(int tag, String errorInfo);// 失败.1,标记是哪个网络的标示。2,显示错误msg
}
