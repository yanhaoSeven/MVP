package com.example.mvp.model;

import com.example.mvp.callBack.HttpCallBack;

//viewҳ���ҵ��ӿ�
public interface HttpInterfaceModel {

	void getHttp(String url, HttpCallBack callback);

}
