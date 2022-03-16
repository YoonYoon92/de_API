package com.saydept.api.sda.sleManageCt.ledgrSbManageCt;

//package com.saydept.api.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;


//import com.saydept.api.report.ReportModel;
import com.saydept.api.sda.sleManageCt.ledgrSbManageCt.model.LedgrSbManageCtModel;

//import com.saydept.api.report.ReportModel;

public class LedgrSbManageCtExcelGenerator {
   public static ByteArrayInputStream customersToExcel(List<LedgrSbManageCtModel> reportModels) throws IOException {
	   String[] COLUMNs = { "계정코드", "계정명", "계정상세", "전표번호", "전표순번", "부서", "부서명", "발행일자", "회계일자", "사업자번호", "사업자명", "점", "대차구분", "금액", "비고", "대변금액", "차변금액" };
      try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
         CreationHelper createHelper = workbook.getCreationHelper();

         Sheet sheet = workbook.createSheet("Sheet1");
         // 헤더 스타일 
         Font headerFont = workbook.createFont();
//         headerFont.setBold(true);
//         headerFont.setColor(IndexedColors.BLUE.getIndex());

         CellStyle headerCellStyle = workbook.createCellStyle();
         headerCellStyle.setFont(headerFont);
         
         // Row for Header
         Row headerRow = sheet.createRow(0);

         // Header 전체에 적용함
         for (int col = 0; col < COLUMNs.length; col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(COLUMNs[col]);
            cell.setCellStyle(headerCellStyle);
            
//          cell.setCellFormula(formula);
          // "cell" object previously created or looked up
//          String strFormula= "SUM(A1:A10)";
//          cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
//          cell.setCellFormula(strFormula);

         }

         // CellStyle 숫자셀용
         CellStyle ageCellStyle = workbook.createCellStyle();
         ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("##,##0"));
//         ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0;[RED]-#,##0"));

         int rowIdx = 1;
         for (LedgrSbManageCtModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(reportModel.getActCdDetail());
            row.createCell(1).setCellValue(reportModel.getActNm1());
            row.createCell(2).setCellValue(reportModel.getActNm2());
            row.createCell(3).setCellValue(reportModel.getSlpNo());
            row.createCell(4).setCellValue(reportModel.getSlpSeq());
            row.createCell(5).setCellValue(reportModel.getBuCd());
            row.createCell(6).setCellValue(reportModel.getBuNm());
            row.createCell(7).setCellValue(reportModel.getBalYmd());
            row.createCell(8).setCellValue(reportModel.getActYmd());
            row.createCell(9).setCellValue(reportModel.getCustNo());
            row.createCell(10).setCellValue(reportModel.getCustNm());
            row.createCell(11).setCellValue(reportModel.getSaGu());
            row.createCell(12).setCellValue(reportModel.getDcKind());
            // CellStyle 숫자셀에 적용
            Cell getBalM01 = row.createCell(13);
            getBalM01.setCellValue(reportModel.getSlpAmt());
            getBalM01.setCellStyle(ageCellStyle);
            
            row.createCell(14).setCellValue(reportModel.getReMark());

            // CellStyle 숫자셀에 적용
            Cell getBalM02 = row.createCell(15);
            getBalM02.setCellValue(reportModel.getIldAmt());
            getBalM02.setCellStyle(ageCellStyle);
            
            Cell getBalM03 = row.createCell(16);
            getBalM03.setCellValue(reportModel.getIlcAmt());
            getBalM03.setCellStyle(ageCellStyle);
            
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}