package com.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sh;

	public ExcelReader(String Source) // Creating a Constructor with Adding Paramter
	{
		try {
			File src = new File(Source);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);


		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String getDatafromExcel(int SheetNumber,int row, int coloum)

	{
	    String data = null;
		sh = wb.getSheetAt(SheetNumber);
		try {
            data =  sh.getRow(row).getCell(coloum).getStringCellValue();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
		return data;
	}

	public int getRowCount(int sheetIndex)
	{
	    int row = 0;
        try
        {
            row = wb.getSheetAt(sheetIndex).getPhysicalNumberOfRows();

        }
        catch (Exception e)
        {

          System.out.println(e.getMessage());
        }
	    return row;

	}
	public int getColoumCount(int sheetIndex)
    {
        int coloumn = 0;

        try
        {
            coloumn = wb.getSheetAt(sheetIndex).getRow(0).getPhysicalNumberOfCells();
        }
        catch (Exception e)
        {

            System.out.println(e.getMessage());
        }
        return coloumn;

    }

}
