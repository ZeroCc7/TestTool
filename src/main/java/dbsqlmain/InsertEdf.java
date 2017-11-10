package dbsqlmain;

import dao.Service;
import vo.Smdown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertEdf {
	public static void main(String[] args) {
		String failName = "D:\\0.txt";
		int smsType = 0;
		
		List<String> mobiles = getSmsTaskMobileListByFile(failName);
		String insertMobiles = "";
		int index = 0;
		int fianl = 1;
		System.out.println(mobiles.size());
		for(String mobile : mobiles){
			if(mobile.length()<11){
				continue;
			};
			if(index == 0){
				insertMobiles = insertMobiles+ mobile;
			}else{
				insertMobiles = insertMobiles +","+ mobile;
			}
			index ++ ;
			if(index == 150){
				saveSmdown(insertMobiles,smsType);
				index = 0;
				insertMobiles = "";
				System.out.println("第"+fianl+"记录成功!");
				fianl++;
			}
//			if(fianl == 5 ){
//				return;
//			}
		}
		if(index!=0){
			saveSmdown(insertMobiles,smsType);
			System.out.println("第"+fianl+"记录成功!");
		}
	}
	
	public static void saveSmdown(String mobile,int smsType){
		List<Smdown> list = new ArrayList<Smdown>();
		long start = System.currentTimeMillis();
		Smdown sm = new Smdown();
		sm.setSm_serialphones("1235:"+mobile);
		sm.setSm_content("您的验证码是5555，如非本人请忽略。");
		sm.setSm_ismgtype(smsType);
		sm.setSm_servicecode("");
		sm.setSm_sendtime("1900-01-01");
		sm.setSendlevel(0);
		sm.setTaskstatus(0);
		list.add(sm);
		try {
			Service.dao.insertSmdownList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("插入成功 num = "+ list.size());
		System.out.println("耗时："+(System.currentTimeMillis()-start) + " ms");

	}
	
	/**
	 * 读取文件
	 * @param string
	 * @return
	 */
	public static List<String> getSmsTaskMobileListByFile(String filename) {
		String encoding = "UTF-8";
		File fileF = new File(filename);
		List<String> smsMobileList = new ArrayList<String>();
		try{
			if (fileF.isFile() && fileF.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(fileF), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					smsMobileList.add(lineTxt.trim());
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件:"+filename);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("获取号码文件异常");
		}
		return smsMobileList;
	}
}
