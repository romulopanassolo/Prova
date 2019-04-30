package com.prova.repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import com.prova.dto.ResultDto;



public class FileWriterStream {

	private static final String EXTENSION_DAT = ".dat";
	private static final String EXTENSION_DONE = ".done";
	
	
	public void fileWriter(Path path, ResultDto result) {
		
		String nameFile = path.toFile().getName().toString().replace(EXTENSION_DAT,
				EXTENSION_DONE.concat(EXTENSION_DAT));
		String pathName = path.toFile().getParent().toString().replace("\\in", "\\out\\");
		
		try {
			
			File c = new File(String.format("%s%s", pathName, nameFile));
			c.createNewFile();
			FileWriter fiWi = new FileWriter(c.getAbsoluteFile());
			BufferedWriter buWi = new BufferedWriter(fiWi);
			buWi.write(result.toString());
			buWi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
