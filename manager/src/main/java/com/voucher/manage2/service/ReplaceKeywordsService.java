package com.voucher.manage2.service;


import java.io.IOException;
import java.util.Map;

public interface ReplaceKeywordsService {

    /**
     * 对docx文件中的文本及表格中的内容进行替换
     */
    public String printWord(Map<String, Object> jsonMap,int x) throws IOException;
    //public void printWord() throws IOException;

}
