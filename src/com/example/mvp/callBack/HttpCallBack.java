package com.example.mvp.callBack;

//��������Ļص�
public interface HttpCallBack {
	
	void onSuccess(String info);// �ɹ�

	void onFail(int tag, String errorInfo);// ʧ��.1,������ĸ�����ı�ʾ��2,��ʾ����msg
}
