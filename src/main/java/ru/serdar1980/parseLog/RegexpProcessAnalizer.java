package ru.serdar1980.parseLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Serdar
 * Реализация @see Iprocess использует регулярное выражения для разбора строки. 
 * 
 */

public class RegexpProcessAnalizer implements Iprocess {

	
	
	
	// TODO перенести в конфиг
	private static final String REGEXP = "^(?<time>[\\d-T:,]*) ([a-z]*) \\[(?<class>[a-z]*)\\] (?<direction>[ a-z]*)\\((?<method>[a-z]*):(?<id>\\d*).*";
	private static final String ENTER = "entry with ";
	private static final String DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ss,SSSSSSS";
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
	private Map<String, Queue<Item>> enterToMethod = new HashMap<>();
	private Map<String, Stat> res = new HashMap<>();
	
	/*
	 * (non-Javadoc)
	 * @see ru.serdar1980.parseLog.Iprocess#getResalt()
	 */
	public Map<String, Stat> getResalt() {
		return res;
	}

	/*
	 * (non-Javadoc)
	 * @see ru.serdar1980.parseLog.Iprocess#analizeData(java.lang.String)
	 */
	public void analizeData(String data) {
		Pattern p = Pattern.compile(REGEXP, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(data);
		
		if (m.matches()) {
			
			String className1= m.group("time");
			String className= m.group("class");
			String methodName= m.group("method");
			String id= m.group("id");
			
			String key = new StringBuilder(className).append(methodName).append(id).toString();
			Calendar cal = Calendar.getInstance();
			try {
				cal.setTime(sdf.parse(m.group("time")));
			} catch (ParseException e) {
				System.out.println(String.format("Cann't parse time:%s  from log ", m.group("time")));
			}	
			
			if (m.group("direction").equals(ENTER)) {
				Queue<Item> queueA = enterToMethod.get(key);
				if(queueA == null){
					queueA = new LinkedList<>();
				}
				queueA.add(new Item(cal, className, methodName, id));
				enterToMethod.put(key, queueA);
			} else {
				Queue<Item> queueA = enterToMethod.get(key);
				if(!queueA.isEmpty()){
					Item item = queueA.remove();
					String keyStat = new StringBuilder(className).append(methodName).toString();
					Stat stat =res.get(keyStat);
					long timeWork =cal.getTimeInMillis() - item.getTimeLog().getTimeInMillis();
							
					if(stat !=null){
						if(stat.getMinWorkTime() >timeWork){
							stat.setMinWorkTime(timeWork);
						}
						if(stat.getMaxWorkTime() <timeWork){
							stat.setMaxWorkTime(timeWork);
							stat.setMaxIdWorkTime(id);
						}
						stat.setAllWorkTime(timeWork+stat.getAllWorkTime());
						stat.setCount(stat.getCount()+1);
						res.put(keyStat, stat);
					}else{
					    res.put(keyStat, new Stat(className, methodName, timeWork, timeWork, timeWork, id, 1));
					}
					
				}
			}
		}
		
	}

}
