import com.project.bean.DiseaseBean;
import com.project.bean.RatsBean;
import com.project.dao.IRatsDao;
import com.project.service.IDiseaseService;
import com.project.service.IRatsService;
import com.project.service.impl.DiseaseServiceImpl;
import com.project.service.impl.RatsServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class RatsTest {
    public static void main(String[] args) {
        IRatsService iRatsService=new RatsServiceImpl();
//        System.out.println(iRatsService.showAllRats());

//        RatsBean ratsBean=new RatsBean();
//        ratsBean.setName("zxc");
//        ratsBean.setFood("asd");
//        ratsBean.setHarm("qwe");
//        ratsBean.setBreed("rty");
//        ratsBean.setEnemy("fgh");
//        ratsBean.setMeasure("jkl");
//        ratsBean.setImg("bnm");
//        System.out.println(iRatsService.addNewRats(ratsBean));

//        System.out.println(iRatsService.showDetail(3));

        Map<String,String> map=new HashMap<String,String>();
        map.put("ratsName","zx");
        System.out.println(iRatsService.showRatsListByCondition(map));

    }
}
