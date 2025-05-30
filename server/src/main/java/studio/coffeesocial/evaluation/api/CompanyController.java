package studio.coffeesocial.evaluation.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import studio.coffeesocial.evaluation.service.CompanyService;
import studio.coffeesocial.openapi.api.CompaniesApi;
import studio.coffeesocial.openapi.model.Company;

import java.math.BigDecimal;

@RestController
@Slf4j
public class CompanyController implements CompaniesApi {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public ResponseEntity<Company> companiesIdGet(BigDecimal id){
        log.info("Looking for company {}", id);
        try {
            Company company = companyService.getCompany(id.intValue());
            log.info("Recieved: {}", company);
            return new ResponseEntity<>(company, HttpStatusCode.valueOf(200));
        } catch (HttpClientErrorException hcee) {
//            var error = new Error().error("404").errorDescription(hcee.getMessage());
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }
}
