package opendata.helper;

import opendata.constant.Constant;
import opendata.constant.excel.SampleConstant;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebHelper {
    public static List<String> getUrls(List<String> listPage, String selector){
        List<String> list = new ArrayList<>();
        Document doc = null;
        String page = "";
        for (int i = 0; i < listPage.size(); i++){
            page = listPage.get(i);
            try{
                doc = Jsoup.connect(page).userAgent(Constant.USER_AGENT).get();
            }catch (IOException e){
                e.printStackTrace();
            }
            if (doc.equals(null)){
                try {
                    doc = Jsoup.parse(readFromWeb(page));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (doc.equals(null)){
                return  null;
            }
            Elements urls = doc.body().select(selector);
            for (Element element : urls){
                String fileElement = element.attr("href");
                list.add(fileElement);
            }
        }

        return list;
    }

    public static String readFromWeb(String webURL) throws IOException{
        String html = "";
        URL url = new URL(webURL);
        InputStream is = url.openStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

        }catch (MalformedURLException e){
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!!");
        }catch (IOException e){
            e.printStackTrace();
            throw new IOException();
        }
        return html;
    }

    public static String addUrl(){
        String url = SampleConstant.PAGE;

        return url;
    }
}
