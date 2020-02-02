package by.kononov.parsing.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.Part;

import by.kononov.parsing.exception.CustomException;
import by.kononov.parsing.validator.FileValidator;
import by.kononov.parsing.validator.XmlValidator;

public class UploadCommandLogic{
	private static final String UPLOAD_DIRECTORY = "d:\\uploads\\xml";
	private static final String XSD_SCHEMA = "default";
	private static final String ERROR_TEXT = "file xml is not valid by schema: ";

	private UploadCommandLogic() {
		super();
	}

	public static String receiveFileName(Part part) throws IOException, CustomException {
		String fileName = receiveDirectory() + receiveRandomFileName(part);
		if (!FileValidator.isFile(fileName) && !XmlValidator.isValidateBySchema(fileName, XSD_SCHEMA)) {
			throw new CustomException(ERROR_TEXT + XSD_SCHEMA);
		}
		return fileName;
	}

	private static String receiveDirectory() {
		String uploadFileDirectory = UPLOAD_DIRECTORY + File.separator;
		File fileSaveDirectory = new File(uploadFileDirectory);
		if (!fileSaveDirectory.exists()) {
			fileSaveDirectory.mkdirs();
		}
		return uploadFileDirectory;
	}

	private static String receiveRandomFileName(Part part) throws IOException {
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String randFilename = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf('.'));
		part.write(receiveDirectory() + randFilename);
		return randFilename;
	}
}