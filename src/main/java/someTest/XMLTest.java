package someTest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import vo.maiyuanvo.ErrorStatus;
import vo.maiyuanvo.ReturnSms;
import vo.maiyuanvo.StatusBox;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLTest {

    public static void main(String[] args) throws Exception {
//        String x = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<string xmlns=\"http://tempuri.org/\">\n" +
//                "Null\n" +
//                "</string>";
//        System.out.println(x);
//
//        ReturnSms s =parseReturnSms3(x);
//        if( s == null)
//            System.out.println( "no");
//        else
//            System.out.println(s.getTaskID()+" : " +s.getMessage());

        String x2 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><returnsms> </returnsms>";
        ReturnSms r = parseReturnSms(x2);
        if( r == null)
            System.out.println( "no");
        else
            System.out.println(r.getTaskID()+" : " +r.getMessage());

    }

    /**
     *
     <returnsms> <statusbox> <mobile>15859104764</mobile> <taskid>14680237</taskid> <status>10</status> <receivetime>2015-3-26 15:15:42</receivetime> <errorcode>DELIVRD</errorcode> <extno></extno> </statusbox> </returnsms>
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static ReturnSms parseReturnSms(String xmlStr) throws JDOMException, IOException {
        ReturnSms retSms = new ReturnSms();
        List<StatusBox> boxList = new ArrayList<StatusBox>();
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = builder.build(new StringReader(xmlStr));
        Element root = doc.getRootElement();
        List ls = root.getChildren();// 注意此处取出的是root节点下面的一层的Element集合
        if(ls.size()<=0){
            return null;
        }
        Element eel = (Element) ls.get(0);
        //TODO 错误状态的返回
        if(eel.getName().equalsIgnoreCase("errorstatus")){
            ErrorStatus ses = new ErrorStatus();
//			for (Iterator iter = els.iterator(); iter.hasNext();) {
//				Element eel2 = (Element) iter.next();
            ses.setError(eel.getChildText("error"));
            ses.setRemark(eel.getChildText("remark"));
//			}
            retSms.setErrorstatus(ses);
            return retSms;
        }
        for (Iterator iter = ls.iterator(); iter.hasNext();) {
            StatusBox box = new StatusBox();
            Element el = (Element) iter.next();
            box.setMobile(el.getChildText("mobile"));
            box.setTaskid(el.getChildText("taskid"));
            box.setReceivetime(el.getChildText("receivetime"));
            box.setErrorcode(el.getChildText("errorcode"));

            boxList.add(box);
        }
        retSms.setStatusbox(boxList);
        return retSms;
    }

    public static ReturnSms parseReturnSms2(String xmlStr) throws JDOMException, IOException {
        ReturnSms retSms = new ReturnSms();
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = builder.build(new StringReader(xmlStr));
        Element root = doc.getRootElement();
        retSms.setReturnstatus(root.getChildText("returnstatus"));
        retSms.setMessage(root.getChildText("message"));
        retSms.setRemainpoint(Integer.valueOf(root.getChildText("remainpoint")));
        retSms.setTaskID(root.getChildText("taskID"));
        retSms.setSuccessCounts(Integer.valueOf(root.getChildText("successCounts")));
        return retSms;
    }

    public static ReturnSms parseReturnSms3(String xmlStr) throws JDOMException, IOException {
        ReturnSms retSms = new ReturnSms();
        SAXBuilder builder = new SAXBuilder(false);
        Document doc = builder.build(new StringReader(xmlStr));
        Element root = doc.getRootElement();
        System.out.println("xx  "+root.getChildText("string"));
        return retSms;
    }
}
