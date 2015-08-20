package com.example.mvp.presenter;

import com.example.mvp.callBack.HttpCallBack;
import com.example.mvp.model.HttpInterfaceModel;
import com.example.mvp.model.HttpModelImpl;
import com.example.mvp.view.HttpInterfaceView;

//view和activity之间的业务处理
public class HttpPresenter {
	private HttpInterfaceModel model;
	private HttpInterfaceView view;

	public HttpPresenter(HttpInterfaceView view) {
		this.model = new HttpModelImpl();
		this.view = view;
	}

	public void getData(String url) {
		view.showProDialog();
		model.getHttp(url, new HttpCallBack() {

			@Override
			public void onSuccess(String info) {
				// TODO Auto-generated method stub
				view.hideProDialog();
				view.showResult(info);
			}

			@Override
			public void onFail(int tag, String errorInfo) {
				// TODO Auto-generated method stub
				view.hideProDialog();
				view.ToastInfo(errorInfo);
			}
		});
	}

}
