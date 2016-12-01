/*
 * Salvataggio dati in Excel.
 */
package angelicaproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author gianni
 */
public class salvataggioExcel {

    private static final int numCol = 2;

    public static void salvaData(ArrayList<String> nameArt, int[] countArt, String dateHours) throws FileNotFoundException, IOException {
        Workbook wb = new HSSFWorkbook();
        //Creo foglio Excel 
        Sheet sh = wb.createSheet();

        //Stile gialla
        CellStyle yellow = wb.createCellStyle();
        yellow.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        yellow.setFillBackgroundColor(HSSFColor.YELLOW.index);
        yellow.setFillForegroundColor(HSSFColor.YELLOW.index);
        yellow.setBorderBottom(CellStyle.BORDER_THIN);
        yellow.setBorderLeft(CellStyle.BORDER_THIN);
        yellow.setBorderRight(CellStyle.BORDER_THIN);
        yellow.setBorderTop(CellStyle.BORDER_THIN);
        yellow.setAlignment(CellStyle.ALIGN_CENTER);

        //Stile cella blu
        CellStyle blue = wb.createCellStyle();
        blue.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        blue.setFillBackgroundColor(HSSFColor.BLUE.index);
        blue.setFillForegroundColor(HSSFColor.BLUE.index);
        blue.setBorderBottom(CellStyle.BORDER_THIN);
        blue.setBorderLeft(CellStyle.BORDER_THIN);
        blue.setBorderRight(CellStyle.BORDER_THIN);
        blue.setBorderTop(CellStyle.BORDER_THIN);
        blue.setAlignment(CellStyle.ALIGN_CENTER);



        //Stile cella verde
        CellStyle green = wb.createCellStyle();
        green.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        green.setFillBackgroundColor(HSSFColor.GREEN.index);
        green.setFillForegroundColor(HSSFColor.GREEN.index);
        green.setBorderBottom(CellStyle.BORDER_THIN);
        green.setBorderLeft(CellStyle.BORDER_THIN);
        green.setBorderRight(CellStyle.BORDER_THIN);
        green.setBorderTop(CellStyle.BORDER_THIN);
        green.setAlignment(CellStyle.ALIGN_CENTER);


        //Stile cella Rosso
        CellStyle red = wb.createCellStyle();
        red.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        red.setFillBackgroundColor(HSSFColor.RED.index);
        red.setFillForegroundColor(HSSFColor.RED.index);
        red.setBorderRight(CellStyle.BORDER_THIN);
        red.setAlignment(CellStyle.ALIGN_CENTER);
        red.setBorderBottom(CellStyle.BORDER_THIN);
        red.setBorderLeft(CellStyle.BORDER_THIN);
        red.setBorderRight(CellStyle.BORDER_THIN);
        red.setBorderTop(CellStyle.BORDER_THIN);

        //Stile cella Rosa
        CellStyle pink = wb.createCellStyle();
        pink.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        pink.setFillBackgroundColor(HSSFColor.PINK.index);
        pink.setFillForegroundColor(HSSFColor.PINK.index);
        pink.setBorderRight(CellStyle.BORDER_THIN);
        pink.setAlignment(CellStyle.ALIGN_CENTER);
        pink.setBorderBottom(CellStyle.BORDER_THIN);
        pink.setBorderLeft(CellStyle.BORDER_THIN);
        pink.setBorderRight(CellStyle.BORDER_THIN);
        pink.setBorderTop(CellStyle.BORDER_THIN);

        for (int numRighe = 0; numRighe < nameArt.size() + 2; numRighe++) {

            Row row = sh.createRow(numRighe);
            for (int cellnum = 0; cellnum < numCol; cellnum++) {
                //Casella in alto a sx pos(0,0)  prima riga
                if (numRighe == 0 && cellnum == 0) {
                    Cell cell = row.createCell(cellnum);
                    cell.setCellValue("Essenza - ");
                    cell.setCellStyle(yellow);
                }
                else if(numRighe == 0 && cellnum >= 0){
                    Cell cell = row.createCell(cellnum);
                    cell.setCellValue(dateHours);
                    cell.setCellStyle(yellow);
                }
                
                
                
                
                //Etichette  Nome Articolo e Quantità di Articoli
                if (numRighe == 1 && cellnum >= 0) {
                    Cell cell = row.createCell(cellnum);
                    if (cellnum == 0) {
                        cell.setCellValue("Name Article");
                        cell.setCellStyle(green);
                    } else if (cellnum == 1) {
                        cell.setCellValue("Amount");
                        cell.setCellStyle(red);
                    }

                }

                //  stirnghe nomi e valori quantità
                if (numRighe >= 2 && cellnum >= 0) {

                    //salvo stringhe
                    if (cellnum == 0) {

                        //alternanza colore blue celle dispari
                        if (numRighe % 2 != 0) {
                            Cell cell = row.createCell(cellnum);
                            cell.setCellValue(nameArt.get(numRighe - 2));
                            cell.setCellStyle(blue);

                        } //alternanza colore bianco celle dispari
                        else {
                            Cell cell = row.createCell(cellnum);
                            cell.setCellValue(nameArt.get(numRighe - 2));
                            cell.setCellStyle(pink);
                        }

                    } //salvo quantità
                    else if (cellnum == 1) {

                        //alternanza colore blue celle dispari
                        if (numRighe % 2 != 0) {
                            Cell cell = row.createCell(cellnum);
                            cell.setCellValue(countArt[numRighe - 2]);
                            cell.setCellStyle(blue);

                        } //alternanza colore bianco celle dispari
                        else {
                            Cell cell = row.createCell(cellnum);
                            cell.setCellValue(countArt[numRighe - 2]);
                            cell.setCellStyle(pink);
                        }

                    }

                }

            }
        }

        try ( // Output file
                FileOutputStream out = new FileOutputStream("/home/gianni/Documenti/output/" + dateHours + ".xls")) {
            wb.write(out);
            out.close();
        }

       // System.out.println("File Excel creato correttamente!");

    }

}
