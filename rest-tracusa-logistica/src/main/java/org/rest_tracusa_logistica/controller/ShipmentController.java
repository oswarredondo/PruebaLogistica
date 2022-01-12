package org.rest_tracusa_logistica.controller;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.castor.util.Base64Decoder;
import org.rest_tracusa_logistica.db.Connect;
import org.rest_tracusa_logistica.db.ShipmentDB;
import org.rest_tracusa_logistica.db.UserKeyDB;
import org.rest_tracusa_logistica.struct.Guide;
import org.rest_tracusa_logistica.struct.UserKey;
import org.springframework.util.Base64Utils;

import com.innovargia.utils.Files;

public class ShipmentController {

	public ArrayList<Guide> getShipmentByDate(String fInicio, String fFin, String idClient ) throws Exception{
		return ShipmentDB.getShipmentByDateDB(fInicio, fFin, idClient, new Connect());
	}
	
	public ArrayList<Guide> getShipmentByID(String idGuide, String idClient ) throws Exception{
		return ShipmentDB.getShipmentByIDDB(idGuide, idClient, new Connect());
	}
	
	public ArrayList<Guide> getShipmentTrackingByID(String idGuide, UserKey userKey ) throws Exception{
		return ShipmentDB.getShipmentTrackingByIDDB(idGuide, userKey, new Connect());
	}
	
	public boolean isNoShipmentClient(String idGuide, UserKey userKey ) throws Exception{
		return ShipmentDB.isNoShipmentClientDB(idGuide, userKey, new Connect());
	}
	
	public Guide getShipmentPOD(String idGuide, UserKey userKey) throws Exception{	
		Guide guide = ShipmentDB.getShipmentPODDB(idGuide, userKey, new Connect());
		PDDocument doc = null;
		PDPage myPage = null;
		PDPageContentStream cont = null;
		
		try{
			if(guide == null || !guide.getDelivery().isSuccess())
				return null;
				
			doc = new PDDocument();
			myPage = new PDPage();
            doc.addPage(myPage);

            try{
            	cont = new PDPageContentStream(doc, myPage);
            	PDFont font = PDType1Font.HELVETICA;
            	PDRectangle mediabox = myPage.getMediaBox();
            	float margin = 72;
            	float width = mediabox.getWidth() - 2 * margin;
            	float startX = mediabox.getLowerLeftX() + margin;
            	float startY = mediabox.getUpperRightY() - 150;
            	
                cont.beginText();
                cont.setFont(font, 10);
                cont.setLeading(14.5f);

                cont.newLineAtOffset(startX, startY);
                //cont.newLineAtOffset(25, 700);
                
                String line1 = "Estimado cliente: ";
                cont.showText(line1);
                cont.newLine();
                cont.newLine();
                
                String line2 = "Tracusa agradece su preferencia. A continuación, encontrará el comprobante de entrega de su envío:";
                cont.showText(line2);
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();

                String line3 = "Numero de Guia: " + (guide.getIdGuide() == null ? "" : guide.getIdGuide());
                cont.showText(line3.trim());
                cont.newLine();
                cont.newLine();
                cont.newLine();

                String line4 = "Fecha de entrega: "  + (guide.getDelivery().getDeliveryDate() == null ? "" : guide.getDelivery().getDeliveryDate());
                cont.showText(line4.trim());
                cont.newLine();
                cont.newLine();
                cont.newLine();
                
                String line5 = "Recibió: "  + (guide.getDelivery().getSignedBy() == null ? "" : guide.getDelivery().getSignedBy().replace("\n", " "));
                cont.showText(line5.trim());
                cont.newLine();
                cont.newLine();
                cont.newLine();
                
                String line6 = "Referencia: "  + (guide.getReference() == null ? "" : guide.getReference());
                cont.showText(line6.trim());
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();
                
                String line7 = "Firma de Recibido: ";
                cont.showText(line7);
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();
                cont.newLine();
                
                String line8 = "Atentamente";
                float titleWidth = font.getStringWidth(line8) / 1000 * 12;
                float startXX = (width - titleWidth) / 2;
                cont.newLineAtOffset(startXX, -20);
                cont.showText(line8);
                cont.newLine();
                cont.newLine();
                
                String line9 = "Tracusa La Ruta Del Sol S.A de C.V.";
                titleWidth = font.getStringWidth(line9) / 1000 * 12;
                startXX = ((titleWidth - width) / 2) + 79;
                //startXX = startXX + 79;
                cont.newLineAtOffset(startXX, 0);
                cont.showText(line9);
                cont.newLine();
                cont.newLine();
                cont.newLine();
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                Date date = new Date();    
                
                startXX = startXX + startXX - 30;
                cont.newLineAtOffset(startXX, 0);
                String line10 = "Documento de rastreo: " + formatter.format(date);
                cont.showText(line10);
                cont.newLine();
                cont.newLine();
                
                cont.endText();
                
                PDImageXObject pdImageLogo = PDImageXObject.createFromFile("/opt/adminsales/tmppods/logo_tracusa.png", doc);
                int iwLogo = pdImageLogo.getWidth() / 2;
                int ihLogo = pdImageLogo.getHeight() / 2;
                float offsetXLogo = 72;
                float offsetYLogo = 680;
                cont.drawImage(pdImageLogo, offsetXLogo, offsetYLogo, iwLogo, ihLogo);
                
                if(guide.getDelivery().isSignature()){
                	String path = "/opt/adminsales/tmppods/imagePOD.png";
                    BufferedImage  image = decodeToImage(guide.getDelivery().getImageSignature());
                    File imgFile = new File(path);    
                    ImageIO.write(image, "png", imgFile);
                    
                    PDImageXObject pdImage = PDImageXObject.createFromFile(path, doc);
                    int iw = pdImage.getWidth() / 3;
                    int ih = pdImage.getHeight() / 3;
                    float offsetX = 179.98f;
                    float offsetY = 250f;
                    cont.drawImage(pdImage, offsetX, offsetY, iw, ih);
                }
                
                cont.close();
            }catch (Exception e) {
            	throw new Exception(e.getMessage());
			}

            doc.save("/opt/adminsales/tmppods/pod.pdf");
            doc.close();
            
            byte[] bytes = null;
			File filePDF = new File("/opt/adminsales/tmppods/pod.pdf");
			if(!filePDF.exists()){
		    	throw new Exception();
			}
			bytes = Files.getBytesFromFile(filePDF);
			String encodedPDFString = Base64Utils.encodeToString(bytes);
			
			String idGuia = guide.getIdGuide();
			guide = new Guide();
			guide.setIdGuide(idGuia);
			guide.setFile(encodedPDFString);
			
        }catch (Exception e) {
    		throw new Exception(e.getMessage());
		}finally {
			doc = null;
			myPage = null;
			cont = null;
		}
		
		return guide;
	}
	
	public static BufferedImage decodeToImage(String imageString) throws Exception {
		 
        BufferedImage image = null;
        byte[] imageByte;
        try {
            Base64Decoder decoder = new Base64Decoder();
            imageByte = decoder.decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
        	throw new Exception(e.getMessage());
        }
        return image;
    }
}
