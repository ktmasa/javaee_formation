package com.courtalon.thirdBootForm.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class ImageFile {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id 								private long id;
										private String storageName;
										private String fileName;
										private String contentType;
	
	public ImageFile(long id, String storageName, String fileName, String contentType) {
		super();
		this.id = id;
		this.storageName = storageName;
		this.fileName = fileName;
		this.contentType = contentType;
	}
	
}
