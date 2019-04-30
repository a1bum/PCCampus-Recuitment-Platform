package top.a1bum.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;

public class TCaptchaVerify {
    private static final String APP_ID = "2037253362";
    private static final String APP_SECRET = "00eVx6jaxdLgN8q7pwbkNRw**";
    private static final String VERIFY_URI = "https://ssl.captcha.qq.com/ticket/verify?aid=%s&AppSecretKey=%s&Ticket=%s&Randstr=%s&UserIP=%s";

    public static int verifyTicket(String ticket, String rand, String userIp) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet;
        CloseableHttpResponse response = null;
        try {
            httpGet = new HttpGet(String.format(VERIFY_URI,
                    APP_ID,
                    APP_SECRET,
                    URLEncoder.encode(ticket, "UTF-8"),
                    URLEncoder.encode(rand, "UTF-8"),
                    URLEncoder.encode(userIp, "UTF-8")
            ));
            response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String res = EntityUtils.toString(entity);
                JSONObject result = JSON.parseObject(res);
                // ������
                int code = result.getInteger("response");
                // ����ȼ�
                int evilLevel = result.getInteger("evil_level");
                // ��֤�ɹ�
                return code;
            }
        } catch (java.io.IOException e) {
            // ����
        } finally {
            try {
                response.close();
            } catch (Exception ignore) {
            }
        }

        return -1;
    }
}
