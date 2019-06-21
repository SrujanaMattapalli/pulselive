package com.e.pulselvetest.presenter;



import com.e.pulselvetest.model.Data;
import com.e.pulselvetest.model.Item;
import com.e.pulselvetest.service.DataService;
import com.e.pulselvetest.view.DataView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class DataPresenter {

    private DataView.dataView dataView;
    private DataService dataService;

    public DataPresenter(DataView.dataView view) {
        this.dataView = view;

        if (this.dataService == null) {
            this.dataService = new DataService();
        }
    }


    public void getData() {
        dataView.showProgress();
        dataService
                .getAPI()
                .getResults()
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        dataView.hideProgress();
                        Data data = response.body();
                        if (data != null && data.getItems() != null) {
                            List<Item> result = data.getItems();
                            dataView.dataReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        dataView.hideProgress();
                    }
                });
    }

}
