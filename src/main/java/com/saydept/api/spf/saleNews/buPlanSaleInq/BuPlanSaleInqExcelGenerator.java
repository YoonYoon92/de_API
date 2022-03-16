package com.saydept.api.spf.saleNews.buPlanSaleInq;

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


public class BuPlanSaleInqExcelGenerator {
   public static ByteArrayInputStream toExcel(List<BuPlanSaleInqModel> reportModels) throws IOException {
      String[] COLUMNs = {"명", "목표", "실적","달성율","전년실적","신장율","객수","객단가"};
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
         for (BuPlanSaleInqModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

          
            row.createCell(0).setCellValue(reportModel.getPcNm());
          
           
         
            //목표
            Cell Try = row.createCell(1);
            Try.setCellValue(reportModel.getTry());
            Try.setCellStyle(intCellStyle);
            //실적
            Cell Splan = row.createCell(2);
            Splan.setCellValue(reportModel.getSplan());
            Splan.setCellStyle(intCellStyle);
            //달성율
            row.createCell(3).setCellValue(reportModel.getAchivmentrate());
            //전년실적
            Cell LastyearSplan = row.createCell(4);
            LastyearSplan.setCellValue(reportModel.getLastyearSplan());
            LastyearSplan.setCellStyle(intCellStyle);
            //신장율
            row.createCell(5).setCellValue(reportModel.getIncrsrate());
            //객수
            Cell CustmerNum = row.createCell(6);
            CustmerNum.setCellValue(reportModel.getCustmerNum());
            CustmerNum.setCellStyle(intCellStyle);
            //객단가
            Cell CustmerCst = row.createCell(7);
            CustmerCst.setCellValue(reportModel.getCustmerCst());
            CustmerCst.setCellStyle(intCellStyle);
            
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}