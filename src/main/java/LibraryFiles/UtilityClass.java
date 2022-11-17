package LibraryFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityClass 
{

	public static String getDataFromPF(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\shind\\eclipse-workspace\\CompanyAssignment\\PropertyFile.properties");
		//create object of Properties class
		Properties prop=new Properties();
		//to open property file
		prop.load(file);
		String value1=prop.getProperty(key);
		return value1;
	}
	public static String getDataFromExcel(int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\shind\\eclipse-workspace\\CompanyAssignment\\Testdata\\demo.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet8");
		String value=sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		return value;
	}
}
