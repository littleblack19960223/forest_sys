import com.project.service.IPestService;
import com.project.service.impl.PestServiceImpl;

public class pestTest {
    public static void main(String[] args) {
        IPestService iPestService=new PestServiceImpl();
        iPestService.showAllPest();
        System.out.println(iPestService.showAllPest());
    }
}
