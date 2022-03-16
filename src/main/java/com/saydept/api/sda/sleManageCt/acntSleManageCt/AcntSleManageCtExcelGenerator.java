package com.saydept.api.sda.sleManageCt.acntSleManageCt;

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
import com.saydept.api.sda.sleManageCt.acntSleManageCt.model.AcntSleManageCtModel;

//import com.saydept.api.report.ReportModel;

public class AcntSleManageCtExcelGenerator {
   public static ByteArrayInputStream customersToExcel(List<AcntSleManageCtModel> reportModels) throws IOException {
	   String[] COLUMNs = { "계정코드", "계정명", "계정상세", "부서명", "점", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월", "합계" };
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
         for (AcntSleManageCtModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(reportModel.getActCdDetail());
            row.createCell(1).setCellValue(reportModel.getActNm1());
        	
            row.createCell(2).setCellValue(reportModel.getActNm2());
            row.createCell(3).setCellValue(reportModel.getBuNm());
            row.createCell(4).setCellValue(reportModel.getSaGu());
//            row.createCell(5).setCellValue(reportModel.getMmNetsale());
//            row.createCell(6).setCellValue(reportModel.getYyNetsale());

            // CellStyle 숫자셀에 적용
            Cell getBalM01 = row.createCell(5);
            getBalM01.setCellValue(reportModel.getBalM01());
            getBalM01.setCellStyle(ageCellStyle);

            Cell getBalM02 = row.createCell(6);
            getBalM02.setCellValue(reportModel.getBalM02());
            getBalM02.setCellStyle(ageCellStyle);
            
            Cell getBalM03 = row.createCell(7);
            getBalM03.setCellValue(reportModel.getBalM03());
            getBalM03.setCellStyle(ageCellStyle);
            
            Cell getBalM04 = row.createCell(8);
            getBalM04.setCellValue(reportModel.getBalM04());
            getBalM04.setCellStyle(ageCellStyle);
            
            Cell getBalM05 = row.createCell(9);
            getBalM05.setCellValue(reportModel.getBalM05());
            getBalM05.setCellStyle(ageCellStyle);
            
            Cell getBalM06 = row.createCell(10);
            getBalM06.setCellValue(reportModel.getBalM06());
            getBalM06.setCellStyle(ageCellStyle);
            
            Cell getBalM07 = row.createCell(11);
            getBalM07.setCellValue(reportModel.getBalM07());
            getBalM07.setCellStyle(ageCellStyle);
            
            Cell getBalM08= row.createCell(12);
            getBalM08.setCellValue(reportModel.getBalM08());
            getBalM08.setCellStyle(ageCellStyle);
            
            Cell getBalM09 = row.createCell(13);
            getBalM09.setCellValue(reportModel.getBalM09());
            getBalM09.setCellStyle(ageCellStyle);
            
            Cell getBalM10 = row.createCell(14);
            getBalM10.setCellValue(reportModel.getBalM10());
            getBalM10.setCellStyle(ageCellStyle);
            
            Cell getBalM11 = row.createCell(15);
            getBalM11.setCellValue(reportModel.getBalM11());
            getBalM11.setCellStyle(ageCellStyle);
            
            Cell getBalM12 = row.createCell(16);
            getBalM12.setCellValue(reportModel.getBalM12());
            getBalM12.setCellStyle(ageCellStyle);
            
            Cell getBalMTot = row.createCell(17);
            getBalMTot.setCellValue(reportModel.getBalMTot());
            getBalMTot.setCellStyle(ageCellStyle);
            
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}