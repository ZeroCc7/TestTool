package someTest;

import util.MD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCo {


    public static void main(String[] args) throws Exception {
        File file = new File("D:\\");
        List<File> fileList = checkFile(file);
        for(File file1 : fileList){
           if (file1.getName() .contains("the")){
               System.out.println(file1.getName());
           }
        }
    }
    public static List<File> checkFile(File file)  {
        List<File> fileList = new ArrayList<>();
        boolean isAlive = file.exists();
        if(isAlive){
            if(file.getName().contains("the")){
                System.out.println(file.getName());
            }
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File file1 : files){
                    fileList.addAll(checkFile(file1));
                }
            }else{
                fileList.add(file);
            }
        }
        return fileList;
    }





    public static String getMD5ByFile(String fileName) throws Exception {
        File file = new File(fileName);
        InputStream is = new FileInputStream(file);
        byte[] bytes = new byte[is.available()];
        String md5File = MD5.getMD5(bytes);
//        System.out.println(md5File);
        return md5File;
    }




}
