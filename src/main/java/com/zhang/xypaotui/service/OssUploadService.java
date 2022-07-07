package com.zhang.xypaotui.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class OssUploadService {
    public String uploadfile(MultipartFile multipartFile,String dir){
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。关于其他Region对应的Endpoint信息，请参见访问域名和数据中心。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        //accesskeyId
        //accessKeySecret
        String accessKeyId = "";
        String accessKeySecret = "";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "zitbookings";

        // 创建OSSClient实例。

        OSS ossClient =null;
        try {
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 1.获取文件上传流
            InputStream inputStream = multipartFile.getInputStream();
            // 2.构建日期目录
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String dataPath = sdf.format(new Date());
            // 4.获取文件真实名字 并重构
            String originalFilename = multipartFile.getOriginalFilename();
            String filename = UUID.randomUUID().toString();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newName = filename + suffix;

            String fileUrl = dir +"/"+ dataPath + newName;

            // 5.文件上传到阿里云云服务器
            ossClient.putObject(bucketName, fileUrl, inputStream);

            return "http://" +  bucketName + "." + endpoint + "/" + fileUrl;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
            return "fail";
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
            return "fail";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

    }
}
