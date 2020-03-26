package com.heima.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Region;
import com.heima.service.RegionService;
import com.heima.utils.PageBean;
import com.heima.utils.PinYin4jUtils;

@Controller("regionAction")
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {
	@Autowired
	private RegionService regionService;
	private File regionImport;
	private String q;
	public String importXls() throws FileNotFoundException, IOException {
		// System.out.println(regionImport);
		// String path="F:\\java黑马视频\\5第五阶段
		// 项目实战一（19天）\\2.BOS物流管理系统（14天）\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
		List<Region> list = new ArrayList<Region>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionImport));
		HSSFSheet sheetAt = workbook.getSheetAt(0);
		for (Row row : sheetAt) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				continue;
			}
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			Region region = new Region(row.getCell(0).getStringCellValue(), province, city, district,
					row.getCell(4).getStringCellValue(), null, null, null);
			String info=province.substring(0, province.length()-1)+city.substring(0, city.length()-1)+district.substring(0, district.length()-1);
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortCode = StringUtils.join(headByString);
			String cityCode = PinYin4jUtils.hanziToPinyin(info,"");
			region.setCitycode(cityCode);
			region.setShortcode(shortCode);
			list.add(region);

		}
		regionService.save(list);
		return null;
	}
	/*
	 * 分页查询*/
	public void pageQuery(){
		regionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","subareas"});
	}
	/*查找区域的信息*/
	public String findRegionAjax(){
		List<Region>list=null;
		if(StringUtils.isNotBlank(q)){
			list=regionService.findByQuery(q);
		}else{
			list=regionService.findAll();
		}
	this.java2Json(list, new String[]{"subareas"});
		return null;
	}
	public void setRegionImport(File regionImport) {
		this.regionImport = regionImport;
	}
	public void setQ(String q) {
		this.q = q;
	}
	
}
