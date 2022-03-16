package com.saydept.api.spf.saleNews.buRtnSaleNews;

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
import com.saydept.api.spf.saleNews.buRtnSaleNews.model.BuRtnSaleNewsModel;

//import com.saydept.api.report.ReportModel;

public class BuRtnSaleNewsExcelGenerator {
   public static ByteArrayInputStream customersToExcel(List<BuRtnSaleNewsModel> reportModels) throws IOException {
	   String[] COLUMNs = { "jumNm", "buNm", "timNm", "pcNm", "cls", "clsNm", "ddCnt", "ddCash", "ddCard", "ddOther", "ddNetsale" };
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
         for (BuRtnSaleNewsModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(reportModel.getJumNm());
            row.createCell(1).setCellValue(reportModel.getBuNm());
            row.createCell(2).setCellValue(reportModel.getTimNm());
            row.createCell(3).setCellValue(reportModel.getPcNm());
            row.createCell(4).setCellValue(reportModel.getCls());
            row.createCell(5).setCellValue(reportModel.getClsNm());
            
            row.createCell(6).setCellValue(reportModel.getDdCnt());
            row.createCell(7).setCellValue(reportModel.getDdCash());
            row.createCell(8).setCellValue(reportModel.getDdCard());
            row.createCell(9).setCellValue(reportModel.getDdOther());
            row.createCell(10).setCellValue(reportModel.getDdNetsale());
            
            // CellStyle 숫자셀에 적용
            Cell getDdCnt = row.createCell(6);
            getDdCnt.setCellValue(reportModel.getDdCnt());
            getDdCnt.setCellStyle(ageCellStyle);

            Cell getDdCash = row.createCell(7);
            getDdCash.setCellValue(reportModel.getDdCash());
            getDdCash.setCellStyle(ageCellStyle);
            
            Cell getDdCard = row.createCell(8);
            getDdCard.setCellValue(reportModel.getDdCard());
            getDdCard.setCellStyle(ageCellStyle);
            
            Cell getDdOther = row.createCell(9);
            getDdOther.setCellValue(reportModel.getDdOther());
            getDdOther.setCellStyle(ageCellStyle);
            
            Cell getDdNetsale = row.createCell(10);
            getDdNetsale.setCellValue(reportModel.getDdNetsale());
            getDdNetsale.setCellStyle(ageCellStyle);
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}