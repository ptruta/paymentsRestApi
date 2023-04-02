package restApisPayments.paymentsExpose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PaymentsExposeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsExposeApplication.class, args);
	}

}
