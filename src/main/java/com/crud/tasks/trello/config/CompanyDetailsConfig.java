package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CompanyDetailsConfig {

    @Value("${info.app.name}")
    private String name;

    @Value("${info.app.description}")
    private String description;

    @Value("${info.app.version}")
    private String version;

    @Value("${info.app.owner.name}")
    private String ownerName;

    @Value("${info.app.owner.surname}")
    private String ownerSurname;

    @Value("${info.app.administrator.email}")
    private String adminMail;

    @Value("${info.app.administrator.address.street}")
    private String street;

    @Value("${info.app.administrator.address.number}")
    private String streetNumber;

    @Value("${info.company.name}")
    private String companyName;

    @Value("${info.company.goal}")
    private String goal;

    @Value("${info.company.email}")
    private String companyMail;

    @Value("${info.company.mail}")
    private String number;

    public String companyDetails() {
        return name + "\n ---" + description + "\n ---" + version + "\n ---" + ownerName + "\n ---" + ownerSurname + "\n ---" + adminMail
                + "\n ---" + street + "\n ---" + streetNumber + "\n ---" + companyName + "\n ---" + goal + "\n ---" + companyMail
                + "\n ---" + number;
    }
}
