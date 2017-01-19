package common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	// //post请求
	public static String httpPost(String url, Map<String, String> map) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;

		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> m : map.entrySet()) {
			NameValuePair nameValuePair = new BasicNameValuePair(m.getKey(), m.getValue());
			list.add(nameValuePair);
		}

		HttpEntity postEntity = null;
		String result = null;
		try {
			postEntity = new UrlEncodedFormEntity(list);
			httpPost.setEntity(postEntity);
			response = httpClient.execute(httpPost);

			HttpEntity responseEntity = response.getEntity();
			result = EntityUtils.toString(responseEntity, "UTF-8");
			// BufferedInputStream bin = new
			// BufferedInputStream(responseEntity.getContent());
			// byte[] b = new byte[2048];
			// bin.read(b);
			// result = EncodingUtils.getString(b, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	// get请求
	public static String httpGet(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);

		CloseableHttpResponse response = null;
		HttpEntity responseEntity = null;
		String result = null;
		try {
			response = httpClient.execute(httpGet);
			responseEntity = response.getEntity();
			result = EntityUtils.toString(responseEntity, "UTF-8");

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	//  post提交，参数为不同类型
	public static String postObject(String url, List<File> listFile, Map<String, String> map) throws FileNotFoundException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		
		MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
		entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		for (File f : listFile) {
			String name = f.getName().substring(f.getName().indexOf("."), f.getName().length());
			entityBuilder.addBinaryBody(name, f);

		}
		for (Map.Entry<String, String> e : map.entrySet()) {
			StringBody stringBody = new StringBody(e.getValue(), ContentType.create("text/plain", "UTF-8"));
			entityBuilder.addPart(e.getKey(), stringBody);
		}
		HttpEntity postEntity = entityBuilder.build();
		httpPost.setEntity(postEntity);
		CloseableHttpResponse response = null;
		HttpEntity responseEntity = null;
		String result = null;
		try {
			response = httpClient.execute(httpPost);
			responseEntity = response.getEntity();
			result = EntityUtils.toString(responseEntity);
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return result;
	}

}
