package icu.xiamu.poi;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 * 官方文档: <a href="https://poi.apache.org/components/spreadsheet/quick-guide.html">...</a>
 */
public class ExcelTest {

    /**
     * New Workbook
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

    /**
     * New Sheet
     * @throws Exception
     */
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

    /**
     * Creating Cells
     * @throws Exception
     */
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
    @Test
    void test04() {

        class User {
            private String username;
            private String password;

            public User(String username, String password) {
                this.username = username;
                this.password = password;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }

        //第一步，创建一个workbook对应一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二部，在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet("用户表一");
        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("用户名");
        cell = row.createCell(1);
        cell.setCellValue("密码");

        //第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
        // 产生要储存的集合
        List<User> users = new ArrayList<>();
        User user1 = new User("admin", "123456");
        User user2 = new User("staff1", "141242");
        User user3 = new User("staff2", "386002");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        for (int i = 0; i < users.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            User user = users.get(i);
            //创建单元格设值
            row1.createCell(0).setCellValue(user.getUsername());
            row1.createCell(1).setCellValue(user.getPassword());
        }

        //将文件保存到指定的位置
        try {
            FileOutputStream fos = new FileOutputStream("user1.xls");
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
