package product_p2p.kit.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncLock {
	private Lock SCLock = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void EnterLock() {
		if (SCLock == null) {
			SCLock = new ReentrantLock();
		}
		SCLock.lock();
	}

	public boolean TryEnterLock() {
		if (SCLock == null) {
			SCLock = new ReentrantLock();
		}
		
		return SCLock.tryLock();
	}
	
	public void LeaveLock() {
		if (SCLock != null) {
			SCLock.unlock();
		}
	}
}
