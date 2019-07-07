package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class excel implements Auto_const{
	
	public static String getexceldata(String sheet,String PATh,int row,int cell) 
	{
		String v="";
		try
		{
		FileInputStream fis=new FileInputStream(PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);
		 v = c.toString();
		}
		catch(Exception e)
		{
			Reporter.log("invalid",true);
		}
		
		
		return v;
		
				
	}

}
