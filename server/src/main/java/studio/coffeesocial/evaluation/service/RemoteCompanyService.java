package studio.coffeesocial.evaluation.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import studio.coffeesocial.evaluation.model.Data;
import studio.coffeesocial.openapi.model.Company;

@Service
@Slf4j
public class RemoteCompanyService implements CompanyService{

    private final RestClient restClient;
    private static final String url = "https://raw.githubusercontent.com/MiddlewareNewZealand/evaluation-instructions/main/xml-api/{id}.xml";

    private final XmlMapper xmlMapper;
    public RemoteCompanyService() {
        this.restClient = RestClient.create();
        this.xmlMapper = new XmlMapper();
    }

    public Company getCompany(Integer id) {

        var company = restClient.get()
                .uri(url, id)
//                .accept(APPLICATION_XML)
                .retrieve()
                .toEntity(String.class);
        log.debug("Response status: {}", company.getStatusCode());
        log.debug("Response headers: {}", company.getHeaders());
        log.debug("Contents: {}", company.getBody());
        log.info("Company: {}", company);
        try {
            var data = xmlMapper.readValue(company.getBody(), Data.class);
            log.debug("Deserialised: {}", data);
            return new Company().id(data.id).name(data.name).description(data.description);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
