package com.example.jkl.service.impl;

import com.example.jkl.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class UploadServiceImpl implements UploadService {


    public Map<String, Object> fileUpload(MultipartFile file, String upload) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (null == file) {
            resultMap.put("result", false);
            resultMap.put("msg", "获取上传文件失败,请检查file上传组件的名称是否正确");
        } else if (file.isEmpty()) {
            resultMap.put("result", false);
            resultMap.put("msg", "没有选择文件");
        } else {
            File fileDir = new File(upload);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            String filename = file.getOriginalFilename();
            filename = upload + "_" + filename;
            File dest = new File(filename);
            //保存文件
            try {
                file.transferTo(dest);
                resultMap.put("result", true);
                resultMap.put("msg", "上传成功");
                resultMap.put("filePath", "filename");
            } catch (IOException e) {
                e.printStackTrace();
                resultMap.put("result", false);
                resultMap.put("msg", "文件上传发生异常");
            }
        }
        return resultMap;
    }

}
