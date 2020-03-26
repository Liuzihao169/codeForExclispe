import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.heima.utils.PinYin4jUtils;

public class PingYin4Jtest {
	@Test
	public void test(){
		//QY017	�ӱ�ʡ	ʯ��ׯ��	������	130102
		String province="�ӱ�ʡ";
		String city = "ʯ��ׯ��";
		String district="������";
		String info=province.substring(0, province.length()-1)+city.substring(0, city.length()-1)+district.substring(0, district.length()-1);
		String[] headByString = PinYin4jUtils.getHeadByString(info);
		String join = StringUtils.join(headByString);
		System.out.println(join);
		String hanziToPinyin = PinYin4jUtils.hanziToPinyin(info,"");
		System.out.println(hanziToPinyin);
	}
}
