package com.example.mvp.model;

import com.example.mvp.callBack.HttpCallBack;

//view页面的业务接口
public interface HttpInterfaceModel {

	void getHttp(String url, HttpCallBack callback);

}
