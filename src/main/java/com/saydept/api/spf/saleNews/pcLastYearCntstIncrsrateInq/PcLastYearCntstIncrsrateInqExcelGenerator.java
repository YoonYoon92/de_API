package com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq;

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

import com.saydept.api.spf.saleNews.pcLastYearCntstIncrsrateInq.model.PcLastYearCntstIncrsrateInqModel;

public class PcLastYearCntstIncrsrateInqExcelGenerator {
   public static ByteArrayInputStream toExcel(List<PcLastYearCntstIncrsrateInqModel> reportModels) throws IOException {
      String[] COLUMNs = { "코너번호", "코너명", "전년목표", "전년실적","전년건수","전년할인","전년달성율","당년목표", "당년실적","당년건수","당년할인","당년달성율","신장율" };
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
         for (PcLastYearCntstIncrsrateInqModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);
            //코너번호
            row.createCell(0).setCellValue(reportModel.getConer());
            //코너명
            row.createCell(1).setCellValue(reportModel.getConerNm());
                   
            //전년목표
            Cell LastyearTry = row.createCell(2);
            LastyearTry.setCellValue(reportModel.getLastyearTry());
            LastyearTry.setCellStyle(intCellStyle);
            //전년실적
            Cell LastyearSplan = row.createCell(3);
            LastyearSplan.setCellValue(reportModel.getLastyearSplan());
            LastyearSplan.setCellStyle(intCellStyle);
            //전년건수
            Cell LastyearCo = row.createCell(4);
            LastyearCo.setCellValue(reportModel.getLastyearCo());
            LastyearCo.setCellStyle(intCellStyle);
            //전년할인
            Cell LastyearDcnt = row.createCell(5);
            LastyearDcnt.setCellValue(reportModel.getLastyearDcnt());
            LastyearDcnt.setCellStyle(intCellStyle);
            //전년달성율
            row.createCell(6).setCellValue(reportModel.getLastyearAchivmentrate());
            //당년목표
            Cell Try = row.createCell(7);
            Try.setCellValue(reportModel.getTry());
            Try.setCellStyle(intCellStyle);
            //당년실적
            Cell Splan = row.createCell(8);
            Splan.setCellValue(reportModel.getSplan());
            Splan.setCellStyle(intCellStyle);
            //당년건수
            Cell Co = row.createCell(9);
            Co.setCellValue(reportModel.getCo());
            Co.setCellStyle(intCellStyle);
            //당년할인
            Cell Dcnt = row.createCell(10);
            Dcnt.setCellValue(reportModel.getDcnt());
            Dcnt.setCellStyle(intCellStyle);
            //당년달성율
            row.createCell(11).setCellValue(reportModel.getAchivmentrate());
            //당년신장율
            row.createCell(12).setCellValue(reportModel.getIncrsrate());
         }
         

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}