package com.voucher.manage2.utils;

import cn.hutool.core.util.IdUtil;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.voucher.manage2.constant.SystemConstant;
import lombok.extern.slf4j.Slf4j;

import java.io.File;


@Slf4j
public class WordToPDF {

    static final int wdFormatPDF = 17;// PDF 格式

    public static String wordToPDF(String sfileName) {

        String pdfFileName = IdUtil.simpleUUID() + SystemConstant.PDF_SUFFIX;
        String pdfFile = SystemConstant.SAVE_CAHCE_FILE_PATH + File.separator + pdfFileName;

        System.out.println("启动Word...");
        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        Dispatch doc = null;
        try {
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", new Variant(false));
            Dispatch docs = app.getProperty("Documents").toDispatch();
            // doc = Dispatch.call(docs, "Open" , sourceFile).toDispatch();
            doc = Dispatch.invoke(
                    docs,
                    "Open",
                    Dispatch.Method,
                    new Object[]{sfileName, new Variant(false),
                            new Variant(true)}, new int[1]).toDispatch();
            System.out.println("打开文档..." + sfileName);
            System.out.println("转换文档到PDF..." + pdfFile);
            File tofile = new File(pdfFile);
            if (tofile.exists()) {
                tofile.delete();
            }
            // Dispatch.call(doc, "SaveAs", destFile, 17);
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[]{
                    pdfFile, new Variant(17)}, new int[1]);
            long end = System.currentTimeMillis();
            System.out.println("转换完成..用时" + (end - start) + "ms.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:文档转换失败" + e.getMessage());
        } finally {
            Dispatch.call(doc, "Close", false);
            System.out.println("关闭文档");
            if (app != null)
                app.invoke("Quit", new Variant[]{});
        }
        ComThread.Release();
        return pdfFileName;
    }

}

