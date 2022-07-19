package com.flower.erp.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flower.common.core.domain.model.TencentBucket;
import com.flower.common.utils.SecurityUtils;
import com.flower.common.utils.bucket.BucketSingleton;
import com.flower.common.utils.file.FileUploadUtils;
import com.flower.common.utils.file.FileUtils;
import com.flower.common.utils.uuid.IdUtils;
import com.flower.erp.domain.FlowerVarieties;
import com.flower.erp.domain.bo.FlowerDetailedBo;
import com.flower.erp.mapper.FlowerVarietiesMapper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flower.erp.mapper.FlowerDetailedMapper;
import com.flower.erp.domain.FlowerDetailed;
import com.flower.erp.service.IFlowerDetailedService;

/**
 * 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)Service业务层处理
 * 
 * @author wxs
 * @date 2022-03-08
 */
@Service
public class FlowerDetailedServiceImpl implements IFlowerDetailedService 
{
    @Autowired
    private FlowerDetailedMapper flowerDetailedMapper;

    @Autowired
    private FlowerVarietiesMapper flowerVarietiesMapper;

    @Autowired
    private TencentBucket tencentBucket;

    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param id 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    @Override
    public FlowerDetailed selectFlowerDetailedById(String id)
    {
        return flowerDetailedMapper.selectFlowerDetailedById(id);
    }

    /**
     * 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     */
    @Override
    public List<FlowerDetailed> selectFlowerDetailedList(FlowerDetailed flowerDetailed)
    {
        return flowerDetailedMapper.selectFlowerDetailedList(flowerDetailed);
    }

    /**
     * 新增花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    @Override
    public int insertFlowerDetailed(FlowerDetailed flowerDetailed)
    {
        if (flowerDetailed.getAscriptionId()==null || flowerDetailed.getAscriptionId().equals("")){
            FlowerVarieties flowerVarieties = flowerVarietiesMapper.selectFlowerVarietiesById(flowerDetailed.getVarietiesId());
            flowerDetailed.setAscriptionId(flowerVarieties.getAscriptionId());
        }
        String uid = IdUtils.fastSimpleUUID();
        flowerDetailed.setId(uid);
        flowerDetailed.setCreator(SecurityUtils.getUsername());
        flowerDetailed.setCreateDatetime(new Date());
        //获取文件路径，如果图片存在，那么就上传到存储桶，如果不存在，则不做操作
        File localFile = new File(FileUploadUtils.getDefaultBaseDir());
        String[] list = localFile.list();
        for (String fileName:list
             ) {
            if (fileName.startsWith("detailImg")){
                COSCredentials cred = new BasicCOSCredentials(tencentBucket.getSecretId(), tencentBucket.getSecretKey());
                Region region = new Region(tencentBucket.getRegion());
                ClientConfig clientConfig = new ClientConfig(region);
                clientConfig.setHttpProtocol(HttpProtocol.https);
                COSClient cosClient = BucketSingleton.getInstance(cred, clientConfig);
                File file = new File(localFile + "//" + fileName);
                PutObjectRequest putObjectRequest = new PutObjectRequest(tencentBucket.getBucketName(), "flower/detail/"+uid+"."+ fileName.split("\\.")[1], file);
                PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
                flowerDetailed.setImg("https://13033950399-1257633837.cos.ap-nanjing.myqcloud.com"+"/flower/detail/" + uid+"." + fileName.split("\\.")[1]);
            }
        }
        return flowerDetailedMapper.insertFlowerDetailed(flowerDetailed);
    }

    /**
     * 修改花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    @Override
    public int updateFlowerDetailed(FlowerDetailed flowerDetailed)
    {
        return flowerDetailedMapper.updateFlowerDetailed(flowerDetailed);
    }

    /**
     * 批量删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * 
     * @param ids 需要删除的花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerDetailedByIds(String[] ids)
    {
        return flowerDetailedMapper.deleteFlowerDetailedByIds(ids);
    }

    /**
     * 删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)信息
     * 
     * @param id 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)主键
     * @return 结果
     */
    @Override
    public int deleteFlowerDetailedById(String id)
    {
        return flowerDetailedMapper.deleteFlowerDetailedById(id);
    }


    /**
     * 查询花的种类，科属，二级分类
     * @param flowerDetailed 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    @Override
    public List<FlowerDetailedBo> selectFlowerDetailedBo(FlowerDetailed flowerDetailed){
       return flowerDetailedMapper.selectFlowerDetailedBo(flowerDetailed);
    }

    /**
     * 根据条件查询花的种类type
     * @param type 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
     * @return 结果
     */
    public List<String> selectFlowerDetailedType(String type){
        return flowerDetailedMapper.selectFlowerDetailedType(type);
    }

    @Override
    public List<Map<String, Object>> appDetailSelectList() {
        return flowerDetailedMapper.appDetailSelectList();
    }
}
