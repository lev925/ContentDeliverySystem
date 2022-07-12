package org.cds.service.web;

import ma.glasnost.orika.MapperFacade;
import org.cds.model.Target;
import org.cds.model.User;
import org.cds.model.web.WebTarget;
import org.cds.model.web.WebTargetFilter;
import org.cds.service.ContentService;
import org.cds.service.TargetService;
import org.cds.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
class WebTargetServiceImp implements WebTargetService {
    @Autowired
    TargetService targetService;
    @Autowired
    UsersService usersService;
    @Autowired
    ContentService contentService;
    @Autowired
    MapperFacade mapperFacade;

    private WebTarget mapper(Target target){
        WebTarget webTarget = WebTarget.builder()
                .user(target.getUser())
                .content(target.getContent())
                .page(target.getPage())
                .priority(target.getPriority())
                .endDate(target.getEndDate())
                .startDate(target.getStartDate())
                .build();
        return webTarget;
    }
    @Override
    public List<WebTarget> getAllTargetsByUserAndPage(WebTargetFilter webTargetFilter) {

        User user = usersService.findById(webTargetFilter.getUserGuid());
        List<Target> targetForUser = targetService.getTargetByUserIdAndPage(user,webTargetFilter.getPageName());
        List<WebTarget> webTargets = new ArrayList<>();
        for (Target o : targetForUser) {
            webTargets.add(mapper(o));
        }
        return webTargets;

    }

    @Override
    public WebTarget findById(UUID id) {
        Target target = targetService.findById(id);
        WebTarget webTarget = mapper(target);
        return webTarget;
    }

    @Override
    public Target saveTarget(WebTarget webTarget) {
        Target target = Target.builder().
                content(webTarget.getContent())
                .user(webTarget.getUser())
                .page(webTarget.getPage())
                .endDate(webTarget.getEndDate())
                .startDate(webTarget.getStartDate())
                .priority(webTarget.getPriority())
                .build();
        return targetService.saveTarget(target);
    }

    @Override
    public List<WebTarget> getAllTarget() {

        List<Target> targetForUser = targetService.getAllTarget();
        List<WebTarget> webTargets = new ArrayList<>();
        for (Target o : targetForUser) {
            webTargets.add(mapper(o));
        }
        return webTargets;
    }
}
