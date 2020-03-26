package com.heima.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Region;
import com.heima.bos.entity.Subarea;
import com.heima.service.SubareaService;
import com.heima.utils.FileUtils;
import com.heima.utils.HighchartsByPrivence;
import com.opensymphony.xwork2.security.DefaultAcceptedPatternsChecker;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Autowired
	private SubareaService subareaService;
	private String ids ;
	private String decidedzoneId;
	public String add(){
		subareaService.save(model);
		return null;
	}
	//查询 所有的分区的信息
	public String pageQuery(){
		//如果前台没有传过滤条件的时候  传过来的是""而不是null
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		String addresskey = model.getAddresskey();
		Region region = model.getRegion();
		detachedCriteria.createAlias("region", "r");
		if(StringUtils.isNotBlank(addresskey)){
			detachedCriteria.add(Restrictions.like("addresskey","%"+addresskey+"%"));
		}
		if(region!=null){
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			if(StringUtils.isNotBlank(province)){
				detachedCriteria.add(Restrictions.like("r.province","%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)){
				detachedCriteria.add(Restrictions.like("r.city","%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)){
				detachedCriteria.add(Restrictions.like("r.district","%"+district+"%"));
			}
		}
		subareaService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","subareas","decidedzone"});
		return null;
	}
	//导出分区
	public String exportXls() throws IOException{
		List<Subarea>list=subareaService.findByIds(ids);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet createSheet = workbook.createSheet("数据表格");
		HSSFRow HeadRow = createSheet.createRow(0);
		HeadRow.createCell(0).setCellValue("分区id");
		HeadRow.createCell(1).setCellValue("开始符");
		HeadRow.createCell(2).setCellValue("结束符");
		HeadRow.createCell(3).setCellValue("位置");
		HeadRow.createCell(4).setCellValue("省市区");
      for (Subarea subarea : list) {
    	  HSSFRow  dataRow=createSheet.createRow(createSheet.getLastRowNum()+1);
    	dataRow.createCell(0).setCellValue(subarea.getId());
  		dataRow.createCell(1).setCellValue(subarea.getStartnum());
  		dataRow.createCell(2).setCellValue(subarea.getEndnum());
  		dataRow.createCell(3).setCellValue(subarea.getPosition());
  		dataRow.createCell(4).setCellValue(subarea.getRegion().getName());
		}
      Date date=new Date();
      SimpleDateFormat format=new SimpleDateFormat("MM_dd_hh_mm");
      String time = format.format(date);
      //获得浏览器的头信息
      String agent = ServletActionContext.getRequest().getHeader("User-Agent");
      String name="数据表格"+time+".xls";
      //告诉浏览器编码格式
     String filename = FileUtils.encodeDownloadFilename(name, agent);
     //告诉浏览器这个文件的类型是设么
      ServletActionContext.getResponse().setContentType(ServletActionContext.getServletContext().getMimeType(filename));
      //告诉客户端不要解析 以文件的形式打开
      ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment;filename="+filename );
      ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
      workbook.write(out);
		return null;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	//查询分区的list信息
	public String listAjax(){
		DetachedCriteria criteria=DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件
		criteria.add(Restrictions.isNull("decidedzone"));
		List<Subarea>list=subareaService.findHasNoDecidezone(criteria);
		java2Json(list, new String []{"decidedzone","region"});
		return null;
	}
	public String findListByDecidedzoneId(){
		DetachedCriteria  Criteria =DetachedCriteria.forClass(Subarea.class);
		Criteria.add(Restrictions.eq("decidedzone.id",decidedzoneId));
		List<Subarea>list=subareaService.findListByDecidedzoneId(Criteria);
		java2Json(list, new String[]{"subareas","decidedzone"});
		return null;
	}
	public String findSubareaByProvince(){
		List<HighchartsByPrivence>list= new ArrayList<HighchartsByPrivence>();
		List<Object>objectlist=subareaService.findSubareaByProvince();
		for (Object object : objectlist) {
			Object []obj=(Object[])object;
			String name=(String) obj[0];
			Integer y=((Long)obj[1]).intValue();//count
			//创建HighchartsByPrivence然后添加到list当中
			list.add(new HighchartsByPrivence(name,y));
		}
		//转json 
		java2Json(list, new String[]{});
		return null;
	}
	public void setDecidedzoneId(String decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}
}
