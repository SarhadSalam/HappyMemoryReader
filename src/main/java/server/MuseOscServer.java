package server;

import analytics.ChannelDifferentiator;
import analytics.SignalDifferentiator;
import analytics.TYPES;
import analytics.signals;
import oscP5.OscMessage;
import oscP5.OscP5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MuseOscServer
{
	
	public static boolean keepRunning = true;
	static MuseOscServer museOscServer;
	
	OscP5 museServer;
	static int recvPort = 5000;
	
	public static void startServer()
	{
		while( keepRunning )
		{
			museOscServer = new MuseOscServer();
			museOscServer.museServer = new OscP5(museOscServer, recvPort);
		}
		if( !keepRunning )
		{
			museOscServer.museServer.stop();
		}
	}
	
	void oscEvent(OscMessage msg)
	{
		if( msg.checkAddrPattern("/muse/eeg") )
		{
			signals.signalProcess(TYPES.EEG, msg);
		}
//		if( msg.checkAddrPattern("/muse/elements/alpha_absolute") )
//		{
//			signals.signalProcess(TYPES.ALPHA, msg);
//		}
//		if( msg.checkAddrPattern("/muse/elements/beta_absolute") )
//		{
//			signals.signalProcess(TYPES.BETA, msg);
//		}
//		if( msg.checkAddrPattern("/muse/elements/theta_absolute") )
//		{
//			signals.signalProcess(TYPES.THETA, msg);
//		}
//		if( msg.checkAddrPattern("/muse/elements/delta_absolute") )
//		{
//			signals.signalProcess(TYPES.DELTA, msg);
//		}
//		if( msg.checkAddrPattern("/muse/elements/gamma_absolute") )
//		{
//			signals.signalProcess(TYPES.GAMMA, msg);
//		}
		
	}
}