package com.ubtechinc.alpha.mini.sdk.demo;

import com.ubtechinc.alpha.mini.sdk.AlphaMiniApplication;
import com.ubtechinc.alpha.mini.sdk.AlphaMiniSdk;
import com.ubtechinc.alpha.mini.sdk.entity.AlphaMiniParam;

public class DemoApplication extends AlphaMiniApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AlphaMiniSdk.instance().init(this,
                AlphaMiniParam.newBuilder()
                .AppId("7nuVS4Hj")
                .AppKey("1ba2648dd4615916c1c7a4079186d524fa5a4ac5")
                .build());
    }
}
