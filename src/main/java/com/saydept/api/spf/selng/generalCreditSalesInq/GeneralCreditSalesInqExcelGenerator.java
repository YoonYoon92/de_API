package com.saydept.api.spf.selng.generalCreditSalesInq;

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
import com.saydept.api.spf.selng.generalCreditSalesInq.model.GeneralCreditSalesInqModel;


public class GeneralCreditSalesInqExcelGenerator {
   public static ByteArrayInputStream toExcel(List<GeneralCreditSalesInqModel> reportModels) throws IOException {
      String[] COLUMNs = {"구분","매출일자","포스번호","영수증번호","전표번호","조직코드","클래스번호","클래스명","단품번호","단품명","단가","수량","순매출액","할인액","총매출액","외상매출액","기타매출액"};
      
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
         for (GeneralCreditSalesInqModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);
            //"구분","매출일자","포스번호","영수증번호","전표번호","조직코드","클래스번호","클래스명","단품번호","단품명","단가","수량","순매출액","할인액","총매출액","외상매출액","기타매출액"
            //row.createCell(0).setCellValue(reportModel.getPc());
            //구분
            row.createCell(0).setCellValue(reportModel.getClassfication());
            //매출일자
            row.createCell(1).setCellValue(reportModel.getSaledate());
            //regi번호
            row.createCell(2).setCellValue(reportModel.getRegi());
            //영수증번호
            row.createCell(3).setCellValue(reportModel.getReceipt());
           //전표번호
            row.createCell(4).setCellValue(reportModel.getSlpno());
            //조직코드
            row.createCell(5).setCellValue(reportModel.getOrgCd());
            //클래스번호
            row.createCell(6).setCellValue(reportModel.getClassNo());
            //클래스명
            row.createCell(7).setCellValue(reportModel.getClassNm());
            //단품번호
            row.createCell(8).setCellValue(reportModel.getSingleItemNo());
            //단품명
            row.createCell(9).setCellValue(reportModel.getSingleItemNm());
            //단가
            Cell unitPrice = row.createCell(10);
            unitPrice.setCellValue(reportModel.getUnitPrice());
            unitPrice.setCellStyle(intCellStyle);
            //수량
            Cell quantity = row.createCell(11);
            quantity.setCellValue(reportModel.getQuantity());
            quantity.setCellStyle(intCellStyle);
            //순매출
            Cell netAmount = row.createCell(12);
            netAmount.setCellValue(reportModel.getNetAmount());
            netAmount.setCellStyle(intCellStyle);
            //할인액
            Cell saleAmount = row.createCell(13);
            saleAmount.setCellValue(reportModel.getSaleAmount());
            saleAmount.setCellStyle(intCellStyle);
            //총매출액
            Cell totalAmount = row.createCell(14);
            totalAmount.setCellValue(reportModel.getTotalAmount());
            totalAmount.setCellStyle(intCellStyle);
            //일반외상매출액
            Cell creditAmount = row.createCell(15);
            creditAmount.setCellValue(reportModel.getCreditAmount());
            creditAmount.setCellStyle(intCellStyle);
            //기타결제수단매출액
            Cell etcAmount = row.createCell(16);
            etcAmount.setCellValue(reportModel.getEtcAmount());
            etcAmount.setCellStyle(intCellStyle);
            
         }
      
         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}