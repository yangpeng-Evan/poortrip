package com.yp.controller;

import com.yp.enums.PoorEnum;
import com.yp.exception.PoorException;
import com.yp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("pic")
@Slf4j
public class PicController {

    private final long MAX_UPLOAD_SIZE = 5242880;

    @Value("${pic.types}")
    private String types;

    @Value("${pic.path}")
    private String path;

    @PostMapping("/upload")
    public ResultVO pic(MultipartFile file) throws IOException {
        //1. 图片不为空.
        if(file == null){
            log.info("【上传图片】 图片上传项为null!! file = {}",file);
            throw new PoorException(PoorEnum.UPLOAD_FILE_ERROR);
        }
        //2. 校验大小.
        if(file.getSize() > MAX_UPLOAD_SIZE){
            log.info("【上传图片】 图片上传项过大,建议小于5M!! file = {}",file);
            throw new PoorException(PoorEnum.UPLOAD_FILE_SIZE_ERROR);
        }
        //3. 校验类型.
        boolean flag = false;
        for (String type : types.split(",")) {
            if(StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),type)){
                flag = true;
                break;
            }
        }
        if(!flag){
            // 图片类型不正确
            log.info("【上传图片】 图片类型不正确. file = {}",file);
            throw new PoorException(PoorEnum.UPLOAD_FILE_TYPE_ERROR);
        }
        //4. 是否损坏.
        BufferedImage image = ImageIO.read(file.getInputStream());
        if(image == null){
            // 图片已损坏
            log.info("【上传图片】 图片已经损坏. file = {}",file);
            throw new PoorException(PoorEnum.UPLOAD_FILE_BAD_ERROR);
        }
        //5. 起一个新名字.
        String prefixName = UUID.randomUUID().toString();
        String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newName = prefixName + suffixName;
        //6. 指定保存图片的本地路径.
        File pathFile = new File(path + newName);
        if(!pathFile.getParentFile().exists()){
            pathFile.getParentFile().mkdirs();
        }
        //7. 保存到本地.
        file.transferTo(pathFile);

        //8. 声明图片的访问路径.  静态资源路径,将D:/poor/pic/指定为静态资源路径
        String url = "http://localhost/pic/" + newName;

        //9. 返回图片的访问路径
        return new ResultVO(0,"",url);
    }

}
