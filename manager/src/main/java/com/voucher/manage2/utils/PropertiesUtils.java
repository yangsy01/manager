package com.voucher.manage2.utils;

import com.voucher.manage2.controller.VersionController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static String returnValue(String value){
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = VersionController.class.getClassLoader().getResourceAsStream("version.properties");
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取key对应的value值
        String key = properties.getProperty(value);

        return key;
    }
}
