package org.itsk.datamaster.security;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itsk.datamaster.utils.Encrypt;

public class SecurityProcessor {
//	@Autowired
//	UserService userService;

	private static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	public boolean check(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, String> data = getHeadersInfo(request);
		String f = data.get("f");// 是否登录的标记,true/false.
		String d = data.get("d");// 日期.
		String signKeys = data.get("sk");// 签名用到的字段.
		String signValues = data.get("sg");// 签名值
		String token = data.get("token");

		try {
			OutputStreamWriter writer = new OutputStreamWriter(
					response.getOutputStream(), Charset.forName("UTF-8"));

			if (f == null  || d == null || signKeys == null
					|| signValues == null) {
				writer.write("{error:\"param invalid\"}");
				writer.flush();
				return false;
			}
			boolean flag = Boolean.valueOf(f);
			long date = Long.valueOf(d);

			// signKeys = new String(signKeys.getBytes("UTF-16"),"UTF-16");
			System.out.println(signKeys);
			// 验证时间与服务器时间的差值是否小于300000;
			long dt = System.currentTimeMillis() - date;
			if (dt >= 300000 || dt <= -300000) {
				writer.write("{error:\"time invalid\"}");
				writer.flush();
				return false;
			}
			if(signKeys!=null){
				char[] charKeys = signKeys.toCharArray();
				for(int i =0;i<charKeys.length;i++)
				{
					if(i%2==0)
					{
						charKeys[i]++;
					}else
					{
						charKeys[i]--;
					}
				}
				signKeys=String.valueOf(charKeys);
			}
			StringBuffer buffer = new StringBuffer();
			String[] keysStrings = signKeys.split(";");
			if(keysStrings!=null)
				for (String key : keysStrings) {
					if(request.getParameter(key)!=null)
						buffer.append(request.getParameter(key)).append("e");
				}
			buffer.append(flag).append(token);

			buffer.append(signKeys).append(date);
			// 计算签名.
			String sg = Encrypt.MD5(buffer.toString());
			if (signValues.equalsIgnoreCase(sg)) {
				return true;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
