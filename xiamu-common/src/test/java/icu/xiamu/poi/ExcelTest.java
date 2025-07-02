package icu.xiamu.poi;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 官方文档: <a href="https://poi.apache.org/components/spreadsheet/quick-guide.html">...</a>
 */
public class ExcelTest {

    /**
     * 创建一个 Webbook
     */
    @Test
    void test01() throws IOException {

        try (Workbook wb = new HSSFWorkbook()) {
            try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
                wb.write(fileOut);
            }
        }
        try (Workbook wb1 = new XSSFWorkbook()) {
            try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
                wb1.write(fileOut);
            }
        }
    }

    @Test
    void test02() throws Exception {
        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");
        // Note that sheet name is Excel must not exceed 31 characters
        // and must not contain any of the any of the following characters:
        // 0x0000
        // 0x0003
        // colon (:)
        // backslash (\)
        // asterisk (*)
        // question mark (?)
        // forward slash (/)
        // opening square bracket ([)
        // closing square bracket (])
        // You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
        // for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
        Sheet sheet3 = wb.createSheet(safeName);
        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        }
    }

    @Test
    void test03() throws Exception {
        Workbook wb = new HSSFWorkbook();
        // Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);
        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);
        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        }
    }

    // list写入文件
    // https://blog.csdn.net/EndisenChen/article/details/70766947
}
