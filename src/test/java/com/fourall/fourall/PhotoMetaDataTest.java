package com.fourall.fourall;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class PhotoMetaDataTest {

	@Test
	public void shouldCollectPhotoMetaData() throws ImageProcessingException, IOException {
		PhotoMetaData underTest = new PhotoMetaData();
		Metadata testData = underTest.getPhotoData("./src/main/resources/static/photos/IMG_3485.jpg");
		assertThat(testData, is(not(nullValue())));

	}

	@Test
	public void shouldOutPutmetaData() throws ImageProcessingException, IOException {
		PhotoMetaData underTest = new PhotoMetaData();
		Metadata testData = underTest.getPhotoData("./src/main/resources/static/photos/IMG_3485.jpg");
		for (Directory directory : testData.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				System.out.println(tag);
			}
		}
		assertThat(testData, is(not(nullValue())));
	}
}
