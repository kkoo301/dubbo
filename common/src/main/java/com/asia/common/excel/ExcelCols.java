package com.asia.common.excel;

/**
 * @author 杨平
 * @created 2018-03-21
 */
public class ExcelCols {
    //标题
    String title;
    //所属列位置
    int index;
    //值
    String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
