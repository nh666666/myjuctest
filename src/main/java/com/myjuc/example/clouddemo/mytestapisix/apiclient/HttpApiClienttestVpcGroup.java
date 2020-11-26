//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.myjuc.example.clouddemo.mytestapisix.apiclient;
import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;


public class HttpApiClienttestVpcGroup extends ApacheHttpClient{
    public final static String HOST = "e47ecd766cda4dd3b2e21997a94563d2-cn-hangzhou.alicloudapi.com";
    static HttpApiClienttestVpcGroup instance = new HttpApiClienttestVpcGroup();
    public static HttpApiClienttestVpcGroup getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }




    public void testAppKeyApi(String prefix , String fileName , String userId , ApiCallback callback) {
        String path = "/web/cloudapi";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("prefix" , prefix , ParamPosition.QUERY , false);
        request.addParam("fileName" , fileName , ParamPosition.QUERY , false);
        request.addParam("userId" , userId , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse testAppKeyApiSyncMode(String prefix , String fileName , String userId) {
        String path = "/web/cloudapi";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("prefix" , prefix , ParamPosition.QUERY , false);
        request.addParam("fileName" , fileName , ParamPosition.QUERY , false);
        request.addParam("userId" , userId , ParamPosition.QUERY , false);



        return sendSyncRequest(request);
    }

}