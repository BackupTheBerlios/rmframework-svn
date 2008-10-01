/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.helper;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifReader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.PropertiesContainer;

import org.apache.log4j.Logger;

/**
 *
 * @author heiko
 */
public class ImageHelper {

    public static Logger logger = Logger.getLogger(ImageHelper.class);
    String imageTempPath;
    String imageName = "00249_20071118_IGP0626.jpg";
    BufferedImage image;

    public ImageHelper() {
        PropertiesContainer properties = (PropertiesContainer) Container.getContainer().getComponent(PropertiesContainer.class);
        imageTempPath = properties.getProperty("server.path.imageTemp");
    }

    public void loadImageData() {
        try {
            /*File file = new File("image.gif");
            image = ImageIO.read(file);
            InputStream is = new BufferedInputStream(new FileInputStream("image.gif"));
            image = ImageIO.read(is);*/


            File jpegFile = new File(imageTempPath + System.getProperty("file.separator") + imageName);
            
            Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
            new ExifReader(jpegFile).extract(metadata);
            Iterator directories = metadata.getDirectoryIterator();
            while (directories.hasNext()) {
                Directory directory = (Directory) directories.next();
                // iterate through tags and print to System.out  
                Iterator tags = directory.getTagIterator();
                while (tags.hasNext()) {
                    Tag tag = (Tag) tags.next(); // use Tag.toString()
                    if (tag.getDirectoryName().equals("Exif")) {
                        //logger.info(tag.getDirectoryName()+" : "+tag.getTagName()+" : "+tag.getTagTypeHex());
                        
                    }
                    System.out.println(tag.getTagTypeHex()+";"+tag.getTagType()+";"+tag.getDirectoryName()+";"+tag.getTagName()+";"+";"+tag.getDescription());
                    
                    //logger.info(tag);
                }
            }



        } catch (MetadataException ex) {
            logger.error(ex, ex);
        } catch (JpegProcessingException ex) {
            
            if (ex.getInnerException() instanceof FileNotFoundException) {
                logger.error("Cannot find file: "+imageTempPath + System.getProperty("file.separator") + imageName);
            } else if (ex.getInnerException() == null) {
                logger.error("File: "+imageTempPath + System.getProperty("file.separator") + imageName+" is not a jpeg file");
            } else {
                logger.info(ex, ex);
                logger.info("Inner exception: "+ex.getInnerException());
            }
            
        } /*catch (IOException ex) {
            logger.error(ex, ex);
        }*/
    }
}
