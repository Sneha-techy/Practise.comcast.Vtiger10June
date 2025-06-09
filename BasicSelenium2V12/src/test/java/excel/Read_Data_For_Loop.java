package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Data_For_Loop {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\sneha\\Desktop\\data\\testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(1);
		String col1data = row.getCell(0).toString();
		String col2data = row.getCell(1).toString();
		System.out.println(col1data +"----"+"\t"+col2data);
		
		wb.close();
				
		
	}	
	}
