package com.co.gemfireserver;

import com.co.gemfireserver.hello.Person;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.*;

@SpringBootApplication
@CacheServerApplication(logLevel = "info", autoStartup = true, maxConnections = 100)
@EnableCacheServer(name = "Venus", autoStartup = true, hostnameForClients = "venus", port = 8080)
//@EnableLocator(host = "localhost", port = 44444)
@EnableEntityDefinedRegions(basePackageClasses = com.co.gemfireserver.hello.Person.class,
        clientRegionShortcut = ClientRegionShortcut.CACHING_PROXY)
@EnableHttpService
public class GemfireserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemfireserverApplication.class, args);
	}
}

