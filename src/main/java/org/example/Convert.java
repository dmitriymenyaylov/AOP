package org.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
@Data
@Component
public class Convert {
    PdfPTable table = new PdfPTable(2);
    PdfPCell cell1 = new PdfPCell(new Paragraph("Id"));
    PdfPCell cell2 = new PdfPCell(new Paragraph("String"));
    public void convertToPdf(String s)  {

        Document document = new Document();
        s = s.replaceAll("[\\[\\]]", "");
        String[] words =s.split(",");
        Integer count = 1;

        try {
            BaseFont bf=BaseFont.createFont("/Users/dunice/IdeaProjects/StarterMaven/src/main/resources/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font=new Font(bf,10,Font.NORMAL);

            PdfWriter.getInstance(document,
                    new FileOutputStream("TableWithStrings.pdf"));
            document.open();
            PdfPTable table = new PdfPTable(2);
            PdfPCell cell1 = new PdfPCell(new Paragraph("Id"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("String"));
            table.addCell(cell1);
            table.addCell(cell2);
            for (String word : words) {
                PdfPCell cell3 = new PdfPCell(new Paragraph(count.toString(),font));
                PdfPCell cell4 = new PdfPCell(new Paragraph(word,font));
                table.addCell(cell3);
                table.addCell(cell4);
                count ++;
            }
            document.add(table);
            document.close();
        } catch(Exception e){
        }
    }
}
