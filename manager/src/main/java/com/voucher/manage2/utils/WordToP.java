package com.voucher.manage2.utils;
import java.io.*;
import cn.hutool.core.util.IdUtil;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.voucher.manage2.constant.SystemConstant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WordToP {
    /**
     * 将word文档， 转换成pdf, 中间替换掉变量
     * inPath : word地址
     * pdfFile : pdf地址
     * @throws Exception
     */
    public static String doc2pdf(String inPath) throws IOException{
        String pdfFileName = IdUtil.simpleUUID() + SystemConstant.PDF_SUFFIX;
        String pdfFile = SystemConstant.SAVE_CAHCE_FILE_PATH + File.separator + pdfFileName;

        ActiveXComponent app = null;
        Dispatch doc = null;
        try {
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", new Variant(false));
            Dispatch docs = (Dispatch) app.getProperty("Documents").toDispatch();

            //转换前的文件路径
            String startFile = inPath;
            //转换后的文件路径
            String overFile =  pdfFile;

            doc = Dispatch.call(docs,  "Open" , startFile).toDispatch();
            File tofile = new File(overFile);
            if (tofile.exists()) {
                tofile.delete();
            }
            //        private static final int wdFormatPDF = 17;// PDF 格式
//            Dispatch.call(doc,"SaveAs", overFile, 17);
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
                    tofile, new Variant(17) }, new int[1]);
        } catch (Exception e) {

            e.printStackTrace();
//            log.error(e.getMessage());
        } finally {
            Dispatch.call(doc,"Close",false);
            if (app != null)
                app.invoke("Quit", new Variant[] {});
        }
        //结束后关闭进程
        ComThread.Release();


        return pdfFileName;
    }

}
