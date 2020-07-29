package com.voucher.manage2.service.impl;

import cn.hutool.core.util.IdUtil;
import com.voucher.manage2.constant.SystemConstant;
import com.voucher.manage2.utils.WordTemplateUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReplaceKeywordsServiceImpl implements com.voucher.manage2.service.ReplaceKeywordsService {
    @Override
    public String printWord(Map<String, Object> jsonMap,int x) throws IOException {
        Map<String, Object> wordDataMap = new HashMap<>();// 存储全部数据

        wordDataMap.put("parametersMap", jsonMap);
        String START_WORD_FILENAME = x + SystemConstant.START_WORD_FILENAME;
        String startWord = SystemConstant.START_WORD_PATH + File.separator + START_WORD_FILENAME;

        File file = new File(startWord);//本地文件所在目录

        // 读取word模板
        FileInputStream fileInputStream = new FileInputStream(file);
        WordTemplateUtils template = new WordTemplateUtils(fileInputStream);

        // 替换数据
        template.replaceDocument(wordDataMap);

        // 生成文件
        String wordPath = SystemConstant.SAVE_CAHCE_FILE_PATH + File.separator + IdUtil.simpleUUID();
        wordPath = wordPath + SystemConstant.WORD_SUFFIX;
        File file1 = new File(wordPath);
        //OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(file1),"GB2312");
        FileOutputStream fos = new FileOutputStream(file1);

        template.getDocument().write(fos);
        return wordPath;
    }
}
