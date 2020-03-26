import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.heima.utils.PinYin4jUtils;

public class PingYin4Jtest {
	@Test
	public void test(){
		//QY017	河北省	石家庄市	长安区	130102
		String province="河北省";
		String city = "石家庄市";
		String district="长安区";
		String info=province.substring(0, province.length()-1)+city.substring(0, city.length()-1)+district.substring(0, district.length()-1);
		String[] headByString = PinYin4jUtils.getHeadByString(info);
		String join = StringUtils.join(headByString);
		System.out.println(join);
		String hanziToPinyin = PinYin4jUtils.hanziToPinyin(info,"");
		System.out.println(hanziToPinyin);
	}
}
