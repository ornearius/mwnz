package studio.coffeesocial.evaluation.service;

import org.springframework.stereotype.Service;
import studio.coffeesocial.openapi.model.Company;

public interface CompanyService {

    Company getCompany(Integer id);
}
