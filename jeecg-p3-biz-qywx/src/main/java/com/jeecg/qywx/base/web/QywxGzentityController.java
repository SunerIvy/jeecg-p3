package com.jeecg.qywx.base.web;

import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jeecg.qywx.base.entity.QywxGzentity;
import com.jeecg.qywx.base.dao.QywxGzentityDao;

 /**
 * 描述：</b>QywxGzentityController<br>关注回复; InnoDB free: 130048 kB
 * @author zhoujf
 * @since：2016年03月25日 12时04分15秒 星期五 
 * @version:1.0
 */
@Controller
@RequestMapping("/qywx/qywxGzentity")
public class QywxGzentityController extends BaseController{
  @Autowired
  private QywxGzentityDao qywxGzentityDao;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute QywxGzentity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<QywxGzentity> list =  qywxGzentityDao.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("qywxGzentity",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "qywx/base/qywxGzentity-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
			e.printStackTrace();
			}
}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void qywxGzentityDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "qywx/base/qywxGzentity-detail.vm";
			QywxGzentity qywxGzentity = qywxGzentityDao.get(id);
			velocityContext.put("qywxGzentity",qywxGzentity);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "qywx/base/qywxGzentity-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute QywxGzentity qywxGzentity){
		AjaxJson j = new AjaxJson();
		try {
		    String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		    qywxGzentity.setId(randomSeed);
		    qywxGzentity.setIsWork("0");
		    qywxGzentity.setCreateDate(new Date());
			qywxGzentityDao.insert(qywxGzentity);
			j.setMsg("保存成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			 VelocityContext velocityContext = new VelocityContext();
			 QywxGzentity qywxGzentity = qywxGzentityDao.get(id);
			 velocityContext.put("qywxGzentity",qywxGzentity);
			 String viewName = "qywx/base/qywxGzentity-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute QywxGzentity qywxGzentity){
		AjaxJson j = new AjaxJson();
		try {
			qywxGzentityDao.update(qywxGzentity);
			j.setMsg("编辑成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
		return j;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
			    QywxGzentity qywxGzentity = new QywxGzentity();
				qywxGzentity.setId(id);
				qywxGzentityDao.delete(qywxGzentity);
				j.setMsg("删除成功");
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}
	
	
	/**
	 * 启用
	 * @return
	 */
	@RequestMapping(params="doWorkLock",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doWorkLock(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
			    QywxGzentity qywxGzentity = new QywxGzentity();
				qywxGzentity.setId(id);
				qywxGzentity.setIsWork("1");
				qywxGzentityDao.update(qywxGzentity);
				j.setMsg("启用成功");
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("启用失败");
			}
			return j;
	}

	/**
	 * 停用
	 * @return
	 */
	@RequestMapping(params="doWorkUnLock",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doWorkUnLock(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
			    QywxGzentity qywxGzentity = new QywxGzentity();
				qywxGzentity.setId(id);
				qywxGzentity.setIsWork("0");
				qywxGzentityDao.update(qywxGzentity);
				j.setMsg("停用成功");
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("停用失败");
			}
			return j;
	}

}

