package ru.serdar1980.parseLog;

import java.util.Map;

/**
 * 
 * @author Serdar
 * Интерфейс получения и передача в обработку лог файла  
 */
public interface IParseHandler {
		
		/**
		 * Метод получение и обработки лога 
		 * @param process - Реализация обработки лога 
		 * @return результат обработки 
		 */
       Map<String, Stat> parse(Iprocess process);
}
