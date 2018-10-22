package com.codergray.jaxb;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * ����xml������ 
 * @author daiqiang
 * ��Ӧxml�ļ��������£�
 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <promotion>
        <id>promotionId</id>
        <name>Ԫ������</name>
        <type>CMS</type>
        <typeDes>CMS���ƴ���</typeDes>
        <startTime>2012-01-01</startTime>
        <endTime>2012-01-03</endTime>
        <products>
            <product>
                <merchantId>merchantid</merchantId>
                <num>500</num>
                <productCode>code1</productCode>
                <productId>111</productId>
                <requestId>codedata</requestId>
            </product>
            <product>
                <merchantId>merchantid2</merchantId>
                <num>800</num>
                <productCode>code2</productCode>
                <productId>2</productId>
                <requestId>codedata</requestId>
            </product>
        </products>
    </promotion>
 *
 */
@XmlRootElement(name="promotion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Promotion implements Serializable{

    private static final long serialVersionUID = 870036805093867083L;
    
    @XmlTransient
    private String id;
    private String name;
    private String type;
    private String typeDes;
	private String startTime;
    private String endTime;
    
    @XmlElementWrapper(name="products")
    @XmlElement(name="product")
    private List<Product> products;
    
    /*@XmlTransient
    the field is not binded to xml
    private String testHiddenFields;*/
    //�˴�ʡ�Ծ���set get ������
    //@XmlTransient
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeDes() {
		return typeDes;
	}

	public void setTypeDes(String typeDes) {
		this.typeDes = typeDes;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", name=" + name + ", type=" + type
				+ ", typeDes=" + typeDes + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", products=" + products + "]";
	}
	
	

}