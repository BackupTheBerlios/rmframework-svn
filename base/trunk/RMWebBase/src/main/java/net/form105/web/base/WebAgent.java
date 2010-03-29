package net.form105.web.base;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.ContainerConfiguration;
import net.form105.rm.base.config.SimpleConfiguration;

public class WebAgent extends Agent {
	
	public static void main(String[] args) {
    	ContainerConfiguration configuration = new ContainerConfiguration(new SimpleConfiguration());
        Container.getInstance().load(configuration);
    }

}
