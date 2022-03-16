package com.saydept.api.spf.saleNews.closeBefZoneSalePrint;

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

import com.saydept.api.spf.saleNews.closeBefZoneSalePrint.model.CloseBefZoneSalePrintModel;

public class CloseBefZoneSalePrintExcelGenerator {
   public static ByteArrayInputStream toExcel(List<CloseBefZoneSalePrintModel> reportModels) throws IOException {
      String[] COLUMNs = { "ZoneName", "Area", "yearNetSale", "FromDate", "ToDate" };
      try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
         CreationHelper createHelper = workbook.getCreationHelper();
         
         //Sheet생성
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
         ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

         int rowIdx = 1;
         for (CloseBefZoneSalePrintModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(reportModel.getZoneNm());
            row.createCell(1).setCellValue(reportModel.getArea());
            row.createCell(2).setCellValue(reportModel.getYearNetsale());

            Cell ageCell1 = row.createCell(3);
            ageCell1.setCellValue(reportModel.getFromSaleDate());
            ageCell1.setCellStyle(ageCellStyle);
            Cell ageCell2 = row.createCell(4);
            ageCell2.setCellValue(reportModel.getToSaleDate());
            ageCell2.setCellStyle(ageCellStyle);
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}