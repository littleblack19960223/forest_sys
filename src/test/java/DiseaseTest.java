import com.project.service.IDiseaseService;
import com.project.service.IPestService;
import com.project.service.impl.DiseaseServiceImpl;
import com.project.service.impl.PestServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class DiseaseTest {
    public static void main(String[] args) {
        IDiseaseService iDiseaseService=new DiseaseServiceImpl();

        System.out.println(iDiseaseService.showAllDisease());


//        IPestService iPestService=new PestServiceImpl();
//        PestBean pestBean=new PestBean();
//        pestBean.setName("aa");
//        pestBean.setHost("ss");
//        pestBean.setHarm("dd");
//        pestBean.setBreed("ff");
//        pestBean.setEnemy("gg");
//        pestBean.setMeasure("hh");
//        pestBean.setLarvaImg("jj");
//        pestBean.setAdultImg("kk");
//        System.out.println(iPestService.addNewPest(pestBean));

//        IPestService iPestService=new PestServiceImpl();
//        System.out.println(iPestService.showDetail(1));

//        IPestService iPestService=new PestServiceImpl();
//        Map<String,String> map=new HashMap<String,String>();
//        map.put("pestName","");
//        map.put("pestHost","杨");
//        System.out.println(iPestService.showPestByCondition(map));

    }
}
