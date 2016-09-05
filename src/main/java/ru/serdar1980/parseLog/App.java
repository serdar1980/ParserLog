package ru.serdar1980.parseLog;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * ParseLog точка входа
 *
 */
public class App
{
	
	//TODO перенести в конфиг 
	private static final String PROGRAM_NAME="logParser";
	public static final long METRIC = Calendar.MILLISECOND;
	private static final String FILE_TYPE = "file";
	
	
	private static IParseHandler parserLog =null;
	
	private static Map<String, Stat> res = new HashMap<>();
	private static HelpFormatter formatter = new HelpFormatter();

	
    public static void main( String[] args )
    {
    	
    	Options options = new Options();
    	//options.addOption( "t", "type", true, "Type of parsing example -type file  " );
    	options.addOption( "f", "file-path", true, "Full path to file: example C:/temp/access.log" );
    	CommandLineParser parser = new DefaultParser();
    	try {
			CommandLine cmd = parser.parse( options, args);
			//if( cmd.hasOption( "t" ) ) {
				if(cmd.hasOption( "f" ) ){
					parserLog = new FileParseHandler(new File(cmd.getOptionValue("f")));
					res = parserLog.parse(new RegexpProcessAnalizer());
				}else{
					throw new  LogIllegalArgumentExecption("Can't find path in args");
				}
				
			//}else{
			//	throw new  LogIllegalArgumentExecption("Can't find type parsing in ags");
			//}
			Object[] keys = res.keySet().toArray();
			for(Object key : keys){
				System.out.println(res.get(key));
			}
			
		} catch (ParseException|LogIllegalArgumentExecption e) {
			formatter.printHelp(PROGRAM_NAME, options, true);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }
}
