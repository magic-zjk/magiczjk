package top.magiczjk.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import top.magiczjk.bean.ResultBean;
import top.magiczjk.entity.Lovely;
import top.magiczjk.service.DataService;
import top.magiczjk.service.QnUploadService;
import top.magiczjk.utils.DateUtils;

@RestController
@RequestMapping("/upload")
public class UploadController {
	private Logger log = Logger.getLogger(UploadController.class);

	@Autowired
	private QnUploadService qnUploadService;
	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/picture")
	public ResultBean packageUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@RequestParam("createTime") String createTime) throws Exception {
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件名
			String filename =  DateUtils.getCurrentDate("yyMMdd")+"_"+UUID.randomUUID().toString();
			// 原始文件名
			String originalFilename = file.getOriginalFilename();
			String[] split = originalFilename.split("\\.");
			if (split.length > 1) {
				filename = filename+"."+split[1];
			}
			String s = qnUploadService.uploadPicture(file.getBytes(), filename);
			// 保存数据库
			Lovely lovely = new Lovely();
			lovely.setCreatedAt(createTime);
			lovely.setUrl("http://p9g39ejeg.bkt.clouddn.com/" + s);
			dataService.save(lovely);
		} else {

		}
		return new ResultBean(true, null);
	}
	
}
