package com.saydept.api.spf.org.nonSalesCornerByPeriodMgt;

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

import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtCornerClosedModel;
import com.saydept.api.spf.org.nonSalesCornerByPeriodMgt.model.NonSalesCornerByPeriodMgtModel;

public class ExcelGenerator {
	
	public static ByteArrayInputStream toExcel(List<NonSalesCornerByPeriodMgtModel> nonSalesCornerByPeriodMgtModels) throws IOException {
		String[] COLUMNs = { "점", "점명", "부", "부명", "팀", "팀명", "세분류", "세분류명", "코너번호", "코너명", "등록일"};
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("미사용코너리스트");

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
			for (NonSalesCornerByPeriodMgtModel nonSalesCornerByPeriodMgtModel : nonSalesCornerByPeriodMgtModels) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(nonSalesCornerByPeriodMgtModel.getJumNo());
				row.createCell(1).setCellValue(nonSalesCornerByPeriodMgtModel.getJumName());
				row.createCell(2).setCellValue(nonSalesCornerByPeriodMgtModel.getBuNo());
				row.createCell(3).setCellValue(nonSalesCornerByPeriodMgtModel.getBuName());
				row.createCell(4).setCellValue(nonSalesCornerByPeriodMgtModel.getTeamNo());
				row.createCell(5).setCellValue(nonSalesCornerByPeriodMgtModel.getTeamName());
				row.createCell(6).setCellValue(nonSalesCornerByPeriodMgtModel.getPcNo());
				row.createCell(7).setCellValue(nonSalesCornerByPeriodMgtModel.getPcName());
				row.createCell(8).setCellValue(nonSalesCornerByPeriodMgtModel.getCornerNo());
				row.createCell(9).setCellValue(nonSalesCornerByPeriodMgtModel.getCornerName()); 
				row.createCell(10).setCellValue(nonSalesCornerByPeriodMgtModel.getRegiDate());
					
				//Cell ageCell = row.createCell(11);
				//ageCell.setCellValue(nonSalesCornerByPeriodMgtModel.getAmtOfTotal());
				//ageCell.setCellStyle(ageCellStyle);
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
		
		
		
	public static ByteArrayInputStream toExcelCornerClosed(List<NonSalesCornerByPeriodMgtCornerClosedModel> nonSalesCornerByPeriodMgtCornerClosedModels) throws IOException {
		String[] COLUMNs = { "점", "코너번호", "폐기일자", "수정일자"};
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("폐기코너리스트");

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
			for (NonSalesCornerByPeriodMgtCornerClosedModel nonSalesCornerByPeriodMgtCornerClosedModel : nonSalesCornerByPeriodMgtCornerClosedModels) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(nonSalesCornerByPeriodMgtCornerClosedModel.getJum());
				row.createCell(1).setCellValue(nonSalesCornerByPeriodMgtCornerClosedModel.getCornerNo());
				row.createCell(2).setCellValue(nonSalesCornerByPeriodMgtCornerClosedModel.getCornerClosedDate()); 
				row.createCell(3).setCellValue(nonSalesCornerByPeriodMgtCornerClosedModel.getUpdateDate());
					
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

}
