package com.asia.common.excel;


/**
 *
 */

import com.ai.common.util.FtpUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨平
 * @created 2018-03-21
 */
public   class ReadExcel {

    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

    public static final String POINT = ".";

    public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
    public static final String PROCESSING = "Processing...";



    /**
     * read the Excel file
     * @param path the path of the Excel file
     *    @param         iscontalTitle 是否包含标题
     * @return
     * @throws IOException
     */
    public static Map<String,List<ExcelRows>> readExcel(FtpUtil ftpUtil, String path, boolean iscontalTitle) throws Exception {
        if (path == null || "".equals(path)) {
            return null;
        } else {
            String postfix = getPostfix(path);
            if (!"".equals(postfix)) {
                if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(ftpUtil,path,iscontalTitle);
                } else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(ftpUtil,path,iscontalTitle);
                }
            } else {
                System.out.println(path + NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    /**
     * Read the Excel 2003-2007
     * path 路径
     * iscontalTitle 是否包含标题
     * @return
     * @throws IOException
     */
    public static Map<String,List<ExcelRows>> readXls(FtpUtil ftpUtil, String path, boolean iscontalTitle) throws Exception {
        Map<String,List<ExcelRows>> sheetMap=new LinkedHashMap<String, List<ExcelRows>>();
        InputStream is=null;
        try {
            if(null==ftpUtil){
                ftpUtil=new FtpUtil("CUST_GROUP_FILE_FTP");
            }
            is = ftpUtil.readRemote(path);
            if(is==null){
                return sheetMap;
            }
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            // Read the Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                List<ExcelRows> list = new ArrayList<ExcelRows>();
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null||hssfSheet.getLastRowNum()==0) {
                    continue;
                }

                //第一行的总列数
                HSSFRow firstxssfRow = hssfSheet.getRow(0);
                //获取总列数
                int columnNum=firstxssfRow.getPhysicalNumberOfCells();
                //处理空行
                deleteShilt2003(hssfSheet);
                // Read the Row
                for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    if(iscontalTitle&rowNum==0){
                        continue;
                    }

                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        ExcelRows   excelRow = new ExcelRows();
                        HSSFCell firstxSSFCell = hssfRow.getCell(0);
                        if(firstxSSFCell==null){
                            continue;
                        }
                        for(int  i=0;i<columnNum;i++ ){
                            HSSFCell hSSFCell = hssfRow.getCell(i);
                            hSSFCell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            ExcelCols excelCols=new ExcelCols();
                            excelCols.setIndex(i);
                            excelCols.setValue(getValue(hSSFCell));
                            if(iscontalTitle){
                                setCellTitleForHSSFCell(excelCols, hssfSheet.getRow(0).getCell(i));
                            }
                            excelRow.addColses(excelCols);
                        }
                        list.add(excelRow);

                    }
                }
                sheetMap.put("sheet"+numSheet,list);
            }
           /* ftpUtil.completePendingCommand();
            ftpUtil.moveFileToRemoteHisDir(path);*/
        }catch (Exception e){
            e.printStackTrace();
        }finally{
           /* if (ftpUtil != null) {
                ftpUtil.close();
            }*/
            if(is!=null){
                is.close();
            }
        }
        return sheetMap;
    }
    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * path 路径
     * iscontalTitle 是否包含标题
     * @return
     * @throws IOException
     */
    public static Map<String,List<ExcelRows>> readXlsx(FtpUtil ftpUtil, String path, boolean iscontalTitle) throws Exception {
        XSSFWorkbook xssfWorkbook = null;
        InputStream is=null;
        Map<String,List<ExcelRows>> sheetMap=new LinkedHashMap<String, List<ExcelRows>>();
        try {
            //InputStream is = new FileInputStream(path);
            if(null==ftpUtil){
                ftpUtil=new FtpUtil("CUST_GROUP_FILE_FTP");
            }
            is = ftpUtil.readRemote(path);
            if(is==null){
                return sheetMap;
            }
            xssfWorkbook = new XSSFWorkbook(is);
            // Read the Sheet
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                List<ExcelRows> list = new ArrayList<ExcelRows>();
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null||xssfSheet.getLastRowNum()==0) {
                    continue;
                }
              /*  int max=xssfSheet.getLastRowNum();
                xssfSheet.shiftRows(1, max, -1);*/
                //第一行的总列数
                XSSFRow firstxssfRow = xssfSheet.getRow(0);
                //获取总列数
                int columnNum=firstxssfRow.getPhysicalNumberOfCells();

                //处理空行
                deleteShilt2010(xssfSheet);

                // Read the Row
                for (int rowNum = 0; rowNum <=xssfSheet.getLastRowNum(); rowNum++) {
                    if(iscontalTitle&rowNum==0){
                        continue;
                    }
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        ExcelRows   excelRow = new ExcelRows();
                        XSSFCell firstxSSFCell = xssfRow.getCell(0);
                        if(firstxSSFCell==null){
                            continue;
                        }
                        for(int  i=0;i<columnNum;i++ ){
                            ExcelCols excelCols=new ExcelCols();
                            XSSFCell xSSFCell = xssfRow.getCell(i);
                            xSSFCell.setCellType(XSSFCell.CELL_TYPE_STRING);
                            excelCols.setIndex(i);
                            excelCols.setValue(getValue(xSSFCell));
                            if(iscontalTitle){
                                setCellTitleForXSSFCell(excelCols,xssfSheet.getRow(0).getCell(i));
                            }
                            excelRow.addColses(excelCols);

                        }

                        list.add(excelRow);
                    }
                }
                sheetMap.put("sheet"+numSheet,list);
            }
           /* ftpUtil.completePendingCommand();
            ftpUtil.moveFileToRemoteHisDir(path);*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            /*if (ftpUtil != null) {
                ftpUtil.close();
            }*/
            if(is!=null){
                is.close();
            }
        }
        return sheetMap;
    }

    /**
     * 处理空行
     * @param sheet
     */
    public static void deleteShilt2010(XSSFSheet sheet){
        CellReference cellReference = new CellReference("A4");
        boolean flag = false;
        System.out.println("处理之前的总行数："+(sheet.getLastRowNum()+1));
        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum();) {
            Row r = sheet.getRow(i);
            if(r == null){
                // 如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
                sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
                continue;
            }
            flag = false;
            for(Cell c:r){
                if(c.getCellType() != Cell.CELL_TYPE_BLANK){
                    flag = true;
                    break;
                }
            }
            if(flag){
                i++;
                continue;
            }
            else{//如果是空白行（即可能没有数据，但是有一定格式）
                if(i == sheet.getLastRowNum())//如果到了最后一行，直接将那一行remove掉
                    sheet.removeRow(r);
                else//如果还没到最后一行，则数据往上移一行
                    sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
            }
        }
        System.out.println("处理之后的总行数："+(sheet.getLastRowNum()+1));
    }

    /**
     * 处理空行
     * @param sheet
     */
    public static void deleteShilt2003(HSSFSheet sheet){
        CellReference cellReference = new CellReference("A4");
        boolean flag = false;
        System.out.println("处理之前的总行数："+(sheet.getLastRowNum()+1));
        for (int i = cellReference.getRow(); i <= sheet.getLastRowNum();) {
            Row r = sheet.getRow(i);
            if(r == null){
                // 如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动
                sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
                continue;
            }
            flag = false;
            for(Cell c:r){
                if(c.getCellType() != Cell.CELL_TYPE_BLANK){
                    flag = true;
                    break;
                }
            }
            if(flag){
                i++;
                continue;
            }
            else{//如果是空白行（即可能没有数据，但是有一定格式）
                if(i == sheet.getLastRowNum())//如果到了最后一行，直接将那一行remove掉
                    sheet.removeRow(r);
                else//如果还没到最后一行，则数据往上移一行
                    sheet.shiftRows(i+1, sheet.getLastRowNum(),-1);
            }
        }
        System.out.println("处理之后的总行数："+(sheet.getLastRowNum()+1));
    }

    //获取每一列的标题
    public  static ExcelCols  setCellTitleForXSSFCell(ExcelCols excelCols, XSSFCell titleXSSFCell){
        excelCols.setTitle(getValue(titleXSSFCell));
        return excelCols;
    }
    //获取每一列的标题
    public  static ExcelCols  setCellTitleForHSSFCell(ExcelCols excelCols, HSSFCell titleXSSFCell){
        excelCols.setTitle(getValue(titleXSSFCell));
        return excelCols;
    }


    @SuppressWarnings("static-access")
    private static String getValue(XSSFCell xssfRow) {
        if(xssfRow==null){
            return null;
        }
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }
    public static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
                return false;
        }
        return true;
    }
    @SuppressWarnings("static-access")
    private static String getValue(HSSFCell hssfCell) {
        if(hssfCell==null){
            return null;
        }
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    /**
     * get postfix of the path
     * @param path
     * @return
     */
    public static String getPostfix(String path) {
        if (path == null || "".equals(path.trim())) {
            return "";
        }
        if (path.contains(POINT)) {
            return path.substring(path.lastIndexOf(POINT) + 1, path.length());
        }
        return "";
    }

    public static void main(String[] args)  {
        try{
            //Map<String,List<ExcelRows>> sheetMap= ReadExcel.readExcel("C:/kk.xls", true);
            System.out.print("--");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
