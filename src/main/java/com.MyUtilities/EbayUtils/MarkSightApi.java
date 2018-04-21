package com.MyUtilities.EbayUtils;

import com.google.api.client.http.*;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by moshe on 20/05/2017.
 */
public class MarkSightApi {

    private final GenericUrl webSiteAddress = new GenericUrl("https://marksight.com/queryKeywordSearch.php");
    private final HttpHost proxy = new HttpHost("181.211.2.146",8090,"https");
    private String searchKeyword;
    private EbayCategoryType ebayCategoryType;
    private HttpRequestUtil requestUtil = new HttpRequestUtil(webSiteAddress);
    private LinkedList<String[]> listOfParameters = new LinkedList<>();
    private Gson gson = new Gson();
    private HttpHeaders httpHeaders = getHttpHeaders();

    public MarkSightApi(String searchKeyword, EbayCategoryType ebayCategoryType) {
        this.searchKeyword = searchKeyword;
        this.ebayCategoryType = ebayCategoryType;
    }

    public MarkSightApi(String searchKeyword) {
        this.searchKeyword = searchKeyword;
        ebayCategoryType = EbayCategoryType.ALL_CATEGORIES;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;

    }

    public void setEbayCategoryType(EbayCategoryType ebayCategoryType) {
        this.ebayCategoryType = ebayCategoryType;
    }

    public  UrlEncodedContent getUrlEncodedFromSearch() throws IOException {
        HashMap keyValues = new HashMap<String, String>();
        keyValues.put("query", searchKeyword);
        keyValues.put("include", "");
        keyValues.put("exclude", "");
        keyValues.put("category",ebayCategoryType.getCategoryNumber());
        return new UrlEncodedContent(keyValues);
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }


    public MarkSightResponse searchMarkSight () throws IOException {
        return searchMarkSight(0);
    }
    public MarkSightResponse searchMarkSight(int minPrice) throws IOException {
        requestUtil.setRequestHeaders(httpHeaders);
        addQueryParametersToRequest(minPrice);
        HttpResponse response = requestUtil.DoSendHttpGetRequestAndRecvResponse(listOfParameters);
        String json = getStringFromInputStream(response.getContent()).trim();
        return gson.fromJson(json,MarkSightResponse.class);
    }


    public GraphedDataPerCategory searchMarkSightSpecific() throws IOException{
        return searchMarkSightSpecific(0);
    }

    public GraphedDataPerCategory searchMarkSightSpecific(int minPrice) throws IOException {
        requestUtil.setRequestHeaders(httpHeaders);
        addQueryParametersToRequest(minPrice);
        HttpResponse response = requestUtil.DoSendHttpGetRequestAndRecvResponse(listOfParameters);
        String json = getStringFromInputStream(response.getContent()).trim();
        //System.out.println(json);
        return gson.fromJson(json,GraphedDataPerCategory.class);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Requested-With","XMLHttpRequest");
        httpHeaders.set("Origin","https://marksight.com");
        httpHeaders.set("Accept-Language","en-US,en;q=0.8,he;q=0.6");
        return httpHeaders;
    }

    private void addQueryParametersToRequest(int minPrice) {
        listOfParameters.add(new String[]{"query",searchKeyword});
        listOfParameters.add(new String[]{"include",""});
        listOfParameters.add(new String[]{"exclude",""});
        listOfParameters.add(new String[]{"category", String.valueOf(ebayCategoryType.getCategoryNumber())});
        if (minPrice>0){
            listOfParameters.add(new String[]{"isMean","true"});
            listOfParameters.add(new String[]{"minPrice",String.valueOf(minPrice)});
        }
    }


}
