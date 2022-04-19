package com.firstdevelop.boot.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.form.EmailAdressForm;

@Service
public class EmailService {
	/**									
	 * メール送信用、連絡先リスト処理									
	 * 									
	 * @param fileName お客様メール配信リスト.xlsxのファイル名									
	 * @param is       お客様メール配信リスト.xlsxの情報									
	 * @return メールアドレス情報リスト									
	 */									
	public List<EmailAdressForm> sendEmailAddressList(String fileName, InputStream is) throws Exception {									
										
		Workbook workbook = getWorkbook(fileName, is);								
										
		List<EmailAdressForm> addressList = new ArrayList<>();								
										
		Sheet sheet = workbook.getSheetAt(0);								
		if (sheet != null) {								
										
			int rowNum = sheet.getLastRowNum();							
										
			for (int j = 1; j <= rowNum; j++) {							
										
				Row row = sheet.getRow(j);						
										
				EmailAdressForm address = new EmailAdressForm();						
										
				// メールアドレス						
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);						
				address.setEmailAdress(row.getCell(0).getStringCellValue());						
				// 会社名						
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);						
				address.setComName(row.getCell(1).getStringCellValue());						
				// 連絡人						
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);						
				address.setPerson(row.getCell(2).getStringCellValue());						
										
				addressList.add(address);						
			}							
		}								
		return addressList;								
	}									
										
	/**									
	 * メール送信用エクセルファイルから取得した文字列をhtmlに変更処理									
	 * 									
	 * @param fileName メール本文.xlsx のファイル名									
	 * @param is       メール本文.xlsx の内容									
	 * @return									
	 * @throws Exception									
	 */									
	public String sendEmailText(String fileName, InputStream is) throws Exception {									
		Workbook workbook = getWorkbook(fileName, is);								
		int footRow = 13;								
		Sheet sheet = workbook.getSheetAt(0);								
		// メール本文内容をhtml形で設定する								
		String htmlEmailData = "<html>\n" + "<body>\n";								
		if (sheet != null) {								
			int rowNum = sheet.getLastRowNum();							
			for (int j = 0; j <= rowNum; j++) {							
				Row row = sheet.getRow(j);						
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);						
				if (j == 0 || j == 3) {						
					htmlEmailData = htmlEmailData + "<p>" + row.getCell(0).getStringCellValue() + "<br>\n";					
				} else if (j == 1 || j == rowNum - footRow - 1) {						
					htmlEmailData = htmlEmailData + row.getCell(0).getStringCellValue() + "</p>\n";					
				} else if (j == rowNum - footRow) {						
					htmlEmailData = htmlEmailData + "<p>" + row.getCell(0).getStringCellValue() + "<br>\n";					
				} else if (j > rowNum - footRow & j < rowNum) {						
					htmlEmailData = htmlEmailData + row.getCell(0).getStringCellValue() + "<br>\n";					
				} else if (j == rowNum) {						
					htmlEmailData = htmlEmailData + row.getCell(0).getStringCellValue() + "<br></p>\n";					
					htmlEmailData = htmlEmailData + "</body>\n" + "</html>";					
				}						
				;						
										
			}							
		}								
		return htmlEmailData;								
	}									
	// アップロードされたファイルの種類を判定
    private Workbook getWorkbook(String fileName,InputStream is) throws Exception{
        Workbook workbook = null;
        String name = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(name);
        if (".xls".equals(name)){
            workbook = new HSSFWorkbook(is);
        }else if (".xlsx".equals(name)){
            workbook = new XSSFWorkbook(is);
        }else {
            throw new Exception(" .xls/.xlsxのファイルをアップロードしてください");
        }
        return workbook;
    }
}
