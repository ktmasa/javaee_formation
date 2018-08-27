package com.courtalon.thirdBootForm.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// injectable dans d'autre bean spring
@Component
public class FileStorageManager {

	@Value("${repertoire.stockage}") // récuperer une valeur depuis application.properties
	private File storageRoot; // repertoire racine ou stocker les fichiers
	
	private Random rd = new Random();
	
	// sauvegarder un fichier --> renverra son nom
	public String saveFile(InputStream data) {
		// verifier si le repertoire de base est utilisable
		if (storageRoot == null || !storageRoot.exists() || !storageRoot.isDirectory()) {
			throw new RuntimeException("storage root invalide");
		}
		
		String name = rd.nextLong() + "#" + LocalDateTime.now().getNano();
		// genere un hash avec le nom aleatoire
		String shaName = DigestUtils.sha1Hex(name);
		System.out.println("nom fichier sauvegardé : " + shaName);
		
		// sous repertoire avec les 2 premiers caracteres
		String sousRep = shaName.substring(0, 2);
		
		// recupérer le chemin correspondant
		File rep = Paths.get(storageRoot.getAbsolutePath(), sousRep).toFile();
		if (!rep.exists())
			rep.mkdirs(); // creer le répertoire s'il n'existe pas
		
		
		try {
			// copier le fichier sous le nouveau nom
			Files.copy(	data,
						Paths.get(rep.getAbsolutePath(), shaName),
						StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("impossible de sauver le fichier", e);
		}
		return shaName;
	}
	
	public Optional<File> readFile(String storageName) {
		// verifier si le repertoire de base est utilisable
		if (storageRoot == null || !storageRoot.exists() || !storageRoot.isDirectory()) {
			throw new RuntimeException("storage root invalide");
		}
		// sous repertoire avec les 2 premiers caracteres
		String sousRep = storageName.substring(0, 2);
		File rep = Paths.get(storageRoot.getAbsolutePath(), sousRep).toFile();
		if (rep.exists() && rep.isDirectory()) {
			// le fichier qui nous intéresse
			File f = Paths.get(rep.getAbsolutePath(), storageName).toFile();
			if (f.exists() && f.isFile()) {
				return Optional.of(f);
			}
		}
		return Optional.empty();
	}
	
}
