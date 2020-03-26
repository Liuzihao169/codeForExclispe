import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POItext {
	@Test
	public void test() throws FileNotFoundException, IOException{
		String path="F:\\java黑马视频\\5第五阶段 项目实战一（19天）\\2.BOS物流管理系统（14天）\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
		HSSFWorkbook hsswork = new HSSFWorkbook(new FileInputStream(new File(path)));
		HSSFSheet sheetAt = hsswork.getSheetAt(0);
		for (Row row : sheetAt) {
			System.out.println();
			int rowNum = row.getRowNum();
			if(rowNum==0){
				continue;//结束本次循环
			}	
			//获得某一列的数据
			String id = row.getCell(0).getStringCellValue();
			System.out.println(id);
		}
	}
}
