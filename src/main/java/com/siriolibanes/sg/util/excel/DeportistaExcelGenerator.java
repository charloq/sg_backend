package com.siriolibanes.sg.util.excel;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siriolibanes.sg.deportista.model.Deportista;
import com.siriolibanes.sg.deportista.repository.IDeportistaRepository;
import com.siriolibanes.sg.util.Util;

@Service
public class DeportistaExcelGenerator implements IExcelGenerator {

    @Autowired
    private IDeportistaRepository deportistaRepository;

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Deportista> deportistas;
    private static String fileName = "src/main/resources/export/Listado_Deportistas_";
    private static String fileExtension = ".xlsx";

    public DeportistaExcelGenerator() {
        this.workbook = new XSSFWorkbook();
    }

    @Override
    public void writeHeader() {
        this.sheet = workbook.createSheet("Deportistas");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "Deporte", style);
        createCell(row, 2, "Categoría", style);
        createCell(row, 3, "Activo", style);
        createCell(row, 4, "Nombre", style);
        createCell(row, 5, "Apellido", style);
        createCell(row, 6, "DNI", style);
        createCell(row, 7, "Sexo", style);
        createCell(row, 8, "Fecha de Nacimiento", style);
        createCell(row, 9, "Email", style);
        createCell(row, 10, "Teléfono", style);
        createCell(row, 11, "Dirección", style);
        createCell(row, 12, "Ciudad", style);

    }

    @Override
    public void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        this.sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else if (valueOfCell instanceof Timestamp) {
            Date fecha = new Date(((Timestamp) valueOfCell).getTime());
            String value = Util.formatFecha(fecha, "dd/MM/yyyy");
            cell.setCellValue(value);
        } else if (valueOfCell instanceof Boolean) {
            String value = (Boolean) valueOfCell ? "Si" : "No";
            cell.setCellValue(value);
        }
        cell.setCellStyle(style);

    }

    @Override
    public void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Deportista record : deportistas) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId(), style);
            createCell(row, columnCount++, record.getDeporte(), style);
            createCell(row, columnCount++, record.getCategoria(), style);
            createCell(row, columnCount++, record.getActivo(), style);
            createCell(row, columnCount++, record.getNombre(), style);
            createCell(row, columnCount++, record.getApellido(), style);
            createCell(row, columnCount++, record.getDni(), style);
            createCell(row, columnCount++, record.getSexo(), style);
            createCell(row, columnCount++, record.getFechaNacimiento(), style);
            createCell(row, columnCount++, record.getEmail(), style);
            createCell(row, columnCount++, record.getTelefono(), style);
            createCell(row, columnCount++, record.getDireccion(), style);
            createCell(row, columnCount++, record.getCiudad(), style);
        }

    }

    @Override
    public void generateExcelFile() {
        try {
            this.deportistas = deportistaRepository.findAll();
            writeHeader();
            write();
            Date fecha = new Date();
            fileName = fileName + Util.formatFecha(fecha, "ddMMyyyy") + fileExtension;
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
