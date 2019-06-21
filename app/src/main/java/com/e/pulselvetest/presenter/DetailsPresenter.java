package com.e.pulselvetest.presenter;



import android.util.Log;

import com.e.pulselvetest.model.Data;
import com.e.pulselvetest.model.Details;
import com.e.pulselvetest.model.Item;
import com.e.pulselvetest.service.DataService;
import com.e.pulselvetest.view.DataView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailsPresenter {

    private DataView.detailsView detailsView;
    private DataService dataService;

    public DetailsPresenter(DataView.detailsView view) {
        this.detailsView = view;

        if (this.dataService == null) {
            this.dataService = new DataService();
        }
    }


    public void getSelfData(String id) {
        detailsView.showProgress();
        Log.e("error",id);
        dataService
                .getAPI()
                .getSelfData(id)
                .enqueue(new Callback<Details>() {
                    @Override
                    public void onResponse(Call<Details> call, Response<Details> response) {
                        detailsView.hideProgress();
                        Details details = response.body();
                        if (details != null ) {
                            detailsView.detailsView(details.getItem());
                        }
                    }

                    @Override
                    public void onFailure(Call<Details> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        detailsView.hideProgress();
                        Log.e("error",t.toString());
                    }
                });
    }
}
