package pers.niaonao.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @Description :封装HTTP 请求，请求数据为JSON 格式
 * @Date: 2018/9/12 14:02
 */
public class TransObjectByHttp {

    public static void sendToWeb(String objectToJson, String interfaceUrl){
        try {
            System.out.println("TransObjectByHttp: 请求数据 - " + objectToJson);
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost(interfaceUrl);
            StringEntity postingString = null;// json传递
            postingString = new StringEntity(objectToJson);

            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json;charset=UTF-8");
            HttpResponse response = httpClient.execute(post);
            String content = EntityUtils.toString(response.getEntity());
            // Log.i("test",content);
            System.out.println("TransObjectByHttp: 返回数据 - " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}