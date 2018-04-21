package com.MyUtilities.EbayUtils;

import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import org.apache.http.HttpHost;


import java.io.IOException;
import java.security.*;
import java.util.LinkedList;


/**
 * Created by moshe on 20/05/2017.
 */
public class HttpRequestUtil {

    private  HttpRequestFactory requestFactory;
    private  GenericUrl webSiteAddress;
    private HttpRequest request;
    private HttpHeaders requestHeaders;
    public HttpRequestUtil(GenericUrl siteAddress){
        webSiteAddress = siteAddress;
        try {
            setApacheHttpTransport();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public HttpRequestUtil(GenericUrl siteAddress, HttpHost host){
        webSiteAddress = siteAddress;
        try {
            setApacheHttpTransport(host);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }



    private void setApacheHttpTransport(HttpHost proxy) throws GeneralSecurityException {
        requestFactory = new ApacheHttpTransport.Builder().setProxy(proxy).build().createRequestFactory();
    }

    private void setApacheHttpTransport() throws GeneralSecurityException {
        requestFactory = new ApacheHttpTransport.Builder().build().createRequestFactory();
    }

    public void setRequestHeaders(HttpHeaders requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public HttpResponse DoSendHttpPostRequestAndRecvResponse(UrlEncodedContent encodedContent){
        try {

            request = requestFactory.buildPostRequest(webSiteAddress,encodedContent).setHeaders(requestHeaders);
            return request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public HttpResponse DoSendHttpGetRequestAndRecvResponse(LinkedList<String[]> queryString) throws IOException {
        if (queryString != null){
            for (String[] query : queryString){
                webSiteAddress.set(query[0],query[1]);
            }
        }

            request = requestFactory.buildGetRequest(webSiteAddress).setHeaders(requestHeaders);
            return request.execute();

    }
}
