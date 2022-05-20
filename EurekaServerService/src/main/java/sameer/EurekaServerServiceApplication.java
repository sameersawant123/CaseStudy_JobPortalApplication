package sameer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication  //enable the future
@EnableEurekaServer  //acts as a service registry
public class EurekaServerServiceApplication  
{
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceApplication.class, args); //bootstraps a spring application as a stand-alone application from main method
	}

}
