package com.saydept.api.spf.saleNews.cornerRtnSts;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.saydept.api.spf.saleNews.cornerRtnSts.model.CornerRtnStsModel;

public class ExcelGenerator {
	
	public static ByteArrayInputStream toExcel(List<CornerRtnStsModel> cornerRtnStsModels) throws IOException {
		String[] COLUMNs = { "점", "점명", "부", "부명", "팀", "팀명", "코너번호", "코너명","고객변심-건수","고객변심-금액","상품교환-건수","상품교환-금액","결제방법교체-건수","결제방법교체-금액","할인적용-건수","할인적용-금액","고객컴플레인-건수","고객컴플레인-금액","약속불이행-건수","약속불이행-금액","사이즈부적합-건수","사이즈부적합-금액","기타-건수","기타-금액","합계-건수","합계-금액" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("Customers");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,###,##0"));

			int rowIdx = 1;
			for (CornerRtnStsModel cornerRtnStsModel : cornerRtnStsModels) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(cornerRtnStsModel.getJumCd());
				row.createCell(1).setCellValue(cornerRtnStsModel.getJumName());
				row.createCell(2).setCellValue(cornerRtnStsModel.getBuCd());
				row.createCell(3).setCellValue(cornerRtnStsModel.getBuName());
				row.createCell(4).setCellValue(cornerRtnStsModel.getTimCd());
				row.createCell(5).setCellValue(cornerRtnStsModel.getTimName());
				row.createCell(6).setCellValue(cornerRtnStsModel.getCornerNo());
				row.createCell(7).setCellValue(cornerRtnStsModel.getCornerName()); 
				row.createCell(8).setCellValue(cornerRtnStsModel.getCountOfCustChg()); 
				row.createCell(9).setCellValue(cornerRtnStsModel.getAmtOfCustChg()); 
				row.createCell(10).setCellValue(cornerRtnStsModel.getCountOfProductExchg()); 
				row.createCell(11).setCellValue(cornerRtnStsModel.getAmtOfProductExchg()); 
				row.createCell(12).setCellValue(cornerRtnStsModel.getCountOfPaymentChg()); 
				row.createCell(13).setCellValue(cornerRtnStsModel.getAmtOfPaymentChg()); 
				row.createCell(14).setCellValue(cornerRtnStsModel.getCountOfApplyDiscount());
				row.createCell(15).setCellValue(cornerRtnStsModel.getAmtOfApplyDiscount()); 
				row.createCell(16).setCellValue(cornerRtnStsModel.getCountOfCustomerComplaint()); 
				row.createCell(17).setCellValue(cornerRtnStsModel.getAmtOfCustomerComplaint()); 
				row.createCell(18).setCellValue(cornerRtnStsModel.getCountOfNotPromise()); 
				row.createCell(19).setCellValue(cornerRtnStsModel.getAmtOfNotPromise());
				row.createCell(20).setCellValue(cornerRtnStsModel.getCountOfSizeNotSuitable());
				row.createCell(21).setCellValue(cornerRtnStsModel.getAmtOfSizeNotSuitable());
				row.createCell(22).setCellValue(cornerRtnStsModel.getCountOfEtc());
				row.createCell(23).setCellValue(cornerRtnStsModel.getAmtOfEtc());
				row.createCell(24).setCellValue(cornerRtnStsModel.getCountOfTotal());
				//row.createCell(25).setCellValue(cornerRtnStsModel.getAmtOfTotal());
					
				Cell ageCell = row.createCell(25);
				ageCell.setCellValue(cornerRtnStsModel.getAmtOfTotal());
				ageCell.setCellStyle(ageCellStyle);
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

}
