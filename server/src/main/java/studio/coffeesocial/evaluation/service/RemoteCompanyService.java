package studio.coffeesocial.evaluation.service;

import org.springframework.stereotype.Service;
import studio.coffeesocial.openapi.model.Company;

@Service
public class RemoteCompanyService implements CompanyService{

    public Company getCompany(Integer id) {
        return new Company().id(id).name("test").description("123");
    }
}
