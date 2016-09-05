package ru.serdar1980.parseLog;

import java.util.Map;

/**
 * 
 * @author Serdar
 *    Интерфейс обработки и вывода результата 
 */
public interface Iprocess {
	/**
     * 
     * Реализация метода анализа строк из лога. 
     */
	void analizeData(String data);
	
	/**
     * Реализация получения результата обработки лога 
     */
	Map<String, Stat> getResalt();
}
