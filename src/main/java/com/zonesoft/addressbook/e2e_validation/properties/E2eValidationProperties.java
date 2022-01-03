package com.zonesoft.addressbook.e2e_validation.properties;

import static com.zonesoft.addressbook.e2e_validation.constants.Constants.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.zonesoft.addressbook.e2e_validation.exceptions.AddressBookE2eException;

public class E2eValidationProperties {
	private static final Logger LOGGER = Logger.getLogger(E2eValidationProperties.class);
	private final Properties properties = new Properties();

	public E2eValidationProperties()  {
		super();
		loadProperties(PROPERTIES_FILE);
	}

	public E2eValidationProperties(String filename) {
		super();
		loadProperties(filename);
	}

	private void loadProperties(String filename) {
		InputStream input = null;
		try {
			input = openPropertiesFile(filename);
			properties.load(input);
			LOGGER.info(PROPERTY_BASE_URL + " = " + properties.getProperty(PROPERTY_BASE_URL));
		} catch (IOException e) {
			String message = "Failed to load data from inputstream opened on file " + filename;
			LOGGER.error(message);
			e.printStackTrace();
			throw new AddressBookE2eException(message, e);
		} finally {
			try {
				if (Objects.nonNull(input)) input.close();
			} catch (IOException e) {
				String message = "Failed to close inputstream opened on file " + filename;
				LOGGER.error(message);
				e.printStackTrace();
			}
		}
	}

	private InputStream openPropertiesFile(String propertiesFilename) {
		InputStream inputStream = E2eValidationProperties.class.getClassLoader().getResourceAsStream(propertiesFilename);
		if (Objects.isNull(inputStream)) {
			String fileNotFoundErrorMessage = "Error trying to read " + propertiesFilename
					+ ". Check this file is in the classpath";
			LOGGER.error(fileNotFoundErrorMessage);
			FileNotFoundException exception = new FileNotFoundException(fileNotFoundErrorMessage);
			exception.printStackTrace();
			throw new AddressBookE2eException(exception);
		}
		return inputStream;
	}

	public String getBaseUrl() {
		return properties.getProperty(PROPERTY_BASE_URL);
	}
}
