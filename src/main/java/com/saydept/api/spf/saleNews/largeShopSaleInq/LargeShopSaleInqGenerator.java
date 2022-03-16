package com.saydept.api.spf.saleNews.largeShopSaleInq;

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

import com.saydept.api.report.ReportModel;
import com.saydept.api.spf.saleNews.buPlanSaleInq.model.BuPlanSaleInqModel;
import com.saydept.api.spf.saleNews.eventHallSaleInq.model.EventHallSaleInqModel;
import com.saydept.api.spf.saleNews.largeShopSaleInq.model.LargeShopSaleInqModel;


public class LargeShopSaleInqGenerator {
   public static ByteArrayInputStream toExcel(List<LargeShopSaleInqModel> reportModels) throws IOException {
      String[] COLUMNs = {"코너번호","코너명", "당일목표", "당일실적","당일달성율","당월목표", "당월실적","당월달성율", "당년목표", "당년실적","당년달성율" };
      try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
         CreationHelper createHelper = workbook.getCreationHelper();

         Sheet sheet = workbook.createSheet("Sheet");

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
         CellStyle intCellStyle = workbook.createCellStyle();
         intCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("##,##0"));

         int rowIdx = 1;
         for (LargeShopSaleInqModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(reportModel.getConer());
            row.createCell(1).setCellValue(reportModel.getConerNm());
          
           
         
            //목표
            Cell ddTry = row.createCell(2);
            ddTry.setCellValue(reportModel.getDdTry());
            ddTry.setCellStyle(intCellStyle);
            //실적
            Cell ddSplan = row.createCell(3);
            ddSplan.setCellValue(reportModel.getDdSplan());
            ddSplan.setCellStyle(intCellStyle);
            //달성율
            row.createCell(4).setCellValue(reportModel.getDdAchivmentrate());
            //목표
            Cell mmTry = row.createCell(5);
            mmTry.setCellValue(reportModel.getYyTry());
            mmTry.setCellStyle(intCellStyle);
            //실적
            Cell mmSplan = row.createCell(6);
            mmSplan.setCellValue(reportModel.getYySplan());
            mmSplan.setCellStyle(intCellStyle);
            //달성율
            row.createCell(7).setCellValue(reportModel.getYyAchivmentrate());
          
            //목표
            Cell yyTry = row.createCell(8);
            yyTry.setCellValue(reportModel.getMmTry());
            yyTry.setCellStyle(intCellStyle);
            //실적
            Cell yySplan = row.createCell(9);
            yySplan.setCellValue(reportModel.getMmSplan());
            yySplan.setCellStyle(intCellStyle);
            //달성율
            row.createCell(10).setCellValue(reportModel.getMmAchivmentrate());
          
          
           
            
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}