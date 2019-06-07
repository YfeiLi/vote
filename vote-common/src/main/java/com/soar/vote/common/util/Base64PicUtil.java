package com.soar.vote.common.util;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class Base64PicUtil {

    /**
     * 保存base64图片
     * @param base64Str base64照片
     * @param path 路径
     */
    public static Map<String,Short> saveBase64Picture(String base64Str, String path) {

        byte[] bytes;
        bytes = DatatypeConverter.parseBase64Binary(base64Str);
        File file = new File(path);
        File dir = new File(file.getParent());
        if(!dir.exists()){
            boolean flag = dir.mkdirs();
        }
        BufferedImage image;
        BufferedOutputStream out = null;
        try {
            Boolean flag = file.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(file));
            out.write(bytes);
            image = ImageIO.read(file);
        } catch (IOException e) {
            log.error("写入图片异常",e);
            return null;
        } finally{
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭输出流异常",e);
                }
            }
        }
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
        BufferedInputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream(file));
            bytes = new byte[in.available()];
            int n = in.read(bytes);
        }catch(IOException e){
            log.error("获取图片异常",e);
            return null;
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("关闭输入流异常",e);
                }
            }
        }

        //base64编码
        return DatatypeConverter.printBase64Binary(bytes);
    }

    public static Map<String,Short> getWidthAndHeight(String base64){

        return null;
    }
}