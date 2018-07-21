package com.asia.common.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨平
 * @created 2018-03-21
 */
public class ExcelRows {
   List<ExcelCols> colses;

    public List<ExcelCols> getColses() {
        return colses;
    }

    public void setColses(List<ExcelCols> colses) {
        this.colses = colses;
    }
    public void addColses(ExcelCols excelCols){
        if(colses==null){
            colses=new ArrayList<ExcelCols>();
        }
        colses.add(excelCols);

    }
}
