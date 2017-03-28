# LoggerTest
参考简书 [Android 如何优雅的打印日志](http://www.jianshu.com/p/89b05c0ffd39)

原文： [Simple, pretty and powerful logger for android](https://github.com/orhanobut/logger)

![Logger](https://github.com/orhanobut/logger/raw/master/images/logger-logo.png)


有些手机不显示debug信息可以这样

需要打开华为手机的相关Log开关，具体步骤如下：

1. 进入拨号界面输入：
    ```*#*#2846579#*#*```
2. 依次选择ProjectMenu---后台设置----LOG设置---LOG开关 点击打开, 然后在LOG级别选VERBOSE
3. 重新启动手机


```
compile 'com.orhanobut:logger:1.15'

```

```java
package com.lexinsmart.xushun.loggertest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangle on 2016/12/26.
 */
public class MainActivity extends AppCompatActivity {

    private Button btnLog;
    private String JSON_CONTENT;
    private String XML_CONTENT;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private String[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLog = (Button) findViewById(R.id.btn_log);

        initData();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                log();
            }
        });

    }

    private void initData() {
        JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
                "\"temp\":\"-2\",\"WD\":\"西北风\",\"WS\":\"3级\",\"SD\":\"241%\",\"WSE\":\"3\"," +
                "\"time\":\"10:61\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"}}";

        XML_CONTENT = "<resp><city>北京</city><updatetime>16:10</updatetime><wendu>23</wendu>" +
                "<fengli>3级</fengli><shidu>19%</shidu><fengxiang>北风</fengxiang></resp>";

        list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        map = new HashMap<>();
        map.put("H", "Hello");
        map.put("W", "World");

        set = new HashSet<>();
        set.add("Hello");
        set.add("World");

        array = new String[]{"Hello", "World"};
    }

    private void log() {
        // 普通日志
        Logger.v("Hello World!");
        Logger.d("Hello World!");
        Logger.i("Hello World!");
        Logger.w("Hello World!");
        Logger.e("Hello World!");

        // what a terrible failure
        // 可怕的失败，报告一个永远不可能发生的情况
        Logger.wtf("Hello World!");

        // 打印JSON
        Logger.json(JSON_CONTENT);

        // 打印XML
        Logger.xml(XML_CONTENT);

        // 打印集合
        Logger.d(list);
        Logger.d(map);
        Logger.d(set);

        // 打印数组
        Logger.d(array);

        // 格式化字符串
        Logger.d("Hello %s%s", "World", "!");

        //自定义单个Tag
        Logger.t("MyTag").d("Hello World!");

        try {
            //int a = 6 / 0;
        } catch (Exception e) {
            Logger.e(e, "Exception");
        }
    }
}


```





