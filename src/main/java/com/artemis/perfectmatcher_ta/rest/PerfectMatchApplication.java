package com.artemis.perfectmatcher_ta.rest;

/**
 *
 * @author artemis
 */
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class PerfectMatchApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public PerfectMatchApplication() {
		singletons.add(new PerfectMatchRestService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
