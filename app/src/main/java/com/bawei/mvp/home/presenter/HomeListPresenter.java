package com.bawei.mvp.home.presenter;

import android.util.Log;

import com.bawei.mvp.MainActivity;
import com.bawei.mvp.api.Api;
import com.bawei.mvp.home.model.HomeListModeInter;



public class HomeListPresenter implements IHomeListPresenter,HomeListModeInter.ModuleInterface {

    private final HomeListModeInter homeListModeInter;
    MainActivity  mview;
    private String modeInterDate;

    //构造器
    public HomeListPresenter(MainActivity mainActivity) {
        this.mview=mainActivity;
        //初始化Model层
        homeListModeInter = new HomeListModeInter(this);
    }

    @Override
    public void getModelDate() {
        //回调model
        homeListModeInter.getDate(Api.SHOPLIST);
        Log.i("", "getModelDate: "+ modeInterDate);
    }
    @Override
    public void LoadSuccess(String data) {
        mview.getViewData(data);
    }

    @Override
    public void LoadFailed() {
        mview.getViewData("加载失败");
    }
}
