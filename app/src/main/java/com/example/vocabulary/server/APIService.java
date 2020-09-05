package com.example.vocabulary.server;

public class APIService {

    private static String base_url = "https://tpmusic.000webhostapp.com/AppVocabulary/Server/";
    public static DataService getService(){
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
