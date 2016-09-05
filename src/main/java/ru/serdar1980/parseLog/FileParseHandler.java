package ru.serdar1980.parseLog;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * 
 * @author Serdar
 * Реализация @see IParseHandler для получения лога из файла 
 */

public class FileParseHandler implements IParseHandler {

	private File file; 
	
	/**
	 * Конструктор 
	 * @param file -лог файл 
	 */
	public FileParseHandler(File file){
		this.file = file;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ru.serdar1980.parseLog.IParseHandler#parse(ru.serdar1980.parseLog.Iprocess)
	 */
	public Map<String, Stat> parse(Iprocess process) {
		LineIterator it =null;
		try {
			it = FileUtils.lineIterator(file, "UTF-8");
			    while (it.hasNext()) {
			        String line = it.nextLine();
			        process.analizeData(line);
			    }
		} catch (IOException e) {
			System.out.println("parse error "+e.getMessage());
		} finally {
			if(it != null)
				LineIterator.closeQuietly(it);
		}
		return process.getResalt();
		
	}

}
