package com.fourall.fourall;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;

public class PhotoMetaData {

	public Metadata getPhotoData(String imgPath) throws ImageProcessingException, IOException {
		File jpegFile = new File(imgPath);
		return ImageMetadataReader.readMetadata(jpegFile);
	}

}
