package com.saydept.api.spf.excel.dayAggregation;

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
import com.saydept.api.spf.excel.dayAggregation.model.DayAggregationModel;


public class DayAggregationExcelGenerator {
   public static ByteArrayInputStream toExcel(List<DayAggregationModel> reportModels) throws IOException {
      String[] COLUMNs = {"구분","매출목표","매출실적","달성율","매출목표","매출실적","달성율","차액","전년실적","신장율","매출목표","매출실적","달성율","차액","전년실적","신장율"};
      
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
         for (DayAggregationModel reportModel : reportModels) {
            Row row = sheet.createRow(rowIdx++);
//"구분","매출목표","매출실적","달성율","매출목표","매출실적","달성율","차액","전년실적","신장율","매출목표","매출실적","달성율","차액","전년실적","신장율"
            //row.createCell(0).setCellValue(reportModel.getPc());
            row.createCell(0).setCellValue(reportModel.getPcNm());
         
          //당일
            //목표
            Cell dayTry = row.createCell(1);
            dayTry.setCellValue(reportModel.getPcDayTry());
            dayTry.setCellStyle(intCellStyle);
            //실적
            Cell daySplan = row.createCell(2);
            daySplan.setCellValue(reportModel.getPcDaySplan());
            daySplan.setCellStyle(intCellStyle);
            //달성율
            row.createCell(3).setCellValue(reportModel.getPcMonthAchivmentrate());
           //당월
            //목표
            Cell monthTry = row.createCell(4);
            monthTry.setCellValue(reportModel.getPcMonthTry());
            monthTry.setCellStyle(intCellStyle);
            //실적
            Cell monthSplan = row.createCell(5);
            monthSplan.setCellValue(reportModel.getPcMonthSplan());
            monthSplan.setCellStyle(intCellStyle);
            //달성율
            row.createCell(6).setCellValue(reportModel.getPcMonthAchivmentrate());
            //차액
            Cell monthDiff = row.createCell(7);
            monthDiff.setCellValue(reportModel.getPcMonthDiff());
            monthDiff.setCellStyle(intCellStyle);
            //전년실적
            Cell lastyearmonthSplan = row.createCell(8);
            lastyearmonthSplan.setCellValue(reportModel.getPcMonthLastyearSplan());
            lastyearmonthSplan.setCellStyle(intCellStyle);
            //신장율
            row.createCell(9).setCellValue(reportModel.getPcMonthIncrsrate());
           //당년
            //목표
            Cell yearTry = row.createCell(10);
            yearTry.setCellValue(reportModel.getPcYearTry());
            yearTry.setCellStyle(intCellStyle);
            //실적
            Cell yearSplan = row.createCell(11);
            yearSplan.setCellValue(reportModel.getPcYearSplan());
            yearSplan.setCellStyle(intCellStyle);
            //달성율
            row.createCell(12).setCellValue(reportModel.getPcYearAchivmentrate());
            //차액
            Cell yearDiff = row.createCell(13);
            yearDiff.setCellValue(reportModel.getPcYearDiff());
            yearDiff.setCellStyle(intCellStyle);
            //전년실적
            Cell lastyearyearSplan = row.createCell(14);
            lastyearyearSplan.setCellValue(reportModel.getPcYearLastyearSplan());
            lastyearyearSplan.setCellStyle(intCellStyle);
            //신장율
            row.createCell(15).setCellValue(reportModel.getPcYearIncrsrate());
         }
      
         workbook.write(out);
         return new ByteArrayInputStream(out.toByteArray());
      }
   }
   
   public static ByteArrayInputStream toExcel2(List<DayAggregationModel> reportModels) throws IOException {
	      String[] COLUMNs = {"존명","존번호","코너","코너번호","당일실적","누계월목표","월목표","월실적","달성율","진도율","전년실적","신장율","전년목표","차액"};
	      
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
	         for (DayAggregationModel reportModel : reportModels) {
	            Row row = sheet.createRow(rowIdx++);
	//"존명","존번호","코너","코너번호","당일실적","월실적","월매출","달성율","진도율","전년실적","신장율","전년목표","차액"
	            //row.createCell(0).setCellValue(reportModel.getPc());
	            row.createCell(0).setCellValue(reportModel.getZoningNm());
	            row.createCell(1).setCellValue(reportModel.getZoning());
	            row.createCell(2).setCellValue(reportModel.getConerNm());
	            row.createCell(3).setCellValue(reportModel.getConer());
	        
	            //일실적
	            Cell daySplan = row.createCell(4);
	            daySplan.setCellValue(reportModel.getPcDaySplan());
	            daySplan.setCellStyle(intCellStyle);
	            //월총목표
	            Cell pcMonthTotalTry = row.createCell(5);
	            pcMonthTotalTry.setCellValue(reportModel.getPcMonthTotalTry());
	            pcMonthTotalTry.setCellStyle(intCellStyle);
	            //월누계목표
	            Cell monthTry = row.createCell(6);
	            monthTry.setCellValue(reportModel.getPcMonthTry());
	            monthTry.setCellStyle(intCellStyle);
	            //월실적
	            Cell monthSplan = row.createCell(7);
	            monthSplan.setCellValue(reportModel.getPcMonthSplan());
	            monthSplan.setCellStyle(intCellStyle);
	            //월달성율
	            row.createCell(8).setCellValue(reportModel.getPcMonthAchivmentrate());
	            //진도율
	            row.createCell(9).setCellValue(reportModel.getPcMonthProgressRate());
	            //전년실적
	            Cell lastyearmonthSplan = row.createCell(10);
	            lastyearmonthSplan.setCellValue(reportModel.getPcMonthLastyearSplan());
	            lastyearmonthSplan.setCellStyle(intCellStyle);
	            //신장율
	            row.createCell(11).setCellValue(reportModel.getPcMonthIncrsrate());
	          	//전년목표
	            Cell lastyearmonthTry= row.createCell(12);
	            lastyearmonthTry.setCellValue(reportModel.getPcMonthLastyearSplan());
	            lastyearmonthTry.setCellStyle(intCellStyle);
	            //차액
	            Cell monthDiff = row.createCell(13);
	            monthDiff.setCellValue(reportModel.getPcMonthDiff());
	            monthDiff.setCellStyle(intCellStyle);
	            
	       
	           
	         }
	      
	         workbook.write(out);
	         return new ByteArrayInputStream(out.toByteArray());
	      }
	   }
   
   public static ByteArrayInputStream toExcel3(List<DayAggregationModel> reportModels) throws IOException {
	      String[] COLUMNs = {"일","요일","목표","실적","달성율","전년실적","신장율"};
	      
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
	         for (DayAggregationModel reportModel : reportModels) {
	            Row row = sheet.createRow(rowIdx++);
	            //""일","요일","목표","실적","달성율","전년실적","신장율"
	            //row.createCell(0).setCellValue(reportModel.getPc());
	            row.createCell(0).setCellValue(reportModel.getDt());
	            row.createCell(1).setCellValue(reportModel.getWeek());
	            
	            
	            //월목표
	            Cell dayTry = row.createCell(2);
	            dayTry.setCellValue(reportModel.getPcDayTry());
	            dayTry.setCellStyle(intCellStyle);
	            //일실적
	            Cell daySplan = row.createCell(3);
	            daySplan.setCellValue(reportModel.getPcDaySplan());
	            daySplan.setCellStyle(intCellStyle);
	            //일달성율
	            row.createCell(4).setCellValue(reportModel.getPcDayAchivmentrate());
	            //전년실적
	            Cell lastyeardaySplan = row.createCell(5);
	            lastyeardaySplan.setCellValue(reportModel.getPcDayLastyearSplan());
	            lastyeardaySplan.setCellStyle(intCellStyle);
	            //신장율
	            row.createCell(6).setCellValue(reportModel.getPcDayIncrsrate());
	     
	            
	       
	           
	         }
	      
	         workbook.write(out);
	         return new ByteArrayInputStream(out.toByteArray());
	      }
	   }
}