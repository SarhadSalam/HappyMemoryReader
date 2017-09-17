package analytics;

/**
 * Class Details:- Author: Sarhad User: sarha Date: 16-Sep-17 Time : 12:13 PM Project Name: hackTheNorth Class Name:
 * ChannelDifferentiator
 */
public class ChannelDifferentiator
{
	
	private float freqChannel1 = 0.0f;
	private float freqChannel2 = 0.0f;
	private float freqChannel3 = 0.0f;
	private float freqChannel4 = 0.0f;
//
//	ChannelDifferentiator(float freqChannel1, float freqChannel2, float freqChannel3, float freqChannel4)
//	{
//		this.freqChannel1 = freqChannel1;
//		this.freqChannel2 = freqChannel2;
//		this.freqChannel3 = freqChannel3;
//		this.freqChannel4 = freqChannel4;
//	}
	
	
	@Override
	public String toString()
	{
		System.out.println("The value on channel 1 is: " + freqChannel1);
		System.out.println("The value on channel 2 is: " + freqChannel2);
		System.out.println("The value on channel 3 is: " + freqChannel3);
		System.out.println("The value on channel 4 is: " + freqChannel4);
		return super.toString();
	}
	
	public float getFreqChannel1()
	{
		return freqChannel1;
	}
	
	public void setFreqChannel1(float freqChannel1)
	{
		this.freqChannel1 = freqChannel1;
	}
	
	public float getFreqChannel2()
	{
		return freqChannel2;
	}
	
	public void setFreqChannel2(float freqChannel2)
	{
		this.freqChannel2 = freqChannel2;
	}
	
	public float getFreqChannel3()
	{
		return freqChannel3;
	}
	
	public void setFreqChannel3(float freqChannel3)
	{
		this.freqChannel3 = freqChannel3;
	}
	
	public float getFreqChannel4()
	{
		return freqChannel4;
	}
	
	public void setFreqChannel4(float freqChannel4)
	{
		this.freqChannel4 = freqChannel4;
	}
}
