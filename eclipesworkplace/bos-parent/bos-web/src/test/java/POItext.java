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
		String path="F:\\java������Ƶ\\5����׶� ��Ŀʵսһ��19�죩\\2.BOS��������ϵͳ��14�죩\\BOS-day05\\BOS-day05\\����\\�������������.xls";
		HSSFWorkbook hsswork = new HSSFWorkbook(new FileInputStream(new File(path)));
		HSSFSheet sheetAt = hsswork.getSheetAt(0);
		for (Row row : sheetAt) {
			System.out.println();
			int rowNum = row.getRowNum();
			if(rowNum==0){
				continue;//��������ѭ��
			}	
			//���ĳһ�е�����
			String id = row.getCell(0).getStringCellValue();
			System.out.println(id);
		}
	}
}
