import org.sikuli.script.FindFailed;

import java.awt.*;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws InterruptedException, IOException, AWTException, FindFailed {
        MethodRepository mr=new MethodRepository();
        mr.browserApplicationLaunch("chrome","https://app.skysite.com");
       // mr.loginInApplication();
        //mr.loginWithPropertyFileData();
        //mr.SelectFilter();
       mr.loginWithRobotClass();
        //mr.dataDrivenExcel();
        //mr.TestWebtable();
       // mr.CreateProj();
        //mr.Createfol();
       // mr.Vwropenmarkup();


    }
}
