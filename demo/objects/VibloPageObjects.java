package demo.objects;

import java.util.concurrent.TimeUnit;


import demo.config.SetupDriver;
/* 
 * Thao tác tại chính page này
 * tận dụng thêm các method đa được định nghĩa ở BasicOject
 * các thao tác riêng chỉ có ở page này thì tự bổ sung method
 */
public class VibloPageObjects extends BasicObject{
	String URL = "https://accounts.viblo.asia/login";
	
	public VibloPageObjects() throws Exception {
		this.driver = SetupDriver.buildSetupDriver();
		driver.get(URL);
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
