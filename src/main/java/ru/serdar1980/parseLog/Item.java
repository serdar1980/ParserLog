package ru.serdar1980.parseLog;

import java.util.Calendar;

/**
 * 
 * @author Serdar
 * Одиночный элемент из лога 
 */
public class Item {
	public Item(Calendar timeLog, String className, String method, String id) {
		super();
		this.timeLog = timeLog;
		ClassName = className;
		Method = method;
		Id = id;
	}
	public Calendar getTimeLog() {
		return timeLog;
	}
	public void setTimeLog(Calendar timeLog) {
		this.timeLog = timeLog;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	private Calendar timeLog;
	private String ClassName;
	private String Method;
	private String Id;
}
