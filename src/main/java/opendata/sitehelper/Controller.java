package opendata.sitehelper;

import opendata.constant.excel.SampleConstant;
import opendata.entity.Page;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static Page getConstant(String fileFolder, String databaseTable, String selector, String homepage){
        Page page = new Page();
        page.fileFolder = fileFolder;
        page.databaseTable = databaseTable;
        page.selector = selector;
        page.homepage = homepage;
        page.listPage = getListPageConstant();

        return page;
    }

    public static List<String> getListPageConstant(){
        List<String> list = new ArrayList<>();
        list.add(SampleConstant.PAGE);

        return list;
    }

    public static Page getPageInfo(){
        Page page = new Page();
        page = (Page) getConstant(SampleConstant.FILE_FOLDER, SampleConstant.DATABASE_TABLE, SampleConstant.SELECTOR, SampleConstant.HOMEPAGE);

        return page;
    }

    public static String getEncoding(){
        String encoding = SampleConstant.ENCODING;

        return encoding;
    }

    public static boolean getContent(String line){
    }
}
