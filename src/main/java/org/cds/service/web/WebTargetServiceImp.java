package org.cds.service.web;

import ma.glasnost.orika.MapperFacade;
import org.cds.model.Content;
import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.web.WebTarget;
import org.cds.service.ContentService;
import org.cds.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class WebTargetServiceImp implements WebTargetService {
    @Autowired
    TargetService targetService;
    @Autowired
    ContentService contentService;
    @Autowired
    MapperFacade mapperFacade;
    @Override
    public List<WebTarget> getAllTargetsByUserAndPage(UUID id, Page page) {
        /*System.err.println(id);
        List<Target> offerForUser = targetService.getTargetByUserIdAndPage(id,page);
        List<WebTarget> webOffers = new ArrayList<>();
        for (Target o : offerForUser) {
            Content content = o.getContent();
            WebTarget webTarget = mapperFacade.map(o, WebTarget.class);
            webTarget.setData(content.getData().toString());
            webOffers.add(webTarget);
        }
        return webOffers;*/
        return null;
    }
}
