package com.soar.vote.common.util;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Map.Entry;

import com.soar.vote.common.util.BaseHttpSSLSocketFactory.TrustAnyHostnameVerifier;

public class HttpClient
{
    /**
     * 目标地址
     */
    private URL url;

    /**
     * 通信连接超时时间
     */
    private int connectionTimeout;

    /**
     * 通信读超时时间
     */
    private int readTimeOut;

    /**
     * 通信结果
     */
    private String result;

    /**
     * 通知结果
     */
    private InputStream inputStream;

    public InputStream getInputStream()
    {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream)
    {
        this.inputStream = inputStream;
    }

    /**
     * 获取通信结果
     * @return
     */
    public String getResult()
    {
        return result;
    }

    /**
     * 设置通信结果
     * @param result
     */
    public void setResult(String result)
    {
        this.result = result;
    }

    /**
     * 构造函数
     * @param url 目标地址
     * @param connectionTimeout HTTP连接超时时间
     * @param readTimeOut HTTP读写超时时间
     */
    public HttpClient(String url, int connectionTimeout, int readTimeOut) throws MalformedURLException {
        this.url = new URL(url);
        this.connectionTimeout = connectionTimeout;
        this.readTimeOut = readTimeOut;
    }

    /**
     * 发送信息到服务端
     * @param data
     * @param encoding
     * @return
     * @throws Exception
     */
    public int send(Map<String, String> data, String encoding) throws Exception
    {
        try
        {
            HttpURLConnection httpURLConnection = createConnection(encoding, "POST");
            if (null == httpURLConnection)
            {
                throw new Exception("创建联接失败");
            }
            this.requestServer(httpURLConnection, this.getRequestParamString(data, encoding), encoding);
            this.result = this.response(httpURLConnection, encoding);
            return httpURLConnection.getResponseCode();
        } catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * 发送信息到服务端
     * @param data
     * @param encoding
     * @return
     * @throws Exception
     */
    public int send(Map<String, String> data, String encoding, String reqType) throws Exception
    {
        try
        {
            HttpURLConnection httpURLConnection = createConnection(encoding, reqType);
            if (null == httpURLConnection)
            {
                throw new Exception("创建联接失败");
            }
            this.requestServer(httpURLConnection, this.getRequestParamString(data, encoding), encoding);
            this.inputStream = this.responseZip(httpURLConnection, encoding);
            return httpURLConnection.getResponseCode();
        } catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * 发送信息到服务端
     * @param data
     * @param encoding
     * @return
     * @throws Exception
     */
    public int send(String data, String encoding) throws Exception
    {
        try
        {
            HttpURLConnection httpURLConnection = createConnection(encoding, "POST");
            if (null == httpURLConnection)
            {
                throw new Exception("创建联接失败");
            }
            this.requestServer(httpURLConnection, data, encoding);
            this.result = this.response(httpURLConnection, encoding);
            return httpURLConnection.getResponseCode();
        } catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * HTTP Post发送消息
     *
     * @param connection
     * @param message
     * @throws IOException
     */
    private void requestServer(final URLConnection connection, String message, String encoder) throws Exception
    {
        PrintStream out = null;
        try
        {
            connection.connect();
            out = new PrintStream(connection.getOutputStream(), false, encoder);
            out.print(message);
            out.flush();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            if (null != out)
            {
                out.close();
            }
        }
    }

    /**
     * 显示Response消息
     *
     * @param connection
     * @param encoding
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    private String response(final HttpURLConnection connection, String encoding) throws URISyntaxException, IOException, Exception
    {
        InputStream in = null;
        StringBuilder sb = new StringBuilder(1024);
        BufferedReader br = null;
        String temp = null;
        try
        {
            in = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(in, encoding));
            while (null != (temp = br.readLine()))
            {
                sb.append(temp);
            }
            return sb.toString();
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            if (null != br)
            {
                br.close();
            }
            if (null != in)
            {
                in.close();
            }
            if (null != connection)
            {
                connection.disconnect();
            }
        }
    }

    /**
     * 显示Response消息
     *
     * @param connection
     * @param encoding
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    private InputStream responseZip(final HttpURLConnection connection, String encoding) throws URISyntaxException, IOException, Exception
    {
        InputStream in = null;
        try
        {
            in = connection.getInputStream();

            if (in != null)
            {

                return in;
            }
        } catch (Exception e)
        {
            throw e;
        } finally
        {

            if (null != in)
            {
                in.close();
            }
            if (null != connection)
            {
                connection.disconnect();
            }
        }
        return null;
    }

    /**
     * 创建连接
     *
     * @return
     * @throws ProtocolException
     */
    private HttpURLConnection createConnection(String encoding, String reqType) throws ProtocolException
    {
        HttpURLConnection httpURLConnection = null;
        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        httpURLConnection.setConnectTimeout(this.connectionTimeout);// 连接超时时间
        httpURLConnection.setReadTimeout(this.readTimeOut);// 读取结果超时时间
        httpURLConnection.setDoInput(true); // 可读
        httpURLConnection.setDoOutput(true); // 可写
        httpURLConnection.setUseCaches(false);// 取消缓存
        httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=" + encoding);
        httpURLConnection.setRequestMethod(reqType);
        if ("https".equalsIgnoreCase(url.getProtocol()))
        {
            HttpsURLConnection husn = (HttpsURLConnection) httpURLConnection;
            husn.setSSLSocketFactory(new BaseHttpSSLSocketFactory());
            husn.setHostnameVerifier(new TrustAnyHostnameVerifier());// 解决由于服务器证书问题导致HTTPS无法访问的情况
            return husn;
        }
        return httpURLConnection;
    }

    public HttpsURLConnection getHttpsURLConnection(String message, KeyManagerFactory kmf, TrustManager[] tm, Map<String, String> reqPro)
    {
        SSLContext sslContext = null;
        HttpsURLConnection urlc = null;
        try
        {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(kmf.getKeyManagers(), tm, null);
            SSLSocketFactory factory = sslContext.getSocketFactory();
            urlc = (HttpsURLConnection) url.openConnection();
            urlc.setSSLSocketFactory(factory);
            urlc.setDoOutput(true);
            urlc.setDoInput(true);
            urlc.setReadTimeout(this.readTimeOut);
            if (reqPro != null)
            {
                for (String key : reqPro.keySet())
                {
                    System.out.println("key= " + key + " and value= " + reqPro.get(key));
                    urlc.setRequestProperty(key, reqPro.get(key));
                }
            }
            OutputStream out = urlc.getOutputStream();
            out.write(message.getBytes());
            out.flush();
            out.close();
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return urlc;

    }

    /**
     * 发送信息到服务端
     * @param data
     * @param encoding
     * @return
     * @throws Exception
     */
    public int send(String data, String encoding, KeyManagerFactory kmf, TrustManager[] tm, Map<String, String> reqPro) throws Exception
    {
        try
        {
            HttpsURLConnection httpURLConnection = getHttpsURLConnection(data, kmf, tm, reqPro);
            if (null == httpURLConnection)
            {
                throw new Exception("创建联接失败");
            }
            // this.requestServer(httpURLConnection, data,encoding);
            this.result = this.response(httpURLConnection, encoding);
            return httpURLConnection.getResponseCode();
        } catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 发送信息到服务端
     * @param data
     * @param encoding
     * @return
     * @throws Exception
     */
    public int send(String data, String encoding, String reqType, Map<String, String> reqPro) throws Exception
    {
        try
        {
            HttpURLConnection httpURLConnection = createConnection(encoding, reqType, reqPro);
            if (null == httpURLConnection)
            {
                throw new Exception("创建联接失败");
            }
            this.requestServer(httpURLConnection, data, encoding);
            this.result = this.response(httpURLConnection, encoding);
            return httpURLConnection.getResponseCode();
        } catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * 创建连接
     *
     * @return
     * @throws ProtocolException
     */
    private HttpURLConnection createConnection(String encoding, String reqType, Map<String, String> reqPro) throws ProtocolException
    {
        HttpURLConnection httpURLConnection = null;
        try
        {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        httpURLConnection.setConnectTimeout(this.connectionTimeout);// 连接超时时间
        httpURLConnection.setReadTimeout(this.readTimeOut);// 读取结果超时时间
        httpURLConnection.setDoInput(true); // 可读
        httpURLConnection.setDoOutput(true); // 可写
        httpURLConnection.setUseCaches(false);// 取消缓存
        httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=" + encoding);
        httpURLConnection.setRequestMethod(reqType);
        /*
         * if(reqPro!=null){ for (String key : reqPro.keySet()) { System.out.println("key= "+ key + " and value= " + reqPro.get(key));
         * httpURLConnection.setRequestProperty(key, reqPro.get(key)); } }
         */
        if ("https".equalsIgnoreCase(url.getProtocol()))
        {
            HttpsURLConnection husn = (HttpsURLConnection) httpURLConnection;
            husn.setSSLSocketFactory(new BaseHttpSSLSocketFactory());
            husn.setHostnameVerifier(new TrustAnyHostnameVerifier());// 解决由于服务器证书问题导致HTTPS无法访问的情况
            return husn;
        }
        return httpURLConnection;
    }

    /**
     * 将Map存储的对象，转换为key=value&key=value的字符
     *
     * @param requestParam
     * @param coder
     * @return
     */
    private String getRequestParamString(Map<String, String> requestParam, String coder)
    {
        if (null == coder || "".equals(coder))
        {
            coder = "UTF-8";
        }
        StringBuffer sf = new StringBuffer("");
        String reqstr = "";
        if (null != requestParam && 0 != requestParam.size())
        {
            for (Entry<String, String> en : requestParam.entrySet())
            {
                try
                {
                    sf.append(
                            en.getKey() + "=" + (null == en.getValue() || "".equals(en.getValue()) ? "" : URLEncoder.encode(en.getValue(), coder))
                                    + "&");
                } catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                    return "";
                }
            }
            reqstr = sf.substring(0, sf.length() - 1);
        }
        return reqstr;
    }

    /**
     *
     * Description: ssl代理
     *
     * (C) Copyright of China UnionPay Co., Ltd. 2010.
     *
     * @author ZERO
     * @date 2012-8-15
     */
    // public class BaseHttpSSLSocketFactory extends SSLSocketFactory {
    // private SSLContext getSSLContext() {
    // return createEasySSLContext();
    // }
    // @Override
    // public Socket createSocket(InetAddress arg0, int arg1, InetAddress arg2, int arg3)
    // throws IOException {
    // return getSSLContext().getSocketFactory().createSocket(arg0, arg1, arg2, arg3);
    // }
    //
    // @Override
    // public Socket createSocket(String arg0, int arg1, InetAddress arg2, int arg3)
    // throws IOException, UnknownHostException {
    // return getSSLContext().getSocketFactory().createSocket(arg0, arg1, arg2, arg3);
    // }
    //
    // @Override
    // public Socket createSocket(InetAddress arg0, int arg1) throws IOException {
    // return getSSLContext().getSocketFactory().createSocket(arg0, arg1);
    // }
    //
    // @Override
    // public Socket createSocket(String arg0, int arg1) throws IOException, UnknownHostException {
    // return getSSLContext().getSocketFactory().createSocket(arg0, arg1);
    // }
    //
    // @Override
    // public String[] getSupportedCipherSuites() {
    // return null;
    // }
    //
    // @Override
    // public String[] getDefaultCipherSuites() {
    // return null;
    // }
    //
    // @Override
    // public Socket createSocket(Socket arg0, String arg1, int arg2, boolean arg3)
    // throws IOException {
    // return getSSLContext().getSocketFactory().createSocket(arg0, arg1, arg2, arg3);
    // }
    // private SSLContext createEasySSLContext() {
    // try {
    // SSLContext context = SSLContext.getInstance("SSL");
    // context.init(null, new TrustManager[]{new MyX509TrustManager().manger}, null);
    // return context;
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
    // }
    // public class MyX509TrustManager implements X509TrustManager {
    //
    // MyX509TrustManager manger = new MyX509TrustManager();
    // public MyX509TrustManager() {
    // }
    //
    // public X509Certificate[] getAcceptedIssuers() {
    // return null;
    // }
    //
    // public void checkClientTrusted(X509Certificate[] chain, String authType) {
    // }
    //
    // public void checkServerTrusted(X509Certificate[] chain, String authType) {
    // }
    // }
    // }
}
