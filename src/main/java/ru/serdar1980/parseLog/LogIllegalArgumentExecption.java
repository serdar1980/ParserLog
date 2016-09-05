package ru.serdar1980.parseLog;

/**
 * 
 * @author Serdar
 * Исключение не корректно переданных аргументов в командной строке. 
 */

public class LogIllegalArgumentExecption extends IllegalArgumentException {

	public LogIllegalArgumentExecption() {
		super();
	}

	public LogIllegalArgumentExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public LogIllegalArgumentExecption(String s) {
		super(s);
	}

	public LogIllegalArgumentExecption(Throwable cause) {
		super(cause);
	}

}
