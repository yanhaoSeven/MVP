package com.example.mvp.view;

//view��Ӧҳ��ӿ�(��Ҫ�Ǻ���ͼ�й�ϵ)
public interface HttpInterfaceView {

	void showProDialog();//��ʾ���ؿ�

	void hideProDialog();//���ؼ��ؿ�
	
	void showResult(String info);//���ݻ�ȡ��Ҫ��ʾ�ڽ���
	
	void ToastInfo(String info);//��Ҫ��������ʾ
}
