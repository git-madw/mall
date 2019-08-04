package io.renren.common.utils;

import io.renren.common.constant.Constant;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 图片上传工具类
 */
public class UploadUtils {

    public static Map<String,Object> ImgUpload(MultipartFile file) throws IOException {
        // 生成一个文件名16位数字+字母
        String fileRandomName = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        String realName = file.getOriginalFilename();
        String suffixName = realName.substring(realName.lastIndexOf("."));
        fileRandomName += suffixName;
        File tempFile = new File(Constant.IMGPATH, fileRandomName);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        if (tempFile.exists()) {
            tempFile.delete();
        }
        try {
            tempFile.createNewFile();
            file.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 封装文件的信息
        Map<String,Object> map = new HashMap<>();
        map.put("url",Constant.MVCPATH + fileRandomName);
        return map;
    }
}
