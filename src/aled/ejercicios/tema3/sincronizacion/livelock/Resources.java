package es.upm.aled.livelock;

public class Resources {

	private boolean aFree;
	private boolean bFree;
	
	public Resources() {
		this.aFree = true;
		this.bFree = true;
	}
	
	public synchronized boolean getA() {
		if (aFree) {
			aFree = false;
			return true;
		}
		return false;
	}
	
	public synchronized boolean getB() {
		if (bFree) {
			bFree = false;
			return true;
		}
		return false;
	}
	
	public synchronized void releaseA() {
		aFree = true;
	}
	
	public synchronized void releaseB() {
		bFree = true;
	}
}
