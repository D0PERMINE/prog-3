package uebungsveranstaltung3;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

import java.util.Date;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
/**
 * liefert das Entstehungsdatum von Fotos
*/
public class Bilddaten {
	
	/**
	 * gibt das Entstehungsdatum der Datei dateiname zurück
	 * @param dateiname Name einer Datei
	 * @return Das Entstehungsdatum oder null, wenn in der Datei keins gespeichert ist
	 */
	public LocalDate getDatum(String dateiname)
	{
		Metadata metadata;
		Date datum;
		try {
			InputStream file = Bilddaten.class.getClassLoader().getResourceAsStream(dateiname);
			
			metadata = ImageMetadataReader.readMetadata(file);
			ExifSubIFDDirectory directory =     
		            metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
			datum = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
			return datum
				     .toInstant()
				     .atZone(ZoneId.systemDefault())
				     .toLocalDate();
		} catch (Exception e1) {
			e1.printStackTrace();	
			return null;
		}
	}
	/**
 	* liefert das Entstehungsdatum eine Bildes
 	* @param args wird nicht verwendet
	*/
	public static void main(String[] args)
	{
		Bilddaten bd = new Bilddaten();
		System.out.println("Das Bild wurde am " + bd.getDatum("dateiname.jpg") + " erstellt.");

	}

}
