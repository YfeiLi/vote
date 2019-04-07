package com.soar.vote.common.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LYF on 2019/4/7.
 */
public class HttpUtil {

    /**
     * 使用httpClient请求
     * @param url
     * @param reqData
     * @return
     */
    public static Map<String,Object> httpClientRequest(String url, Map<String,String> reqData){

        Map<String,Object> result = new HashMap<>();

        //创建连接
        HttpClient hc;
        try{
            hc = new HttpClient(url, 20000, 20000);
        }catch(MalformedURLException e){
            result.put("success",false);
            result.put("msg","URL协议、格式或者路径错误");
            return result;
        }

        // 发送请求
        int status;
        try{
            status = hc.send(reqData, "utf-8");
            result.put("status",status);
            if(status<200||status>=400){
                result.put("success",false);
                result.put("msg","网关响应失败");
                return result;
            }
        } catch(SocketTimeoutException e){
            result.put("status","503");
            result.put("success",false);
            result.put("msg","网关请求超时");
            return result;
        } catch(FileNotFoundException e){
            result.put("status","404");
            result.put("success",false);
            result.put("msg","抱歉! 您访问的资源不存在!");
            return result;
        } catch(UnknownHostException e){
            result.put("status","连接失败");
            result.put("success",false);
            result.put("msg","无法连接至 "+url.replaceAll("http://","").split("/")[0]+" 的服务器");
            return result;
        } catch(ConnectException e){
            result.put("status","连接失败");
            result.put("success",false);
            result.put("msg","无法建立到 "+url.replaceAll("http://","").split("/")[0]+" 服务器的链接");
            return result;
        } catch(Exception e){
            result.put("status","未知异常");
            result.put("success",false);
            result.put("msg",e.getClass().getName()+":"+e.getMessage());
            return result;
        }

        String resultString = hc.getResult();
        try{
            JSONObject json = JSONObject.parseObject(resultString);
            resultString = json.toString();
            result.put("success",true);
            result.put("msg","请求成功");
            result.put("data",resultString);
            return result;
        } catch(JSONException e){
            result.put("success",false);
            result.put("msg","返回值不为JSON字符串");
            return result;
        }

    }
}
