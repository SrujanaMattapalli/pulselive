package com.e.pulselvetest.view;


import com.e.pulselvetest.model.Item;

import java.util.List;




public interface DataView {
    interface dataView {
        void dataReady(List<Item> data);
        void showProgress();
        void hideProgress();
    }
    interface detailsView{
        void detailsView(Item item);
        void showProgress();
        void hideProgress();
    }

}
