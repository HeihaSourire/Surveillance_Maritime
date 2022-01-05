package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpRequest {
	
	//here are the connexion protocols
	
	public static String postHttp(String body, String url) throws WrongStatusCodeException {
		String res = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		try {
			StringEntity entity = new StringEntity(body);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			CloseableHttpResponse response2 = httpclient.execute(httpPost);
			if(response2.getStatusLine().getStatusCode() != 200)
				throw new WrongStatusCodeException();
			HttpEntity entity2 = response2.getEntity();
			res = EntityUtils.toString(entity2);
			EntityUtils.consume(entity2);
			response2.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return res;
	}
	
	public static String getHttp(String url) throws WrongStatusCodeException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		String result = "";
		try {
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			if(response1.getStatusLine().getStatusCode() != 200)
				throw new WrongStatusCodeException();
			HttpEntity entity = response1.getEntity();
			result = EntityUtils.toString(entity);
			EntityUtils.consume(entity);
		}catch(IOException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static InputStream getPhoto(String url) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			HttpEntity entity = response1.getEntity();
			return entity.getContent();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
}
