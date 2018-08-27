package com.courtalon.thirdBootForm.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.courtalon.thirdBootForm.metier.ImageFile;
import com.courtalon.thirdBootForm.repositories.ImageFileRepository;
import com.courtalon.thirdBootForm.util.FileStorageManager;

@Controller
@RequestMapping("/imageApi")
public class ImageFileController {

	@Autowired
	private ImageFileRepository imageFileRepository;
	@Autowired
	private FileStorageManager fileStorageManager;
	
//	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/upload",
					method=RequestMethod.POST,
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Object> upload(@RequestParam("image") MultipartFile file) {
		// on ne supporte que les JPG et PNG
		if (!file.getContentType().equals(MediaType.IMAGE_JPEG_VALUE) &&
				!file.getContentType().equals(MediaType.IMAGE_PNG_VALUE)) {
			Map<String, String> result = new HashMap<>();
			result.put("erreur", "seul jpeg et png sont pris en compte");
			return new ResponseEntity<Object>(result, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}
		try {
			// copie effectivement le fichier uploadé dans notre répertoire
			String storageName = fileStorageManager.saveFile(file.getInputStream());
			ImageFile img = new ImageFile(	0,
											storageName,
											file.getOriginalFilename(),
											file.getContentType());
			img = imageFileRepository.save(img);
			return new ResponseEntity<Object>(img, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	// pas de produces=...json  car on renvoie une image, c'est a dire du binaire
	@RequestMapping(value="/download/{id:[0-9]+}",
					method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<FileSystemResource> imageData(@PathVariable("id") long id) {
		ImageFile img = imageFileRepository.findOne(id);
		if (img == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		// on récupere le fichier
		Optional<File> fichier = fileStorageManager.readFile(img.getStorageName());
		if (fichier.isPresent()) {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.parseMediaType(img.getContentType())); // type image
			header.setContentDispositionFormData("attachment", img.getFileName()); // nom fichier
			header.setContentLength(fichier.get().length()); // taille du fichier
			
			return new ResponseEntity<FileSystemResource>(
					new FileSystemResource(fichier.get()),  // contenu du fichier
					header,
					HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
