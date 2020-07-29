package com.voucher.manage2.service.impl;

import com.voucher.manage2.constant.SystemConstant;
import com.voucher.manage2.service.WordToPdfService;
//import com.voucher.manage2.utils.WordToP;
import com.voucher.manage2.utils.WordToP;
import com.voucher.manage2.utils.WordToPDF;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class WordToPdfServiceImpl implements WordToPdfService {
    @Override
    public String convert(String wordFile) {

        String pdfFileName = null;
        try {
//            pdfFileName = WordToP.doc2pdf(wordFile);
            pdfFileName = WordToPDF.wordToPDF(wordFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SystemConstant.re() + File.separator + pdfFileName;
    }
}
