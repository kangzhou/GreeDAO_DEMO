package com.greedao.greedao_demo.base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.greedao.greedao_demo.greendao.DaoMaster;
import com.greedao.greedao_demo.greendao.DaoSession;

/**
 * Created by ZhouKang
 */
public class MyApplication extends Application {
    private static MyApplication sInstance = null;
    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        init();
        initGreenDao();
    }

    private void init(){

    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "greedao_test.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static MyApplication getsInstance() {
        if (sInstance == null) {
            throw new NullPointerException("MyApplication INSTANCE is Empty");
        }
        return sInstance;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
