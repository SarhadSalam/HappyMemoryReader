package analytics;

import oscP5.OscMessage;
import server.MuseOscServer;

import java.util.ArrayList;

/**
 * Class Details:- Author: Sarhad User: sarha Date: 16-Sep-17 Time : 12:01 PM Project Name: hackTheNorth Class Name:
 * signals
 */
public class signals
{
	
	public static ArrayList<ChannelDifferentiator> list = new ArrayList<ChannelDifferentiator>();
	public static ArrayList<SignalDifferentiator> signalDifferentiators = new ArrayList<>();
	
	public static ArrayList<SignalDifferentiator> signalProcess(TYPES types, OscMessage msg)
	{
		while( list.size()<500000 )
		{
			ArrayList<ChannelDifferentiator> eeg, alpha, beta, gamma, theta, delta;
			SignalDifferentiator sd = new SignalDifferentiator();
			if( types.toString().equalsIgnoreCase("eeg") )
			{
				eeg = processEeg(msg);
				list=eeg;
				sd.setEeg(eeg);
				signalDifferentiators.add(sd);
			}
//			if( types.toString().equalsIgnoreCase("alpha") )
//			{
//				alpha = processEeg(msg);
//				sd.setAlpha(alpha);
//				signalDifferentiators.add(sd);
//			}
//			if( types.toString().equalsIgnoreCase("beta") )
//			{
//				beta = processEeg(msg);
//				sd.setBeta(beta);
//				signalDifferentiators.add(sd);
//			}
//			if( types.toString().equalsIgnoreCase("gamma") )
//			{
//				gamma = processEeg(msg);
//				sd.setGamma(gamma);
//				signalDifferentiators.add(sd);
//			}
//			if( types.toString().equalsIgnoreCase("theta") )
//			{
//				theta = processEeg(msg);
//				sd.setTheta(theta);
//				signalDifferentiators.add(sd);
//			}
//			if( types.toString().equalsIgnoreCase("delta") )
//			{
//				delta = processEeg(msg);
//				sd.setDelta(delta);
//				signalDifferentiators.add(sd);
//			}
		}
		MuseOscServer.keepRunning=false;
		
		return signalDifferentiators;
	}
	
	private static ArrayList<ChannelDifferentiator> processEeg(OscMessage msg)
	{
		ChannelDifferentiator channelDifferentiator = new ChannelDifferentiator();
		
		channelDifferentiator.setFreqChannel1(msg.get(0).floatValue());
		channelDifferentiator.setFreqChannel2(msg.get(1).floatValue());
		channelDifferentiator.setFreqChannel3(msg.get(2).floatValue());
		channelDifferentiator.setFreqChannel4(msg.get(3).floatValue());
		list.add(channelDifferentiator);
		System.out.println(list.size());
		
		return list;
		
	}
	
}
