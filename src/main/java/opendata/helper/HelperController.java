package opendata.helper;

import opendata.constant.Constant;
import opendata.entity.DBConnection;
import opendata.entity.Page;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.net.URLDecoder;
import java.util.List;

public class HelperController {
    public static DBConnection getConnectionInofr(int connType){
        DBConnection conn = new DBConnection();
        conn.setHost(Constant.HOST);
        conn.setPort(Constant.PORT);
        conn.setDbName(Constant.DBNAME);
        conn.setDbUser(Constant.DBUSER);
        conn.setDbPwd(Constant.DBPWD);
        return conn;
    }

    public static boolean downloadFromWeb(Page page, String dirName)throws Exception{
        String saveFolder = dirName + page.fileFolder;
        List<String> urls = WebHelper.getUrls(page.listPage, page.selector);
        for (String url : urls){
            HttpUriRequest urlNext = new HttpGet(url);
            HttpClients.custom().setUserAgent(Constant.USER_AGENT);
            CloseableHttpClient client = HttpClientBuilder.create().build();
            client.execute(new HttpGet(url));

            HttpResponse response = client.execute(urlNext);
            HttpEntity entity = response.getEntity();

            String filename = response.getFirstHeader("Content-Disposition").getValue();
            String name = URLDecoder.decode(filename.substring(filename.indexOf("''")+32), "UTF-8");
            
        }

        return true;
    }
}
