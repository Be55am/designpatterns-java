package com.bessam.patterns.creational;

/**
 * @author bessam on 08/03/2021
 */

public class DBSingleton {

	//(for threadsafety) volatile will make it thread safe it will assure that the instance will stay singleton no matter what
	private static volatile DBSingleton instance = null;

	//(for threadsafety) to not allow the creation from outside
	private DBSingleton() {
		// to make sure that it wont be reinstanciated through different things in the JVM like reflection ...
		if (instance != null)
			throw new RuntimeException("Use getInstance() method to create ");
	}

	// to make it lazy loaded
	//it will make the app load fast and perform better
	public static DBSingleton getInstance() {
		if (instance == null) {// for thread safety if a thread get here it will be locked
			synchronized (DBSingleton.class) { // for thread safety
				if (instance == null) // for thread safety if a thread get here it will lock the other
					instance = new DBSingleton();
			}
		}
		return instance;
	}
}
