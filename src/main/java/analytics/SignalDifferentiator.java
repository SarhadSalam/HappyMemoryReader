package analytics;

import java.util.ArrayList;

/**
 * Class Details:- Author: Sarhad User: sarha Date: 16-Sep-17 Time : 4:38 PM Project Name: hackTheNorth Class Name:
 * SignalDifferentiator
 */
public class SignalDifferentiator
{
	private ArrayList<ChannelDifferentiator> eeg;
	private ArrayList<ChannelDifferentiator> alpha;
	private  ArrayList<ChannelDifferentiator> beta;
	private  ArrayList<ChannelDifferentiator> gamma;
	private ArrayList<ChannelDifferentiator> theta;
	private  ArrayList<ChannelDifferentiator> delta;
	
	public ArrayList<ChannelDifferentiator> getEeg()
	{
		return eeg;
	}
	
	public void setEeg(ArrayList<ChannelDifferentiator> eeg)
	{
		this.eeg = eeg;
	}
	
	public ArrayList<ChannelDifferentiator> getAlpha()
	{
		return alpha;
	}
	
	public void setAlpha(ArrayList<ChannelDifferentiator> alpha)
	{
		this.alpha = alpha;
	}
	
	public ArrayList<ChannelDifferentiator> getBeta()
	{
		return beta;
	}
	
	public void setBeta(ArrayList<ChannelDifferentiator> beta)
	{
		this.beta = beta;
	}
	
	public ArrayList<ChannelDifferentiator> getGamma()
	{
		return gamma;
	}
	
	public void setGamma(ArrayList<ChannelDifferentiator> gamma)
	{
		this.gamma = gamma;
	}
	
	public ArrayList<ChannelDifferentiator> getTheta()
	{
		return theta;
	}
	
	public void setTheta(ArrayList<ChannelDifferentiator> theta)
	{
		this.theta = theta;
	}
	
	public ArrayList<ChannelDifferentiator> getDelta()
	{
		return delta;
	}
	
	public void setDelta(ArrayList<ChannelDifferentiator> delta)
	{
		this.delta = delta;
	}
}
