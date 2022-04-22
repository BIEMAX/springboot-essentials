package academy.springboot.service;

import academy.springboot.domain.TemplateClass;
import academy.springboot.request.TemplateRequest;
import academy.springboot.response.TemplateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {

    //region Dionei

    public TemplateResponse templateResponse(TemplateRequest templateRequest) {
        log.info("Start query users");
        return (TemplateResponse) List.of(
                new TemplateClass("Julio", "Cocielo", "Santos"),
                new TemplateClass("Roberta", "Santos", "Junior"),
                new TemplateClass("Sergio", "Ramos", "Garcia")
        );
    }

    //endregion
}
