package studio.coffeesocial.evaluation.service;

import org.springframework.stereotype.Service;
import studio.coffeesocial.openapi.model.Company;

@Service
public interface CompanyService {

    Company getCompany(Integer id);
}
