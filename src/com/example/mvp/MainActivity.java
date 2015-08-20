package com.example.mvp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.presenter.HttpPresenter;
import com.example.mvp.view.HttpInterfaceView;

public class MainActivity extends Activity implements HttpInterfaceView {
	private TextView tv_content;
	private Button btn_mvp;
	private HttpPresenter presenter = new HttpPresenter(this);
	private ProgressDialog progressDialog;

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				String content = (String) msg.obj;
				tv_content.setText(content);
				break;
			case 2:
				String info = (String) msg.obj;
				tv_content.setText(info);
				//Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById();

		btn_mvp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				presenter.getData("http://www.baidu.com");
			}
		});
	}

	private void findViewById() {
		// TODO Auto-generated method stub
		tv_content = (TextView) findViewById(R.id.tv_content);
		btn_mvp = (Button) findViewById(R.id.btn_mvp);
	}

	@Override
	public void showProDialog() {
		// TODO Auto-generated method stub
		if (null == progressDialog) {
			progressDialog = new ProgressDialog(this);
			progressDialog.setMessage("mvp正在加载网络数据...");
			progressDialog.setCancelable(true);
			progressDialog.show();
		}
	}

	@Override
	public void hideProDialog() {
		// TODO Auto-generated method stub
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
		}
	}

	@Override
	public void showResult(String info) {
		// TODO Auto-generated method stub
		Message msg = handler.obtainMessage();
		msg.what = 1;
		msg.obj = info;
		handler.sendMessage(msg);
	}

	@Override
	public void ToastInfo(String info) {
		// TODO Auto-generated method stub
		Message msg = handler.obtainMessage();
		msg.what = 2;
		msg.obj = info;
		handler.sendMessage(msg);
	}

}
