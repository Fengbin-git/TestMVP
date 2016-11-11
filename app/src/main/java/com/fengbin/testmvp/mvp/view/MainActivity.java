package com.fengbin.testmvp.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fengbin.testmvp.R;
import com.fengbin.testmvp.bean.User;
import com.fengbin.testmvp.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements BaseView, View.OnClickListener {
    private TextView tv;
    private EditText ed_text;
    private Button search_btn;
    private MainPresenter mainPresenter;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
    }

    private void initView() {
        tv = (TextView)findViewById(R.id.tv);
        ed_text = (EditText)findViewById(R.id.ed_text);
        search_btn = (Button)findViewById(R.id.search_btn);
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("搜索中...");
        search_btn.setOnClickListener(this);
    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void showText(User userbean) {
        String str = userbean.toString();
        tv.setText(str);
    }

    @Override
    public void showErrorMessage(int textId) {
        String text = getString(textId);
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.search_btn:
                mainPresenter.searchUser(ed_text.getText().toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mainPresenter != null) {
            mainPresenter.detachView();
        }
    }
}
