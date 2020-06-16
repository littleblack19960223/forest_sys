import com.project.bean.PestBean;
import com.project.service.IPestService;
import com.project.service.impl.PestServiceImpl;

public class pestTest {
    public static void main(String[] args) {
//        IPestService iPestService=new PestServiceImpl();
//        iPestService.showAllPest();
//        System.out.println(iPestService.showAllPest());


        IPestService iPestService=new PestServiceImpl();
        PestBean pestBean=new PestBean();

        pestBean.setName("aa");
        pestBean.setHost("ss");
        pestBean.setHarm("dd");
        pestBean.setBreed("ff");
        pestBean.setEnemy("gg");
        pestBean.setMeasure("hh");
        pestBean.setLarvaImg("jj");
        pestBean.setAdultImg("kk");

        System.out.println(iPestService.addNewPest(pestBean));
    }
}
