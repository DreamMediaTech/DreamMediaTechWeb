package com.dream.test.folder;

import com.dream.util.Contants;
import com.dream.util.ConverVideoUtils;

public class ConverVideoTest {  
    public void run() {  
        try {  
            // 转换并截图  
            String filePath = "C:\\Users\\wx_shadow\\Desktop\\streams\\guardians2.mp4";  
            ConverVideoUtils cv = new ConverVideoUtils(filePath);  
            String targetExtension = ".mp4";  
            boolean isDelSourseFile = true;  
            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile,Contants.type_ud_code);  
            System.out.println(beginConver);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    public static void main(String args[]) {  
        ConverVideoTest c = new ConverVideoTest();  
        c.run();  
    }  
}  