package org.javapearls.thread;

import org.javapearls.foundation.thread.WebServer;
import org.junit.Ignore;
import org.junit.Test;

public class TestExecutor {

	@Test
	public void testWebServer(){
		WebServer server = WebServer.getInstance();
		server.test();
		server.stop();
	}


	@Ignore
	@Test
	public void testCountDownLatch(){

		WebServer server = WebServer.getInstance();

		WebServer.SelfReportTask task = new WebServer.SelfReportTask();

		long runTime = server.time(10, task);
		System.out.println("running time: " + runTime);
	}


}
