package com.e.pulselvetest.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.e.pulselvetest.R;
import com.e.pulselvetest.adapter.CustomAdapter;
import com.e.pulselvetest.model.Item;
import com.e.pulselvetest.presenter.DataPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataView.dataView {
    DataPresenter countryPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CustomAdapter customAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("loading....");
         countryPresenter = new DataPresenter(this);

        // Maybe it's best to call it on onResume()
        //countryPresenter.getCountries();
    }


    @Override
    public void dataReady(List<Item> itemList) {

        // See your Logcat :)

        customAdapter = new CustomAdapter(getApplicationContext(), itemList);
        recyclerView.setAdapter(customAdapter);
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
        // Maybe it's best to call it on onResume()
        countryPresenter.getData();
    }
}
