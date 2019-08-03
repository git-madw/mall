package io.renren.common.utils;

import io.renren.common.constant.Constant;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传工具类
 */
public class UploadUtils {

    public static Map<String,Object> ImgUpload(MultipartHttpServletRequest multiReq) throws IOException {
        FileOutputStream fos = new FileOutputStream(
                new File(Constant.IMGPATH));
        FileInputStream fs = (FileInputStream) multiReq.getFile("img").getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fs.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        Map<String ,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("msg","上传成功");
        map.put("url","http://localhost:8080/tomcat.png");
        return map;
    }
}
