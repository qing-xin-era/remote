package com.qing.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class UploadUtil {
    //阿里域名
    public static final String ALI_DOMAIN = "https://xiao-meng-you-standard-03.oss-cn-beijing.aliyuncs.com/";

    public static String uploadImage(MultipartFile file) throws IOException {











        //生成文件名
        System.out.println("1kkkk");
        String originalFilename = file.getOriginalFilename(); //原来的图片名
        System.out.println("2kkkk"+originalFilename);
        String ext = "." + FilenameUtils.getExtension(originalFilename);
        System.out.println("3kkkk"+ext);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + ext;
        //地域节点
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI5tNWxCZKoM7BTrKbZ7um";
        String accessKeySecret = "nOZfcPYonqlj3JPvymduJBlZYIJpEU";
        System.out.println("2kkkk");
        //OSS客户端对象
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(
                "xiao-meng-you-standard-03", //仓库名
                fileName, //文件名
                file.getInputStream()
        );
        System.out.println("3kkkk");
        ossClient.shutdown();
        return ALI_DOMAIN + fileName;
    }
}
