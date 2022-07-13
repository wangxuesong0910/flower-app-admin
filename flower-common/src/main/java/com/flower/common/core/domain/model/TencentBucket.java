package com.flower.common.core.domain.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 腾讯云存储桶参数对象
 * @author wxs
 * @date 2022/7/13 14:00
 */
@Component
public class TencentBucket {

    @Value("${storage.tencent.secretId}")
    private String secretId;

    @Value("${storage.tencent.secretKey}")
    private String secretKey;

    @Value("${storage.tencent.region}")
    private String region;

    @Value("${storage.tencent.bucketName}")
    private String bucketName;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public TencentBucket(String secretId, String secretKey, String region, String bucketName) {
        this.secretId = secretId;
        this.secretKey = secretKey;
        this.region = region;
        this.bucketName = bucketName;
    }

    public TencentBucket() {
    }

    @Override
    public String toString() {
        return "TencentBucket{" +
                "secretId='" + secretId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", region='" + region + '\'' +
                ", bucketName='" + bucketName + '\'' +
                '}';
    }
}
