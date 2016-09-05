package ru.serdar1980.parseLog;

/**
 * 
 * @author Serdar
 * Объект для хранения статистики собранной при обработке лога 
 */

public class Stat {
	private String className;
	private String methodName;
	
	private long minWorkTime;
	private long maxWorkTime;
	private long allWorkTime;
	private String maxIdWorkTime;
	private int count;
	
	
	public Stat(String className, String methodName, long minWorkTime, long maxWorkTime, long allWorkTime,
			String maxIdWorkTime, int count) {
		super();
		this.className = className;
		this.methodName = methodName;
		this.minWorkTime = minWorkTime;
		this.maxWorkTime = maxWorkTime;
		this.allWorkTime = allWorkTime;
		this.maxIdWorkTime = maxIdWorkTime;
		this.count = count;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public long getMinWorkTime() {
		return minWorkTime;
	}
	public void setMinWorkTime(long minWorkTime) {
		this.minWorkTime = minWorkTime;
	}
	public long getMaxWorkTime() {
		return maxWorkTime;
	}
	public void setMaxWorkTime(long maxWorkTime) {
		this.maxWorkTime = maxWorkTime;
	}
	public long getAllWorkTime() {
		return allWorkTime;
	}
	public void setAllWorkTime(long allWorkTime) {
		this.allWorkTime = allWorkTime;
	}
	public String getMaxIdWorkTime() {
		return maxIdWorkTime;
	}
	public void setMaxIdWorkTime(String maxIdWorkTime) {
		this.maxIdWorkTime = maxIdWorkTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString(){
		//OperationsImpl:getData min 123, max 846, avg 315, max id 22, count 333
		
		return new StringBuilder(className).append(":").append(methodName).append(" ")
					.append("min ").append(minWorkTime).append(", max ").append(maxWorkTime)
					.append(", avg ").append((allWorkTime/count)).append(", max id ").append(maxIdWorkTime)
					.append(", count ").append(count).toString(); 		
	}
}
