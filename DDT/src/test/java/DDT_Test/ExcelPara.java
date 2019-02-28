package DDT_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ExcelPara {
	
	@Parameters
	public static Collection<Object[]> data() throws IOException{
		
		FileInputStream File = new FileInputStream(Constant.File_Path);
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowNum = sheet.getPhysicalNumberOfRows();
		Object[][] ob = new Object[rowNum-1][4];
		
		for(int row = 1; row < rowNum; row++) {
			{
				ob[row-1][0] = sheet.getRow(row).getCell(0).getStringCellValue();
				ob[row-1][1] = sheet.getRow(row).getCell(1).getStringCellValue();
				ob[row-1][2] = sheet.getRow(row).getCell(2).getStringCellValue();
				ob[row-1][3] = row;
			}
		}
		workbook.close();
		return Arrays.asList(ob);
	}
	
	private String userName;
	private String password;
	private String expectedValue;
	private int row;

	public ExcelPara(String userName, String password, String expectedValue, int row) {
		super();
		this.userName = userName;
		this.password = password;
		this.expectedValue = expectedValue;
		this.row = row;
	}
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constant.DRIVER_LOCATION);
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}

	
	@Test
	public void login() {
		
		driver.get(Constant.NEW_USER_URL);
		
		
		System.out.println(userName +" " +password +" " +expectedValue);
	}

}
