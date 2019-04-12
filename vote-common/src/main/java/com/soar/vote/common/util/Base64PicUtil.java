package com.soar.vote.common.util;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * <strong>base64图片工具类</strong>
 * date: 3/4/2019
 *
 * @author liyifei
 * @version 1.0
 **/
public class Base64PicUtil {

    /**
     * 保存base64图片
     * @param base64Str base64照片
     * @param path 路径
     */
    public static Map<String,Short> saveBase64Picture(String base64Str, String path) throws IOException {

        byte[] bytes;
        bytes = DatatypeConverter.parseBase64Binary(base64Str);
        File file = new File(path);
        File dir = new File(file.getParent());
        if(!dir.exists()){
            dir.mkdirs();
        }
        Boolean flag = file.createNewFile();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        out.write(bytes);
        out.close();
        BufferedImage image = ImageIO.read(file);
        Short width = (short)image.getWidth();
        Short height = (short)image.getHeight();
        Map<String,Short> result = new HashMap<>(2);
        result.put("width",width);
        result.put("height",height);
        return result;
    }

    /**
     * 获取base64字符串
     * @param path 图片路径
     * @return base64字符串
     */
    public static String getBase64Picture(String path){

        //获取照片二进制数组
        byte[] bytes;
        File file = new File(path);
        if(!file.exists()){
            return null;
        }
        try{
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            bytes = new byte[in.available()];
            int n = in.read(bytes);
            in.close();
        }catch(IOException e){
            return null;
        }

        //base64编码
        return DatatypeConverter.printBase64Binary(bytes);
    }

    public static Map<String,Short> getWidthAndHeight(String base64){

        return null;
    }
}