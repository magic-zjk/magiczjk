package top.magiczjk.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.magiczjk.bean.ResultBean;
import top.magiczjk.entity.Lovely;
import top.magiczjk.service.DataService;

@RestController
@RequestMapping("/data")
public class DataController {
	private Logger log = Logger.getLogger(DataController.class);

	@Autowired
	private DataService dataService;

	/**
	 * 
	* @Title: lovely  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param pageSize
	* @param @param pageNum
	* @param @return
	* @param @throws Exception    参数  
	* @return ResultBean    返回类型  
	* @throws
	* 	https://gank.io/api/data/%E7%A6%8F%E5%88%A9/2/1
	 */
	@RequestMapping("/lovely/{pageSize}/{pageNum}")
	public ResultBean lovely(@PathVariable("pageSize") String pageSize, @PathVariable("pageNum") String pageNum)
			throws Exception {
		List<Lovely> list = dataService.getLovelys(pageSize, pageNum);
		return new ResultBean(true, list);
	}

	@RequestMapping("/lovely/save")
	public ResultBean save() throws Exception {
		Lovely lovely = new Lovely();
		lovely.setCreatedAt(new Date().getTime()+"");
		lovely.setDesc("");
		lovely.setUrl("http://pic13.nipic.com/20110421/7074946_131907700142_2.jpg");
		dataService.save(lovely);
		return new ResultBean(true, null);
	}

}
