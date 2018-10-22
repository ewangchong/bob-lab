package com.codergray.jaxb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class Converter {
	/**
     * convent java object to xml format String.
     * 
     * @param originalObj
     * @param xmlCharset
     *            the format of charset for xml. ie "UTF-8", "GBK"
     * @param isFragment
     *            whether or not display the header for the generated xml. such
     *            as <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
     * @return
     */
    public static String convertJava2XmlStr(Object originalObj,
            String xmlCharset, boolean isFragment) {
        String xmlStr = "";
        try {
            JAXBContext ctx = JAXBContext.newInstance(originalObj.getClass());
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, xmlCharset);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, isFragment);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            marshaller.marshal(originalObj, os);

            xmlStr = os.toString();
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlStr;
    }
    
    /**
     * convert xml string to Java object by JAXB.
     * @param obj  to convert java object.
     * @param xmlStr    
     * @return
     */
    public static Object convertXmlStr2Java(Object obj, String xmlStr) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
            InputStream source = new ByteArrayInputStream(xmlStr.getBytes());
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            obj = unmarshaller.unmarshal(source);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return obj;
    }
    
    public static void main(String[] args){
    	String xmlStr = "<promotion>   <id>Hello</id>     <name>Test</name>       <type>CMS</type>        <typeDes>CMSTest</typeDes>       <startTime>2012-01-01</startTime>       <endTime>2012-01-03</endTime>        <products>            <product>                <merchantId>merchantid</merchantId>                <num>500</num>                <productCode>code1</productCode>                <productId>111</productId>                <requestId>codedata</requestId>            </product>            <product>                <merchantId>merchantid2</merchantId>                <num>800</num>                <productCode>code2</productCode>                <productId>2</productId>                <requestId>codedata</requestId>            </product>        </products>    </promotion>";
    	Promotion promotion = (Promotion) Converter.convertXmlStr2Java(new Promotion(), xmlStr);
    	System.out.println(promotion.toString());
    	
    	promotion.setId("Hello");
    	
    	String result = Converter.convertJava2XmlStr(promotion, "UTF-8", true);
    	System.out.println(result);
    }
    
}
