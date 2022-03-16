package com.saydept.api.spf.saleNews.corpSaleNews;

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

import com.saydept.api.spf.saleNews.corpSaleNews.model.CorpSaleNewsModel;

public class CorpSaleNewsExcelGenerator {
   public static ByteArrayInputStream toExcel(List<CorpSaleNewsModel> reportModels) throws IOException {
      String[] COLUMNs = { "부서", "부서명", "일목표", "일실적","일차액","일달성률","전년일실적","일신장률", "월목표", "월실적","월차액","월달성률","전년월실적","월신장률", "년목표", "년실적","년차액","년달성률","전년실적","년신장률" };
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
         for (CorpSaleNewsModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);
          //<<조직코드,조직명>>//  
            row.createCell(0).setCellValue(reportModel.getBuCode());
            row.createCell(1).setCellValue(reportModel.getBuName());
          //<<일 실적>>//
            //목표
            row.createCell(2).setCellValue(reportModel.getDayTry());
            //실적     
            row.createCell(3).setCellValue(reportModel.getDayNetsale());
            //차액           
            row.createCell(4).setCellValue(reportModel.getDayDnfnt());
            //달성률
            row.createCell(5).setCellValue(reportModel.getDayAchivmentrate());
            //전년실적
            row.createCell(6).setCellValue(reportModel.getDayLastyearSplan());
            //신장률
            row.createCell(7).setCellValue(reportModel.getDayIncrsrate());            
          //<<월 실적>>//
            //목표
            row.createCell(8).setCellValue(reportModel.getMmTry());
            //실적     
            row.createCell(9).setCellValue(reportModel.getMmNetsale());
            //차액           
            row.createCell(10).setCellValue(reportModel.getMmDnfnt());
            //달성률
            row.createCell(11).setCellValue(reportModel.getMmAchivmentrate());
            //전년실적
            row.createCell(12).setCellValue(reportModel.getMmLastyearSplan());
            //신장률
            row.createCell(13).setCellValue(reportModel.getMmIncrsrate());     
          //<<년 실적>>//
            //목표
            row.createCell(14).setCellValue(reportModel.getYyTry());
            //실적     
            row.createCell(15).setCellValue(reportModel.getYyNetsale());
            //차액           
            row.createCell(16).setCellValue(reportModel.getYyDnfnt());
            //달성률
            row.createCell(17).setCellValue(reportModel.getYyAchivmentrate());
            //전년실적
            row.createCell(18).setCellValue(reportModel.getYyLastyearSplan());
            //신장률
            row.createCell(19).setCellValue(reportModel.getYyIncrsrate());       
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}