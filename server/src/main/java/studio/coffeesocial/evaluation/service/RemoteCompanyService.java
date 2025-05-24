package studio.coffeesocial.evaluation.service;

import org.springframework.stereotype.Service;
import studio.coffeesocial.openapi.model.Company;

public class RemoteCompanyService {

    protected Company getCompany(Integer id) {
        return new Company().id(id);
    }
}
