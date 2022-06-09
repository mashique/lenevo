package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readExcel {
	
	@Test
	public void readXcel() throws IOException
	{
		
		File fs= new File("C:\\Users\\Lenovo\\Desktop\\test.xlsx");
		FileInputStream fis= new FileInputStream(fs);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh= wb.getSheetAt(0);
		String user = sh.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(user);
		
		
		
	}

}
