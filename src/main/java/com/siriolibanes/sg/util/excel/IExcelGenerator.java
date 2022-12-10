package com.siriolibanes.sg.util.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

public interface IExcelGenerator {
    void writeHeader();

    void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style);

    void write();

    void generateExcelFile();
}
