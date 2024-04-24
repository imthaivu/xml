package VuQuocThai_22700111;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManageHD {
	private static String fileName = "data//hoadon.xml";
	private DocumentBuilderFactory fac;
	private DocumentBuilder builder;
	private Document doc;

	// constructor
	public ManageHD() {
		fac = DocumentBuilderFactory.newInstance();
		try {
			builder = fac.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			doc = builder.parse(fileName);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printAll() {
		TransformerFactory fac = null;
		Transformer tran = null;
		fac = TransformerFactory.newInstance();
		try {
			tran = fac.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tran.setOutputProperty(OutputKeys.INDENT, "yes");
		try {
			tran.transform(new DOMSource(doc), new StreamResult(System.out));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeXML() {
		TransformerFactory fac = null;
		Transformer tran = null;
		fac = fac.newInstance();
		try {
			tran = fac.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tran.setOutputProperty(OutputKeys.INDENT, "yes");
		try {
			tran.transform(new DOMSource(doc), new StreamResult(fileName));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// them hoa don
	public void addHd(HoaDon hd) {
		if (!isExist(hd.getId()) && validaTion(hd)) {
			Element root = doc.getDocumentElement();
			Element hdNode = doc.createElement("hoadon");
			root.appendChild(hdNode);
			hdNode.setAttribute("id", hd.getId());

			addTxtCntnt(doc, hdNode, "nguoilap", hd.getNguoiLap());
			addTxtCntnt(doc, hdNode, "congty", hd.getCongTy());
			addTxtCntnt(doc, hdNode, "mota", hd.getMoTa());
			addTxtCntnt(doc, hdNode, "soluong", hd.getSoLuong() + "");
		}
		// save
		writeXML();
	}

// them txt vao ben trong tag
	private void addTxtCntnt(Document doc2, Element parent, String eleName, String txt) {
		// TODO Auto-generated method stub
		Element ele = doc.createElement(eleName);
		ele.setTextContent(txt);
		parent.appendChild(ele);

	}

// kiem tra neu da ton tai
	private boolean isExist(String id) {
		// TODO Auto-generated method stub
		Element root = doc.getDocumentElement();
		NodeList hdList = root.getElementsByTagName("hoadon");
		for (int i = 0; i < hdList.getLength(); i++) {
			Element hdEle = (Element) hdList.item(i);
			String hdId = hdEle.getAttribute("id");

			if (hdId.equalsIgnoreCase(id)) {
				return true;
			}
		}

		return false;
	}

	// xoa cac ele
	public void deleteML50() {
		Element root = doc.getDocumentElement();
		NodeList hdList = root.getElementsByTagName("hoadon");
		for (int i = 0; i < hdList.getLength(); i++) {
			Element hdEle = (Element) hdList.item(i);
			String name = getTxt(hdEle, "congty");
			int soLuong = Integer.parseInt(getTxt(hdEle, "soluong"));

			if (name.contentEquals("Minh Long") && soLuong >= 50) {

				hdEle.getParentNode().removeChild(hdEle);
			}
		}

		// save
		writeXML();
	}

// ham lay txt ben trong tag
	private String getTxt(Element ele, String tag) {
		NodeList list = ele.getElementsByTagName(tag);
		return list.getLength() > 0 ? list.item(0).getTextContent() : "";
	}

	// xuat cac hd so luong > 60
	public void printHDSoLuongHon60() {
		TransformerFactory fac = null;
		Transformer tran = null;
		Element root = doc.getDocumentElement();
		NodeList hdList = root.getElementsByTagName("hoadon");
		for (int i = 0; i < hdList.getLength(); i++) {
			Element hdEle = (Element) hdList.item(i);

			
			int soLuong = Integer.parseInt(getTxt(hdEle, "soluong"));
			
			
			if (soLuong >= 60) {

				fac = fac.newInstance();
				try {
					tran = fac.newTransformer();
				} catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				tran.setOutputProperty(OutputKeys.INDENT, "yes");
				try {
					tran.transform(new DOMSource(hdEle), new StreamResult(System.out));
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private boolean validaTion(HoaDon hd) {

		return true;
	}

}
