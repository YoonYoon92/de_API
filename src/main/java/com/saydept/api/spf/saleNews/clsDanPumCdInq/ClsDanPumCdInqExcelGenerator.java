package com.saydept.api.spf.saleNews.clsDanPumCdInq;

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
import com.saydept.api.spf.saleNews.clsDanPumCdInq.model.ClsDanPumCdInqModel;

//import com.saydept.api.report.ReportModel;

public class ClsDanPumCdInqExcelGenerator {
   public static ByteArrayInputStream customersToExcel(List<ClsDanPumCdInqModel> reportModels) throws IOException {
	   String[] COLUMNs = { "Smm", "ThisYySplan", "ThisYyNetsale", "LastYySplan", "LastYyNetsale", "Achivmentrate", "Incrsrate" };
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
         ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("##,##0.00"));
//         ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0;[RED]-#,##0"));

         int rowIdx = 1;
         for (ClsDanPumCdInqModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

//            row.createCell(0).setCellValue(reportModel.getJumNm());
//            row.createCell(1).setCellValue(reportModel.getBuNm());
//            row.createCell(2).setCellValue(reportModel.getTimNm());
//            row.createCell(0).setCellValue(reportModel.getSmm());
//            row.createCell(1).setCellValue(reportModel.getPcNm());
//            row.createCell(2).setCellValue(reportModel.getCls());
//            row.createCell(3).setCellValue(reportModel.getClsNm());
        	
//            row.createCell(1).setCellValue(reportModel.getThisYySplan());
//            row.createCell(2).setCellValue(reportModel.getThisYyNetsale());
//            row.createCell(3).setCellValue(reportModel.getLastYySplan());
//            row.createCell(4).setCellValue(reportModel.getLastYyNetsale());
//            row.createCell(5).setCellValue(reportModel.getAchivmentrate());
//            row.createCell(6).setCellValue(reportModel.getIncrsrate());
            // CellStyle 숫자셀에 적용
//            Cell getThisYySplan = row.createCell(1);
//            getThisYySplan.setCellValue(reportModel.getThisYySplan());
//            getThisYySplan.setCellStyle(ageCellStyle);
//            
//            Cell getThisYyNetsale = row.createCell(2);
//            getThisYyNetsale.setCellValue(reportModel.getThisYyNetsale());
//            getThisYyNetsale.setCellStyle(ageCellStyle);
//            
//            Cell getLastYySplan = row.createCell(3);
//            getLastYySplan.setCellValue(reportModel.getLastYySplan());
//            getLastYySplan.setCellStyle(ageCellStyle);
//            
//            Cell getLastYyNetsale = row.createCell(4);
//            getLastYyNetsale.setCellValue(reportModel.getLastYyNetsale());
//            getLastYyNetsale.setCellStyle(ageCellStyle);
//            
//            Cell getAchivmentrate = row.createCell(5);
//            getAchivmentrate.setCellValue(reportModel.getAchivmentrate());
//            getAchivmentrate.setCellStyle(ageCellStyle);
//            
//            Cell getIncrsrate = row.createCell(6);
//            getIncrsrate.setCellValue(reportModel.getIncrsrate());
//            getIncrsrate.setCellStyle(ageCellStyle);

         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}