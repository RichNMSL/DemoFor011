package com.run;

import com.util.DocUtil;
import com.util.ZipUtil;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class working {

    public static void main(String[] args) {
        try {
            String zipPath = "C:\\Users\\Berry\\Desktop\\wait";
            String targetPath = "C:\\Users\\Berry\\Desktop\\backup";

            File file = new File(zipPath);
            File[] tempList = file.listFiles();

//            for (int i = 0; i < tempList.length; i++) {
//                if (tempList[i].isFile()) {
//                    //文件名，不包含路径
//                    String fileName = tempList[i].getName();
//                    ZipUtil.unZip(zipPath + "\\" + fileName, targetPath);
//                }
//
//            }
//            System.out.println("解析zip包结素惹");

            //DocUtil.readWord("C:\\Users\\Berry\\Desktop\\backup\\20200616164423200616BYFC72B3F8\\陈建源危险驾驶一审刑事判决书.doc");
//                     String a="C:\\Users\\Berry\\Desktop\\backup\\20200616164423200616BYFC72B3F8\\陈建源危险驾驶一审刑事判决书.doc";
         // DocUtil.readWord("C:\\Users\\Berry\\Desktop\\backup\\20200616164423200616BYFC72B3F8\\12.doc");

            //copyFile("C:\\Users\\Berry\\Desktop\\15.doc","C:\\Users\\Berry\\Desktop\\18.txt");

            readAndWriterTest3("C:\\Users\\Berry\\Desktop\\15.doc");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void copyFile(String strOldpath,String strNewPath)
    {
        try {
            File fOldFile = new File(strOldpath);
            if (fOldFile.exists())
            {
                int bytesum = 0;
                int byteread = 0;
                InputStreamReader isr = new InputStreamReader(new FileInputStream(strOldpath), "GBK"); //ANSI编码
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(strNewPath), "UTF-8"); //存为UTF-8


                int len = isr.read();
                while(-1 != len)
                {

                    osw.write(len);
                    len = isr.read();
                }
                //刷新缓冲区的数据，强制写入目标文件
                osw.flush();
                osw.close();
                isr.close();

            }
        }catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("复制单个文件出错");
            e.printStackTrace();
        }
    }



    public static void readAndWriterTest3(String filepath) throws IOException {
        File file = new File(filepath);
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            String doc1 = doc.getDocumentText();
            System.out.println(doc1);
            StringBuilder doc2 = doc.getText();
            System.out.println(doc2);
            Range rang = doc.getRange();
            String doc3 = rang.text();
            System.out.println(doc3);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
