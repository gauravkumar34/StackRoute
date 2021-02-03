package JavaConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyConfiguration {
    @Bean (name ="address")
    public Address addr()
    {
        return new Address(10,"GandhiStreet","Chennai",600024);
    }
}
