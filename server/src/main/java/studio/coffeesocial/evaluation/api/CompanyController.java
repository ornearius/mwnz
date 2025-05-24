package studio.coffeesocial.evaluation.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import studio.coffeesocial.evaluation.service.CompanyService;
import studio.coffeesocial.openapi.api.CompaniesApi;
import studio.coffeesocial.openapi.model.Company;

import java.math.BigDecimal;

@RestController
@Slf4j
public class CompanyController implements CompaniesApi {

    private CompanyService remoteCompanyService;

    public ResponseEntity<Company> companiesIdGet(BigDecimal id){
        return null;
    }
}
