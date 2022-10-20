package bozlak.autowiredless;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bozlak.autowiredless.business.abstracts.UsStateService;
import bozlak.autowiredless.business.concretes.UsStateManager;
import bozlak.autowiredless.dataAccess.abstracts.UsStateDal;
import bozlak.autowiredless.dataAccess.concretes.hibernate.HibernateUsStateDal;

@Configuration
public class IocConfig {
    
    @Bean
    public UsStateDal usStateDal() {
        return new HibernateUsStateDal();
    }

    @Bean
    public UsStateService usStateService() {
        return new UsStateManager(usStateDal());
    }
}
