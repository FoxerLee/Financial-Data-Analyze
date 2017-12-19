package edu.tongji.demo.ServiceImpl;

import edu.tongji.demo.DAO.WinnerListMapper;
import edu.tongji.demo.Model.WinnerList;
import edu.tongji.demo.Service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class WinnerServiceImpl implements WinnerService {

    @Autowired
    private WinnerListMapper winnerListMapper;

    @Override
    public Object getWinnerListByCookie(){
        ArrayList<WinnerList> data = winnerListMapper.getAll();
        ArrayList<String> reasons = new ArrayList<String>();
        for(int i = 0; i < data.size(); i++){
            if(reasons.indexOf(data.get(i).getReason()) == -1)
                reasons.add(data.get(i).getReason());
        }
        Object[] result = new Object[reasons.size()];
        int tag = 0;
        for (int i = 0; i < reasons.size(); i++){
            ArrayList<WinnerList> list = new ArrayList<>();
            while(data.get(tag).getReason().equals(reasons.get(i))){
                list.add(data.get(tag));
                tag++;
                if(tag == data.size())
                    break;
            }
            HashMap<String, Object> content = new HashMap<>();
            content.put("reason", reasons.get(i));
            content.put("data", list);
            result[i] = content;
        }
        return result;
    }
}
