package DDT_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTExcel {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Applications/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void readTest() throws IOException {
		
		FileInputStream File = new FileInputStream(Constant.File_Path);
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		for(int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for(int colNum = 0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells(); colNum++) {
				
				XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
				String userCell = cell.getStringCellValue();
				
				System.out.println(userCell);
			}
		}	
	}
	
}
