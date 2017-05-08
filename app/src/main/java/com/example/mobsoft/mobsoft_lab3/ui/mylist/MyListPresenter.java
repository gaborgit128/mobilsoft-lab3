package com.example.mobsoft.mobsoft_lab3.ui.mylist;

import android.util.Log;

import com.example.mobsoft.mobsoft_lab3.interactor.main.MainInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.GetMyAdvertsInteractor;
import com.example.mobsoft.mobsoft_lab3.interactor.mylist.events.GetMyAdvertsEvent;
import com.example.mobsoft.mobsoft_lab3.model.Advert;
import com.example.mobsoft.mobsoft_lab3.ui.Presenter;
import com.example.mobsoft.mobsoft_lab3.ui.main.MainScreen;

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

    public void onEvent(String s) {
    }

    public void getAdverts() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                getMyAdvertsInteractor.getMyAdverts();;
            }
        });
    }


    public void onEventMainThread(GetMyAdvertsEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading adverts", event.getThrowable());
        } else {
            if (screen != null) {
                for(Advert t : event.getAdverts()){
                    screen.showMessage(t.getTitle());
                }
            }
        }
    }

}
