package com.saydept.api.spf.saleNews.eventHallSaleInq;

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


public class EventHallSaleInqGenerator {
   public static ByteArrayInputStream toExcel(List<EventHallSaleInqModel> reportModels) throws IOException {
      String[] COLUMNs = {"명", "당일목표", "당일실적","당일할인","당일고객수","당일객단가","당일달성율", "누계목표", "누계실적","누계할인","누계고객수","누계객단가","누계달성율"};
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
         for (EventHallSaleInqModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

          
            row.createCell(0).setCellValue(reportModel.getNm());
          
           
         
            //목표
            Cell Try = row.createCell(1);
            Try.setCellValue(reportModel.getTry());
            Try.setCellStyle(intCellStyle);
            //실적
            Cell sale = row.createCell(2);
            sale.setCellValue(reportModel.getSale());
            sale.setCellStyle(intCellStyle);
            //할인
            Cell discount = row.createCell(3);
            discount.setCellValue(reportModel.getDiscount());
            discount.setCellStyle(intCellStyle);
            //고객수
            Cell custmernum = row.createCell(4);
            custmernum.setCellValue(reportModel.getCustmernum());
            custmernum.setCellStyle(intCellStyle);
            //객단가
            Cell custmercst = row.createCell(5);
            custmercst.setCellValue(reportModel.getCustmercst());
            custmercst.setCellStyle(intCellStyle);
            //달성율
            row.createCell(6).setCellValue(reportModel.getAchivmentrate());
            //누계목표
            Cell sumTry = row.createCell(7);
            sumTry.setCellValue(reportModel.getSumTry());
            sumTry.setCellStyle(intCellStyle);
            //누계실적
            Cell sumsale = row.createCell(8);
            sumsale.setCellValue(reportModel.getSumSale());
            sumsale.setCellStyle(intCellStyle);
            //누계할인
            Cell sumdiscount = row.createCell(9);
            sumdiscount.setCellValue(reportModel.getSumDiscount());
            sumdiscount.setCellStyle(intCellStyle);
            //누계고객수
            Cell sumcustmernum = row.createCell(10);
            sumcustmernum.setCellValue(reportModel.getSumCustmernum());
            sumcustmernum.setCellStyle(intCellStyle);
            //누계객단가
            Cell sumcustmercst = row.createCell(11);
            sumcustmercst.setCellValue(reportModel.getSumCustmercst());
            sumcustmercst.setCellStyle(intCellStyle);
            //누계달성율
            row.createCell(12).setCellValue(reportModel.getSumAchivmentrate());
            
           
            
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}