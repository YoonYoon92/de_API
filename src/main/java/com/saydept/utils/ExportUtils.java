package com.saydept.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ExportUtils {

	public static void exportPDF(HttpServletResponse response, String filename, String jaspername, Map<String, Object> parameters, List<?> dataList) throws IOException {
		response.setContentType("application/pdf");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename + ".pdf");
		
	    try {
			String sourceFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + jaspername).getAbsolutePath();

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
			JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);

			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	    } catch (Exception e) {
	        e.printStackTrace();
        }
	}
	
	public static void exportCSV(HttpServletResponse response, String filename, List<?> dataList) throws IOException {
		response.setContentType("text/csv");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".csv");
		response.getWriter().write('\ufeff');
		
		if(dataList.isEmpty()) return;

		CSVPrinter csvPrinter = null;

	    try {
			Class<?> thisClass = Class.forName(dataList.get(0).getClass().getName());
	        Field [] fields = thisClass.getDeclaredFields();

			List<String> csvHeaders = new ArrayList<String>();
			for(Field f : fields) {
	        	f.setAccessible(true);
	        	csvHeaders.add(f.getName());
			}
		    csvPrinter = new CSVPrinter(response.getWriter(), CSVFormat.DEFAULT.withHeader(csvHeaders.toArray(new String[0])));

		    for (Object node : dataList) {

	            List<String> csvColumns = new ArrayList<String>();
	            for(Field f : fields) {
		        	f.setAccessible(true);
		        	if (f.get(node) == null) {
		        		csvColumns.add("");
					} else if (f.get(node) instanceof Date) {
						csvColumns.add(f.get(node).toString());
					} else if (f.get(node) instanceof Calendar) {
						csvColumns.add(f.get(node).toString());
					} else if (f.get(node) instanceof Boolean) {
						csvColumns.add(f.get(node).toString());
		            } else if (f.get(node) instanceof Number) {
		            	csvColumns.add(f.get(node).toString());
					} else {
						csvColumns.add(f.get(node).toString());
					}
				}
		        csvPrinter.printRecord(csvColumns);
		    }
        } catch (Exception e) {
	        e.printStackTrace();
        } finally {
	          if(csvPrinter != null) csvPrinter.close();
        }
	}

	public static void exportXLSX(HttpServletResponse response, String filename, List<?> dataList) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".xlsx");
		
		if(dataList.isEmpty()) return;

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			
			Class<?> thisClass = Class.forName(dataList.get(0).getClass().getName());
	        Field [] fields = thisClass.getDeclaredFields();

		    CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("Sheet1");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			int colName = 0;
			for(Field f : fields) {
	        	f.setAccessible(true);
	        	Cell cell = headerRow.createCell(colName++);
				cell.setCellValue(f.getName());
				cell.setCellStyle(headerCellStyle);
			}

			// CellStyle
			CellStyle longCellStyle = workbook.createCellStyle();
			longCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("##,##0"));
			CellStyle doubleCellStyle = workbook.createCellStyle();
			doubleCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("##,##0.00"));

			int rowIdx = 1;
			for (Object node : dataList) {
				Row row = sheet.createRow(rowIdx++);

				int colData = 0;
	            for(Field f : fields) {
		        	f.setAccessible(true);
					Cell dataCell = row.createCell(colData++);
					
					if (f.get(node) == null) {
						dataCell.setCellValue("");
					} else if (f.get(node) instanceof Date) {
						dataCell.setCellValue((Date) f.get(node));
					} else if (f.get(node) instanceof Calendar) {
						dataCell.setCellValue((Calendar) f.get(node));
					} else if (f.get(node) instanceof Boolean) {
						dataCell.setCellValue((Boolean) f.get(node));
		            } else if (f.get(node) instanceof Number) {
		            	if(f.get(node) instanceof Double || f.get(node) instanceof Float)
		            	{
		            		dataCell.setCellStyle(doubleCellStyle);
		            	}
		            	dataCell.setCellValue(((Number) f.get(node)).doubleValue());
					} else {
						dataCell.setCellValue(f.get(node).toString());
					}
				}
		    }

			workbook.write(out);
			response.getOutputStream().write(new ByteArrayInputStream(out.toByteArray()).readAllBytes());
        } catch (Exception e) {
	        e.printStackTrace();
        }
	 }
}
