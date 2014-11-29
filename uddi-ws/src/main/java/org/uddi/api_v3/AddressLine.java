/*
 * Copyright 2001-2008 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */


package org.uddi.api_v3;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <h4 style="margin-left:0in;text-indent:0in">3.3.2.8 addressLine</h4>

<p class="MsoBodyText"><b>addressLine</b> contains a part of the actual address
in text form.</p>

<p class="MsoBodyText"><b>Attributes</b></p>

<table class="MsoNormalTable" style="margin-left:.5in;border-collapse:collapse;border:none" border="1" cellpadding="0" cellspacing="0">
 <tbody><tr>
  <td style="border:solid black 1.0pt;background:#FFFFCA;padding:
  0in 5.4pt 0in 5.4pt" valign="top">
  <p class="MsoNormal"><b>Name&nbsp; </b></p>
  </td>
  <td style="border:solid black 1.0pt;border-left:none;background:
  #FFFFCA;padding:0in 5.4pt 0in 5.4pt" valign="top">
  <p class="MsoNormal"><b>Use&nbsp; </b></p>
  </td>
 </tr>
 <tr>
  <td style="border:solid black 1.0pt;border-top:none;padding:0in 5.4pt 0in 5.4pt" valign="top">
  <p class="MsoNormal">keyName&nbsp; </p>
  </td>
  <td style="border-top:none;border-left:none;border-bottom:solid black 1.0pt;
  border-right:solid black 1.0pt;padding:0in 5.4pt 0in 5.4pt" valign="top">
  <p class="MsoNormal">optional&nbsp; </p>
  </td>
 </tr>
 <tr>
  <td style="border:solid black 1.0pt;border-top:none;padding:0in 5.4pt 0in 5.4pt" valign="top">
  <p class="MsoNormal">keyValue</p>
  </td>
  <td style="border-top:none;border-left:none;border-bottom:solid black 1.0pt;
  border-right:solid black 1.0pt;padding:0in 5.4pt 0in 5.4pt" valign="top">
  <p class="MsoNormal">optional</p>
  </td>
 </tr>
</tbody></table>

<p class="MsoBodyText">&nbsp;</p>

<p class="MsoBodyText">Each addressLine element MAY be adorned with two optional
descriptive attributes, <b>keyName</b> and <b>keyValue</b>. Both attributes
MUST be present in each address line if a tModelKey is specified in the address
structure. When no tModelKey is provided for the address structure, the keyName
and keyValue attributes have no defined meaning.</p>
 * <p>Java class for addressLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressLine">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:uddi-org:api_v3>validationTypeString80">
 *       &lt;attribute name="keyName" type="{urn:uddi-org:api_v3}keyName" default="" />
 *       &lt;attribute name="keyValue" type="{urn:uddi-org:api_v3}keyValue" default="" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressLine", propOrder = {
    "value"
})
public class AddressLine implements Serializable{
        public AddressLine(){}
        public AddressLine(String keyname, String keyval,String val){
                value=val;
                keyName=keyname;
                keyValue=keyval;
        }
	@XmlTransient
	private static final long serialVersionUID = -1219407731100892960L;
	@XmlValue
    protected String value;
    @XmlAttribute
    protected String keyName;
    @XmlAttribute
    protected String keyValue;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the keyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyName() {
        if (keyName == null) {
            return "";
        } else {
            return keyName;
        }
    }

    /**
     * Sets the value of the keyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyName(String value) {
        this.keyName = value;
    }

    /**
     * Gets the value of the keyValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyValue() {
        if (keyValue == null) {
            return "";
        } else {
            return keyValue;
        }
    }

    /**
     * Sets the value of the keyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyValue(String value) {
        this.keyValue = value;
    }

}
