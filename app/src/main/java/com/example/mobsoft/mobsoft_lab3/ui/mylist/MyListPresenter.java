package com.example.mobsoft.mobsoft_lab3.ui.mylist;

import android.util.Log;

import com.example.mobsoft.mobsoft_lab3.R;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.GetMyAdvertsInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.events.GetAdvertsEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.events.RemoveMyAdvertEvent;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.model.FetchAdvertRequest;
import com.example.mobsoft.mobsoft_lab3.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft_lab3.MobSoftApplication.injector;

/**
 * Created by Android on 2017. 03. 24..
 */

public class MyListPresenter extends Presenter<MyListScreen> {

    @Inject
    GetMyAdvertsInteractor getMyAdvertsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MyListPresenter() {
    }

    @Override
    public void attachScreen(MyListScreen screen) {

        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {

        bus.unregister(this);
        super.detachScreen();
    }

    public void getMyAdverts() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                FetchAdvertRequest fetchAdvertRequest = new FetchAdvertRequest();
                fetchAdvertRequest.setUserId(1992);
                getMyAdvertsInteractor.fetchAdverts(fetchAdvertRequest);
            }
        });
    }

    public void showAllAdverts() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                getMyAdvertsInteractor.fetchAdverts(new FetchAdvertRequest());
            }
        });
    }

    public void deleteAdvert(final int advertId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                getMyAdvertsInteractor.deleteAdvert(advertId);
            }
        });
    }


    public void onEventMainThread(GetAdvertsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading advertsRecycler", event.getThrowable());
        } else {
            if (screen != null) {
                screen.displayAdverts(event.getAdverts());
            }
        }
    }

    public void onEventMainThread(RemoveMyAdvertEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading advertsRecycler", event.getThrowable());
        } else {
            if (screen != null) {
                if (event.isDeletionSuccessfull()) {
                    screen.showMessage(R.string.my_list_advert_successfully_deleted);
                    screen.advertDeleted();
                } else {
                    screen.showMessage(R.string.my_list_advert_deletion_failed);
                }
            }
        }
    }

}
