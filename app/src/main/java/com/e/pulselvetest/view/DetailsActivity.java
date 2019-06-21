package com.e.pulselvetest.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.e.pulselvetest.R;
import com.e.pulselvetest.model.Item;
import com.e.pulselvetest.presenter.DataPresenter;
import com.e.pulselvetest.presenter.DetailsPresenter;

public class DetailsActivity extends AppCompatActivity implements DataView.detailsView {
    DetailsPresenter detailsPresenter;
    String id="";
    TextView tvTitle,tvSubTitle,tvDate;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        detailsPresenter = new DetailsPresenter(this);
        progressDialog = new ProgressDialog(DetailsActivity.this);
        progressDialog.setTitle("loading....");
        if (getIntent()!=null){
            id = getIntent().getStringExtra("_id");
        }
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvSubTitle = (TextView)findViewById(R.id.tvSubTitle);
        tvDate = (TextView)findViewById(R.id.tvDate);
    }

    @Override
    public void detailsView(Item item) {
        tvTitle.setText(item.getTitle());
        tvSubTitle.setText(item.getSubtitle());
        tvDate.setText(item.getDate());
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
    progressDialog.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        detailsPresenter.getSelfData(id);
    }
}
