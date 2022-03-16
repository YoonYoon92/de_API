package com.saydept.api.app.appSayPlusSale;

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
import com.saydept.api.app.appSayPlusSale.model.AppSayPlusSaleModel;

//import com.saydept.api.report.ReportModel;

public class AppSayPlusSaleExcelGenerator {
   public static ByteArrayInputStream customersToExcel(List<AppSayPlusSaleModel> reportModels) throws IOException {
	   String[] COLUMNs = { "cls", "clsNm", "ddTotsale", "ddDsicount", "ddNetsale", "mmNetsale", "yyNetsale" };
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
         for (AppSayPlusSaleModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

//            row.createCell(0).setCellValue(reportModel.getJumNm());
//            row.createCell(1).setCellValue(reportModel.getBuNm());
//            row.createCell(2).setCellValue(reportModel.getTimNm());
//            row.createCell(3).setCellValue(reportModel.getPcNm());
//            row.createCell(1).setCellValue(reportModel.getCls());
            row.createCell(0).setCellValue(reportModel.getClsNm());
        	
//            row.createCell(1).setCellValue(reportModel.getThisYySplan());
//            row.createCell(2).setCellValue(reportModel.getThisYyNetsale());
//            row.createCell(3).setCellValue(reportModel.getThisYyAchivmentrate());
//            row.createCell(4).setCellValue(reportModel.getLastYySplan());
//            row.createCell(5).setCellValue(reportModel.getLastYyNetsale());
//            row.createCell(6).setCellValue(reportModel.getLastYyAchivmentrate());

            // CellStyle 숫자셀에 적용
//            Cell getThisYySplan = row.createCell(1);
//            getThisYySplan.setCellValue(reportModel.getThisYySplan());
//            getThisYySplan.setCellStyle(ageCellStyle);
//
//            Cell getThisYyNetsale = row.createCell(2);
//            getThisYyNetsale.setCellValue(reportModel.getThisYyNetsale());
//            getThisYyNetsale.setCellStyle(ageCellStyle);
//            
//            Cell getThisYyAchivmentrate = row.createCell(3);
//            getThisYyAchivmentrate.setCellValue(reportModel.getThisYyAchivmentrate());
//            getThisYyAchivmentrate.setCellStyle(ageCellStyle);
//            
//            Cell getLastYySplan = row.createCell(4);
//            getLastYySplan.setCellValue(reportModel.getLastYySplan());
//            getLastYySplan.setCellStyle(ageCellStyle);
//            
//            Cell getLastYyNetsale = row.createCell(5);
//            getLastYyNetsale.setCellValue(reportModel.getLastYyNetsale());
//            getLastYyNetsale.setCellStyle(ageCellStyle);
//            
//            Cell getLastYyAchivmentrate = row.createCell(6);
//            getLastYyAchivmentrate.setCellValue(reportModel.getLastYyAchivmentrate());
//            getLastYyAchivmentrate.setCellStyle(ageCellStyle);
            

         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}