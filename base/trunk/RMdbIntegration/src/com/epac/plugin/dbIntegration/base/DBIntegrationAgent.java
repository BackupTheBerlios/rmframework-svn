package com.epac.plugin.dbIntegration.base;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.SimpleConfiguration;

public class DBIntegrationAgent extends Agent {
	
	public static void main(String[] args) {
    	ContainerConfiguration configuration = new ContainerConfiguration(new SimpleConfiguration());
        Container.getInstance().load(configuration);
    }

}
