package com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts;

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
import com.saydept.api.spf.saleNews.conerPlanCntstPerfomSts.model.ConerPlanCntstPerfomStsModel;

public class ConerPlanCntstPerfomStsExcelGenerator {
   public static ByteArrayInputStream toExcel(List<ConerPlanCntstPerfomStsModel> reportModels) throws IOException {
      String[] COLUMNs = { "구분", "일매출목표", "일매출실적", "일달성율","월매출목표", "월매출실적", "월달성율","차액","전년월실적","월신장율","년매출목표", "년매출실적", "년달성율","차액","전년년실적","년신장율"};
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
         for (ConerPlanCntstPerfomStsModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(reportModel.getConer());
            row.createCell(1).setCellValue(reportModel.getConerNm());
          //<<달성율>>//
            //전년
            row.createCell(4).setCellValue(reportModel.getLastyearAchivmentrate());
            //당일     
            row.createCell(7).setCellValue(reportModel.getDdAchivmentrate());
            //당월           
            row.createCell(10).setCellValue(reportModel.getMmAchivmentrate());
            //당년
            row.createCell(13).setCellValue(reportModel.getYyAchivmentrate());
         
          //목표 실적
            //전년목표
            Cell LastyearTry = row.createCell(2);
            LastyearTry.setCellValue(reportModel.getLastyearTry());
            LastyearTry.setCellStyle(intCellStyle);
            //전년실적
            Cell LastyearSplan = row.createCell(3);
            LastyearSplan.setCellValue(reportModel.getLastyearSplan());
            LastyearSplan.setCellStyle(intCellStyle);
            //당일목표
            Cell DdTry = row.createCell(5);
            DdTry.setCellValue(reportModel.getDdTry());
            DdTry.setCellStyle(intCellStyle);
            //당일실적
            Cell DdSplan = row.createCell(6);
            DdSplan.setCellValue(reportModel.getDdSplan());
            DdSplan.setCellStyle(intCellStyle);
            //당월목표
            Cell MmTry = row.createCell(8);
            MmTry.setCellValue(reportModel.getMmTry());
            MmTry.setCellStyle(intCellStyle);
            //당월실적
            Cell MmSplan = row.createCell(9);
            MmSplan.setCellValue(reportModel.getMmSplan());
            MmSplan.setCellStyle(intCellStyle);
            //당년목표
            Cell YyTry = row.createCell(11);
            YyTry.setCellValue(reportModel.getYyTry());
            YyTry.setCellStyle(intCellStyle);
            //당년실적
            Cell YySplan = row.createCell(12);
            YySplan.setCellValue(reportModel.getYySplan());
            YySplan.setCellStyle(intCellStyle);
       
         }

         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
}