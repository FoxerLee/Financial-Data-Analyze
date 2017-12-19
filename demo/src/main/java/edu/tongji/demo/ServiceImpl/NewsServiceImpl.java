package edu.tongji.demo.ServiceImpl;

import edu.tongji.demo.DAO.NewsMapper;
import edu.tongji.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Object getNewsByCode(String code){
        return newsMapper.getNews(code);
    }

    @Override
    public Object getBriefNewsByCode(String code){
        return newsMapper.getEveryNews(code);
    }
}
