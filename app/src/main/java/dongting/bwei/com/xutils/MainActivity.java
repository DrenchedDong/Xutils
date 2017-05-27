package dongting.bwei.com.xutils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {

   /* @ViewInject(R.id.btn_get)
    Button btn;*/
    @ViewInject(R.id.image)
    ImageView image;
    private DbManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        x.view().inject(this);

        MyApplication a=(MyApplication) getApplication();
     db = x.getDb(a.daoConfig);
    }

    @Event(value ={R.id.btn_get,R.id.btn_post,R.id.btn_load,R.id.btn_download,R.id.btn_save})
private void click(View v){
switch (v.getId()){
    case  R.id.btn_get:
get();
        break;
    case  R.id.btn_post:
        post();

        break;
    case  R.id.btn_load:
        load();
        break;
    case  R.id.btn_download:
        download();
        break;
    case  R.id.btn_save:
        save();
        break;
}
}

    private void save() {
        try {
            Student stu=new Student();
            stu.setId(1);
            stu.setName("张三");
            stu.setAge(12);

            db.save(stu);
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    private void download() {

    }

    private void load() {
x.image().bind(image,"http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg");

    }

    private void post() {

        RequestParams re =new RequestParams("http://qhb.2dyt.com/Bwei/login");
        re.addBodyParameter("postkey","bwei");
        re.addBodyParameter("username","aa");
        re.addBodyParameter("password","111");

        x.http().post(re, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void get() {
        RequestParams re =new RequestParams("http://qhb.2dyt.com/Bwei/login");
        re.addQueryStringParameter("postkey","bwei");
        re.addQueryStringParameter("username","aa");
        re.addQueryStringParameter("password","111");

        x.http().get(re, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
