/**
 * Project Name:magiczjk
 * File Name:QnUploadService.java
 * Package Name:top.magiczjk.service
 * Date:2018年6月12日下午4:39:23
 * Copyright (c) 2018, zjk All Rights Reserved.
 *
*/

package top.magiczjk.service;

import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * ClassName:QnUploadService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2018年6月12日 下午4:39:23 <br/>
 * 
 * @author zhangjiakun
 * @version
 * @since JDK 1.8
 * @see
 */
@Service
public class QnUploadService {
	private Logger log = Logger.getLogger(QnUploadService.class);
	
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	private String ACCESS_KEY = "uI1ahMEGiNr4qyoZNAyL96LkfWrk8nYv_haVKMah";
	private String SECRET_KEY = "v4PvBSscYwXnt-yLBqD5T2GktR4N_QL67tgak5On";
	// 要上传的空间
	private String bucketname = "magiczjk";
	private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	// 创建上传对象
	Configuration cfg = new Configuration(Zone.zone1());
	private UploadManager uploadManager = new UploadManager(cfg);

	public String getUpToken(String name) {
		return auth.uploadToken(bucketname, name);
	}

	public String uploadPicture(byte[] bytes, String name) throws Exception {
		try {
			Response res = uploadManager.put(bytes, name, getUpToken(name));
			log.info("uploadIcon end: " + res.bodyString());
			ObjectMapper mapper = new ObjectMapper();
			@SuppressWarnings("unchecked")
			Map<String, String> result = mapper.readValue(res.bodyString(), Map.class);
			return result.get("key");
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			log.error(r.toString());
			try {
				// 响应的文本信息
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return "";
	}
	
	
	public String uploadPicture(String filePath, String name) throws Exception {
		try {
			Response res = uploadManager.put(filePath, name, getUpToken(name));
			log.info("uploadIcon end: " + res.bodyString());
			ObjectMapper mapper = new ObjectMapper();
			@SuppressWarnings("unchecked")
			Map<String, String> result = mapper.readValue(res.bodyString(), Map.class);
			return result.get("key");
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			log.error(r.toString());
			try {
				// 响应的文本信息
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return "";
	}
	
	public String uploadPicture(File file, String name) throws Exception {
		try {
			Response res = uploadManager.put(file, name, getUpToken(name));
			log.info("uploadIcon end: " + res.bodyString());
			ObjectMapper mapper = new ObjectMapper();
			@SuppressWarnings("unchecked")
			Map<String, String> result = mapper.readValue(res.bodyString(), Map.class);
			return result.get("key");
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			log.error(r.toString());
			try {
				// 响应的文本信息
				log.error(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return "";
	}
	
}
