package com.example.mvp.view;

//view对应页面接口(主要是和视图有关系)
public interface HttpInterfaceView {

	void showProDialog();//显示加载框

	void hideProDialog();//隐藏加载框
	
	void showResult(String info);//数据获取后要显示在界面
	
	void ToastInfo(String info);//主要是用于提示
}
