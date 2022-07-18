package com.flower.common.utils.bucket;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.COSCredentials;

/**
 * 存储桶的客户端Client创建，需要为单例模式
 * @author wxs
 * @date 2022/7/18 13:59
 */
public class BucketSingleton {
    private static COSClient instance = null;
    private BucketSingleton (){}
    public static COSClient getInstance(COSCredentials cred, ClientConfig clientConfig) {
        if (instance==null){
            instance = new COSClient(cred, clientConfig);
            return instance;
        }
        return instance;
    }
}
