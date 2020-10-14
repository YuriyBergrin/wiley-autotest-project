package utils;

import io.restassured.filter.log.UrlDecoder;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * for download files
 */
public class DownLoadManager {

	public boolean isImageDownloaded(String urlToDownload) throws IOException {
		//create new folder for download image
		String downloadFolder = "downloads";
		File outputPath = new File(downloadFolder);
		outputPath.mkdirs();

		String downloadFileName = "image.png";

		Map<String, String> cookies = new HashMap();
		Map<String, String> headers = new HashMap();

		File checkDownloaded = new File(outputPath.getPath(), downloadFileName);
		if (checkDownloaded.exists()) {
			checkDownloaded.delete();
		}

		urlToDownload = UrlDecoder.urlDecode(urlToDownload, Charset.defaultCharset(), false);

		if (checkDownloaded.exists()) {
			checkDownloaded.delete();
		}

		//download image
		DownLoadManager.downloadUrlAsFile(cookies, headers, urlToDownload, outputPath, downloadFileName);

		//assert to check if file exists
		checkDownloaded = new File(outputPath.getPath(), downloadFileName);
		return checkDownloaded.exists();
	}

	public static void downloadUrlAsFile(final Map<String, String> cookies, final Map<String, String> headers,
								   final String urlToDownload, final File outputPath, final String filename) throws IOException {

		File outputFile = new File(outputPath.getPath(), filename);

		final Response response = given().headers(headers).cookies(cookies).when().get(urlToDownload).andReturn();

		// check if the URL actually exists
		if (response.getStatusCode() == 200) {

			// if it already exists you might choose to return and not overwrite it
			if (outputFile.exists()) {
				outputFile.delete();
			}

			// get the contents of the file
			byte[] fileContents = response.getBody().asByteArray();

			OutputStream outStream = null;

			try {

				outStream = new FileOutputStream(outputFile);
				outStream.write(fileContents);

			} catch (Exception e) {

			} finally {

				if (outStream != null) {
					outStream.close();
				}
			}
		}
	}
}
