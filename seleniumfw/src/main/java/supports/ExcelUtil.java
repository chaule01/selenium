package supports;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import libraries.Bound;

public class ExcelUtil {
	public static List<Object> getDataFromColumnHandler(final Workbook wb, final String sheetName, final int columnIndex, final Bound<Integer> bound) throws IOException {
		Sheet sheet = getOrThrowSheet(wb, sheetName);
		int begin = bound.getFrom();
		int end = Optional.ofNullable(bound.getTo()).orElseGet(sheet::getLastRowNum) + 1;
		List<Object> data = new ArrayList<>();
		for (int i = begin; i < end; i = bound.getNext(i)) {
			try {
				Cell cell = getOrThrowRow(sheet, i).getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				data.add(getCellValue(cell));
			} catch (IOException e) {
				String message = String.format("rowIndex %d: %s", i, e.getMessage());
				data.add(null);
			}
		}
		return data;
	}

	private static List<Object> getDataFromRowHandler(final Workbook wb, final String sheetName, final int rowIndex, final Bound<Integer> bound) throws IOException {
		Sheet sheet = getOrThrowSheet(wb, sheetName);
		Row row = getOrThrowRow(sheet, rowIndex);
		int begin = bound.getFrom();
		int end = Optional.ofNullable(bound.getTo()).orElseGet(() -> (int) row.getLastCellNum()) + 1;
		List<Object> data = new ArrayList<>();
		for (int i = begin; i < end; i = bound.getNext(i)) {
			Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			data.add(getCellValue(cell));
		}
		return data;
	}

	private static Object getDataFromCellHandler(final Workbook wb, final String sheetName, final int rowIndex, final int columnIndex) throws IOException {
		Sheet sheet = getOrThrowSheet(wb, sheetName);
		Cell cell = getOrThrowRow(sheet, rowIndex).getCell(columnIndex, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
		return getCellValue(cell);
	}

	private static void fillDataToCellHandler(final Workbook wb, final String sheetName, final int rowIndex, final int columnIndex, final Object data) {
		Sheet sheet = getOrCreateSheet(wb, sheetName);
		Cell cell = getOrCreateRow(sheet, rowIndex).getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		setCellValue(cell, data);
	}

	private static void fillDataToRowHandler(final Workbook wb, final String sheetName, final int rowIndex, final Bound<Integer> bound, final List<Object> datas) {
		Sheet sheet = getOrCreateSheet(wb, sheetName);
		Row row = getOrCreateRow(sheet, rowIndex);
		int begin = bound.getFrom();
		int end = Optional.ofNullable(bound.getTo()).orElseGet(() -> datas.size() - 1) + 1;
		int dataIndex = 0;
		for (int i = begin; i < end; i = bound.getNext(i)) {
			Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			setCellValue(cell, datas.get(dataIndex));
			dataIndex++;
		}
	}

	private static void fillDataToColumnHandler(final Workbook wb, final String sheetName, final int columnIndex, final Bound<Integer> bound, final List<Object> datas) {
		Sheet sheet = getOrCreateSheet(wb, sheetName);
		int begin = bound.getFrom();
		int end = Optional.ofNullable(bound.getTo()).orElseGet(() -> datas.size() - 1) + 1;
		int dataIndex = 0;
		for (int i = begin; i < end; i = bound.getNext(i)) {
			Cell cell = getOrCreateRow(sheet, i).getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			setCellValue(cell, datas.get(dataIndex));
			dataIndex++;
		}
	}

	private static void writeWorkbook(final Workbook wb, final String path) throws IOException {
		try(FileOutputStream output = new FileOutputStream(path)){
			wb.write(output);
		}
	}

	private static Sheet getOrCreateSheet(final Workbook wb, final String sheetName) {
		return Optional.ofNullable(wb.getSheet(sheetName)).orElseGet(() -> wb.createSheet(sheetName));
	}

	private static Sheet getOrThrowSheet(final Workbook wb, final String sheetName) throws IOException  {
		return Optional.ofNullable(wb.getSheet(sheetName)).orElseThrow(() -> new IOException("No such sheetName"));
	}

	private static Workbook getOrCreateWorkbook(final String fileSource) throws IOException {
		return Optional.ofNullable(readWorkbook(fileSource)).orElseGet(XSSFWorkbook::new);
	}

	private static Workbook getOrThrowWorkbook(final String fileSource) throws IOException {
		return Optional.ofNullable(readWorkbook(fileSource)).orElseThrow(() -> new IOException("No such file"));
	}

	private static Row getOrCreateRow(final Sheet sheet,final int rowIndex) {
		return Optional.ofNullable(sheet.getRow(rowIndex)).orElseGet(() -> sheet.createRow(rowIndex));
	}

	private static Row getOrThrowRow(final Sheet sheet,final int rowIndex) throws IOException {
		return Optional.ofNullable(sheet.getRow(rowIndex)).orElseThrow(() -> new IOException("No such row"));
	}

	private static String getFileType(final String filePath) {
		if (filePath.endsWith("xlsx")) {
			return "xlsx";
		} else if (filePath.endsWith("xls")) {
			return "xls";
		}
		return "";
	}

	private static void setCellValue(final Cell cell, final Object data) {
		if (data instanceof Number) {
			if (data instanceof BigDecimal) {
				cell.setCellValue(((BigDecimal) data).doubleValue());
			} else if (data instanceof Integer) {
				Integer in = (Integer) data;
				cell.setCellValue(in.doubleValue());
			} else if (data instanceof Long) {
				Long in = (Long) data;
				cell.setCellValue(in.doubleValue());
			} else {
				cell.setCellValue((Double) data);
			}
		} else if (data instanceof String) {
			cell.setCellValue((String) data);
		} else if (data instanceof Date) {
			cell.setCellValue((Date) data);
		} else if (data != null) {
			cell.setCellValue(data.toString());
		}
	}

	private static Object getCellValue(final Cell cell) {
		if(cell == null) return null;
		switch (cell.getCellType()) {
		case NUMERIC:
			return DateUtil.isCellDateFormatted(cell) ? cell.getDateCellValue() : cell.getNumericCellValue();
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		case BLANK:
			return "";
		case ERROR:
		case _NONE:
		default:
			return null;
		}
	}

	public static Workbook readWorkbook(final String fileSource) throws IOException {
		if(StringUtils.isBlank(fileSource)) return null;
		try (InputStream file = new FileInputStream(fileSource)){
			Workbook workbook = null;
			String fileType = getFileType(fileSource);
			if (fileType.equalsIgnoreCase("xlsx") || fileType.equalsIgnoreCase("xls")) {
				workbook = WorkbookFactory.create(file);
			}
			return workbook;
		}
	}

}
