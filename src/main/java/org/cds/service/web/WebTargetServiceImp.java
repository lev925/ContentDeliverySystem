package org.cds.service.web;

import org.cds.model.Target;
import org.cds.model.User;
import org.cds.model.web.WebTarget;
import org.cds.model.web.WebTargetASM;
import org.cds.model.web.WebTargetFilter;
import org.cds.service.ContentService;
import org.cds.service.TargetService;
import org.cds.service.UsersService;
import org.cds.service.mapper.TargetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    TargetMapper targetMapper;

    @Override
    public List<WebTarget> getAllTargetsByUserAndPage(WebTargetFilter webTargetFilter) {

        User user = usersService.findById(webTargetFilter.getUserGuid());
        List<Target> targetForUser = targetService.getTargetByUserIdAndPage(user,webTargetFilter.getPageName());
        List<WebTarget> webTargets = new ArrayList<>();
        for (Target o : targetForUser) {
            webTargets.add(targetMapper.targetToWebTarget(o));
        }
        return webTargets;

    }

    @Override
    public WebTarget findById(UUID id) {
        Target target = targetService.findById(id);
        return targetMapper.targetToWebTarget(target);
    }

    @Override
    @Transactional
    public Target saveTarget(WebTargetASM webTargetASM) {
        Target target = Target.builder()
                .content(contentService.findContentById(webTargetASM.getContentId()))
                .user(usersService.findById(webTargetASM.getUserId()))
                .endDate(webTargetASM.getEndDate())
                .startDate(webTargetASM.getStartDate())
                .page(webTargetASM.getPage())
                .priority(webTargetASM.getPriority())
                .build();
        return targetService.saveTarget(target);

    }

    @Override
    public List<WebTarget> getAllTarget() {

        List<Target> targetForUser = targetService.getAllTarget();
        List<WebTarget> webTargets = new ArrayList<>();
        for (Target o : targetForUser) {
            webTargets.add(targetMapper.targetToWebTarget(o));
        }
        return webTargets;
    }
}
