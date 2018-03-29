package util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

import org.apache.log4j.Logger;

public class HttpClient {
	private static Logger log = Logger.getLogger(HttpClient.class);

	public static String postHttpRequest(String url, String postData)
			throws IOException {
		String sessionId = UUID.randomUUID().toString().replace("-", "");

		URL myurl = new URL(url);
		URLConnection urlc = myurl.openConnection();
		urlc.setReadTimeout(1000 * 300);
		urlc.setDoOutput(true);
		urlc.setDoInput(true);
		urlc.setAllowUserInteraction(false);
		urlc.setRequestProperty("Accept", "application/json;charset=UTF-8");
		urlc.setRequestProperty("Content-Type","application/json;charset=UTF-8");
		DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
		
		log.info("SessionID:"+sessionId+", 发送数据=" + postData);

		server.write(postData.getBytes("utf-8"));
		server.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				urlc.getInputStream(), "utf-8"));
		String resXml = "", s = "";
		while ((s = in.readLine()) != null)
			resXml = resXml + s;
		in.close();
		log.info("SessionID:"+sessionId+", 接收数据=" + resXml);
		return resXml;
	}
	
	public static String postHttpXmlRequest(String url, String postData,
			String charset) throws IOException {
		String sessionId = UUID.randomUUID().toString().replace("-", "");
		URL myurl = new URL(url);
		URLConnection urlc = myurl.openConnection();
		urlc.setReadTimeout(1000 * 300);
		urlc.setDoOutput(true);
		urlc.setDoInput(true);
		urlc.setAllowUserInteraction(false);
		urlc.setRequestProperty("Content-Type",	"application/xml; charset="+charset);
        urlc.setReadTimeout(1000 * 30);

		DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
		log.info("SessionID:"+sessionId+",发送数据=" + postData);

		server.write(postData.getBytes(charset));
		server.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				urlc.getInputStream(), charset));
		String resXml = "", s = "";
		while ((s = in.readLine()) != null)
			resXml = resXml + s;
		in.close();
		log.info("SessionID:"+sessionId+",接收数据=" + resXml);
		return resXml;
	}

	public static String getHttpRequest(String url, String params)
			throws Exception {
		String sessionId = UUID.randomUUID().toString().replace("-", "");
		log.info("SessionID:"+sessionId+",发送数据=" + params);
		URL myurl = new URL(url + "?" + params);
		URLConnection urlc = myurl.openConnection();
		urlc.setReadTimeout(1000 * 300);
		urlc.setDoOutput(true);
		urlc.setDoInput(true);
		urlc.setAllowUserInteraction(false);
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlc;
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		if (httpURLConnection.getResponseCode() >= 300) {
			throw new Exception(
					"HTTP Request is not success, Response code is "
							+ httpURLConnection.getResponseCode());
		}

		try {
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}

		String resXml = resultBuffer.toString();
		log.info("SessionID:"+sessionId+",接收数据=" + resXml);
		return resXml;
	}
	
	public static String getHttpRequest(String url, String params,
			String reqCharset, String respCharset) throws Exception {
		String sessionId = UUID.randomUUID().toString().replace("-", "");
		log.info("SessionID:"+sessionId+",发送数据=" + params);
		URL myurl = new URL(url + "?" + params);
		URLConnection urlc = myurl.openConnection();
		urlc.setReadTimeout(1000 * 300);
		urlc.setDoOutput(true);
		urlc.setDoInput(true);
		urlc.setAllowUserInteraction(false);
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlc;
		httpURLConnection.setRequestProperty("Accept-Charset", reqCharset);
		httpURLConnection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		if (httpURLConnection.getResponseCode() >= 300) {
			throw new Exception(
					"HTTP Request is not success, Response code is "
							+ httpURLConnection.getResponseCode());
		}

		try {
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, respCharset);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}

		String resXml = resultBuffer.toString();
		log.info("SessionID:"+sessionId+",接收数据=" + resXml);
		return resXml;
	}
}
