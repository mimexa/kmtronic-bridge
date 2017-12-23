package lu.maxime.kmtronicbridge.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import lu.maxime.kmtronicbridge.domain.Settings;
import lu.maxime.kmtronicbridge.utils.Constants;

@RestController
@RequestMapping("/files")
public class FileController {

	private static final Logger LOG=LoggerFactory.getLogger(FileController.class);
	
	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public String uploadSettings(@RequestParam("fileupload") MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			byte[] bytes = file.getBytes();
			Settings settings = mapper.readValue(bytes, Settings.class);
			Constants.setSettings(settings);
			LOG.info("Settings has been reset");
			return "Update successful. Please close this window and refresh your session";
		} catch (IOException e) {
			LOG.error(e.getMessage());
			return "Update failed. Please contact the administrator";
		}
	}

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public void downloadSettings(HttpServletResponse response) {
		try {
			String settings = mapper.writeValueAsString(Constants.getSettings());
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(settings.getBytes());
			response.setHeader("Content-Disposition", "attachment; filename=\"settings.json\"");
			response.setContentType("application/json");
			outputStream.flush();
			outputStream.close();
			response.flushBuffer();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
