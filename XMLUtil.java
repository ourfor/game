//designpatterns.factorymethod.XMLUtil.java
package game.refactoring.finished.r3.config;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.net.URL;

public class XMLUtil {
	// 该方法用于从XML配置文件中提取让所需的信息，返回一个字符串对象
	public String getByName(String nameStr) {
		try {
			String ret;
			// 创建DOM文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			// String XMLfile="src//game//refactoring//finished//r3//config//config.xml";
			String XMLFileStr = "/game/refactoring/finished/r3/config/config.xml";
			URL XMLFileURL = this.getClass().getResource(XMLFileStr);
			doc = builder.parse(XMLFileURL.openConnection().getInputStream());

			// 获取包含类名的文本结点
			NodeList nl = doc.getElementsByTagName(nameStr);
			Node classNode = nl.item(0).getFirstChild();
			ret = classNode.getNodeValue();

			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 该方法用于从XML配置文件中提取让所需的信息，返回一个字符串数组对象
	public String[] getByNames(String nameStr) {
		try {
			String[] ret;
			// 创建DOM文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			// String XMLfile="src//game//refactoring//finished//r3//config//config.xml";
			String XMLFileStr = "/game/refactoring/finished/r3/config/config.xml";
			URL XMLFileURL = this.getClass().getResource(XMLFileStr);
			doc = builder.parse(XMLFileURL.openConnection().getInputStream());

			// 获取包含类名的文本结点
			NodeList nl = doc.getElementsByTagName(nameStr);
			ret = new String[nl.getLength()];
			for (int i = 0; i < nl.getLength(); i++) {
				Node classNode = nl.item(i).getFirstChild();
				ret[i] = classNode.getNodeValue();
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
	public Object getBean() {
		try {
			// 创建DOM文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src//designpatterns//factorymethod//config.xml"));

			// 获取包含类名的文本结点
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(0).getFirstChild();
			String cName = classNode.getNodeValue();

			// 通过类名生成实例对象并将其返回
			Class c = Class.forName(cName);
			Object obj = c.newInstance();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}