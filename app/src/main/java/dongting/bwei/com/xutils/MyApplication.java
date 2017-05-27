package dongting.bwei.com.xutils;

import android.app.Application;
import android.os.Environment;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * 作者:${董婷}
 * 日期:2017/5/8
 * 描述:
 */

public class MyApplication extends Application {
    DbManager.DaoConfig daoConfig ;

    @Override
    public void onCreate() {
        super.onCreate();


        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        initDB();


    }



    public void initDB(){
        daoConfig = new DbManager.DaoConfig()
                .setDbName("abc.db")    //设置数据库名称
                .setDbVersion(1)  //数据库版本
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
// TODO: ...
                        //  数据库版本号发生了变化  走这个回调

                    }
                });
    }
}
