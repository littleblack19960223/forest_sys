import com.project.bean.DiseaseBean;
import com.project.bean.PestBean;
import com.project.service.IDiseaseService;
import com.project.service.IPestService;
import com.project.service.impl.DiseaseServiceImpl;
import com.project.service.impl.PestServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class DiseaseTest {
    public static void main(String[] args) {
//        IDiseaseService iDiseaseService=new DiseaseServiceImpl();
//
//        System.out.println(iDiseaseService.showAllDisease());


//        IDiseaseService iDiseaseService=new DiseaseServiceImpl();
//        DiseaseBean diseaseBean=new DiseaseBean();
//        diseaseBean.setName("11");
//        diseaseBean.setHarm("22");
//        diseaseBean.setPattern("33");
//        diseaseBean.setCause("44");
//        diseaseBean.setSymptom("55");
//        diseaseBean.setMeasure("66");
//        diseaseBean.setImg("77");
//        System.out.println(iDiseaseService.addNewDisease(diseaseBean));

//        IDiseaseService iDiseaseService=new DiseaseServiceImpl();
//        System.out.println(iDiseaseService.showDetail(1));

        IDiseaseService iDiseaseService=new DiseaseServiceImpl();
        Map<String,String> map=new HashMap<String,String>();
        map.put("diseaseName","1");
        map.put("diseaseSymptom","t");
        System.out.println(iDiseaseService.showDiseaseByCondition(map));

    }
}
