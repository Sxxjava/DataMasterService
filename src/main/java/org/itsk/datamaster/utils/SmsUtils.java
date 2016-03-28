package org.itsk.datamaster.utils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SmsUtils {
	/**
	 * 发起https 请求
	 * @param address
	 * @param m
	 * @return
	 */
	public  static String validateCode(String mobile ,String code){
			String address="https://webapi.sms.mob.com/sms/verify";
			String params="appkey=fc791ccf3651&amp;phone="+mobile+"&amp;zone=86&amp;&amp;code="+code;
			HttpURLConnection conn = null;
			try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
			    public X509Certificate[] getAcceptedIssuers(){return null;}
			    public void checkClientTrusted(X509Certificate[] certs, String authType){}
			    public void checkServerTrusted(X509Certificate[] certs, String authType){}
			}};

			// Install the all-trusting trust manager
		    SSLContext sc = SSLContext.getInstance("TLS");
		    sc.init(null, trustAllCerts, new SecureRandom());

		    //ip host verify
		    HostnameVerifier hv = new HostnameVerifier() {
		         public boolean verify(String urlHostName, SSLSession session) {
		         return urlHostName.equals(session.getPeerHost());
		         }
		    };

		    //set ip host verify
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			URL url = new URL(address);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");// POST
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			// set params ;post params 
			if (params!=null) {
				conn.setDoOutput(true);
				DataOutputStream out = new DataOutputStream(conn.getOutputStream());
				out.write(params.getBytes(Charset.forName("UTF-8")));
				out.flush();
				out.close();
			}
			conn.connect();
			//get result 
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String result = parsRtn(conn.getInputStream());
				return result;
			} else {
				System.out.println(conn.getResponseCode() + " "+ conn.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.disconnect();
		}
		return null;
	}

	private static String parsRtn(InputStream inputStream) throws IOException {
		char[] buf=new char[1024];
		StringBuffer buffer=new StringBuffer();
		int len=-1;
		InputStreamReader reader=new InputStreamReader(inputStream);
		while((len=reader.read(buf))!=-1){
			buffer.append(buf,0,len);
		}
		return buffer.toString();
	}
}
