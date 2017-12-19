package edu.tongji.demo.Service;

import javax.servlet.http.HttpServletRequest;

public interface ResearchService {
    Object getBriefResearchByCode(String code);

    Object getPersonalResearch(HttpServletRequest request);
}
