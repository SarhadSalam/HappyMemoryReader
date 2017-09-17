package analytics;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class Details:- Author: Sarhad User: sarha Date: 17-Sep-17 Time : 5:16 AM Project Name: hackTheNorth Class Name:
 * ReadData
 */
public class ReadData
{
	
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		readData();
	}
	
	public static void readData() throws URISyntaxException, IOException
	{
		
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL fileURL = classloader.getResource("models/");
		File[] files = new File(String.valueOf(Paths.get(fileURL.toURI()).toFile())).listFiles();
		showFiles(files);
		
		String name = "average.txt";
		
		ArrayList<Float> sumC1 = new ArrayList<>();
		ArrayList<Float> sumC2 = new ArrayList<>();
		ArrayList<Float> sumC3 = new ArrayList<>();
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter("W:\\hackTheNorth\\src\\main\\resources\\models\\"+name);
		} catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		for( int i = 0; i<signals.dataPoints; i++ )
		{
			float sum1 = channel1.get(i)+channel1.get(i+signals.dataPoints);
			float sum2 = channel2.get(i)+channel2.get(i+signals.dataPoints);
			float sum3 = channel3.get(i)+channel3.get(i+signals.dataPoints);
			writer.println(i+","+sum1+","+sum2+","+sum3);
//			sumC1.add(channel1.get(i)+channel1.get(i+signals.dataPoints));
//			sumC2.add(channel2.get(i)+channel2.get(i+signals.dataPoints));
//			sumC3.add(channel3.get(i)+channel3.get(i+signals.dataPoints));
		}
		writer.close();

//			sumC1 = sumC1+channel1.get(i);
//			sumC2 = sumC2+channel2.get(i);
//			sumC3 = sumC3+channel3.get(i);
// 		System.out.println(sumC1.size());
//		System.out.println(sumC2.size());
//		System.out.println(sumC3.size());
	}
	
	private static void showFiles(File[] files)
	{
		for( File file : files )
		{
			if( file.isDirectory() )
			{
				showFiles(file.listFiles()); // Calls same method again.
			} else
			{
				categorizeData(file);
			}
		}
	}
	
	//Represents the average values.
	private static ArrayList<Float> channel1 = new ArrayList<>();
	private static ArrayList<Float> channel2 = new ArrayList<>();
	private static ArrayList<Float> channel3 = new ArrayList<>();
	
	private static void categorizeData(File files)
	{
		String line = null;
		try
		{
			FileReader fileReader = new FileReader(files);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while( ( line = bufferedReader.readLine() ) != null )
			{
//				System.out.println(line);
				String[] channels = line.split(",");
//				System.out.println(files.getPath());
				channel1.add(Float.valueOf(channels[1]));
				channel2.add(Float.valueOf(channels[2]));
				channel3.add(Float.valueOf(channels[3]));
//				Data is in String[1], [2], [3]
			}
			bufferedReader.close();
		} catch( IOException ex )
		{
			ex.printStackTrace();
		}
		
		saveAverageValue();
	}
	
	private static void saveAverageValue()
	{
	
	}
}
