package opendata;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;

import java.util.List;

public class Main {
    public static void main(String[] args){
        String page = "https://www.contextures.com/xlSampleData01.html#data";
        String homepage = "https://www.contextures.com/";
        String databaseTable;
        String fileFolder;
        String selector;

        MongoClientURI uri = new MongoClientURI("mongodb+srv://popolocrise:pantat123@cluster0-275ew.mongodb.net/test?retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoCursor<String> dbCursor = mongoClient.listDatabaseNames().iterator();

        while (dbCursor.hasNext()){
            System.out.println(dbCursor.next());
        }


    }

}
