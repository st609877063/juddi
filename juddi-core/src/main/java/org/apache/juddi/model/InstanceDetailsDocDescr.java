package org.apache.juddi.model;
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
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author <a href="mailto:kurt@apache.org">Kurt T Stam</a>
 * @author <a href="mailto:jfaath@apache.org">Jeff Faath</a>
 */
@Entity
@Table(name = "j3_instance_details_doc_descr")
public class InstanceDetailsDocDescr implements java.io.Serializable {

	private static final long serialVersionUID = -6936654678202381863L;
	private Long id;
	private TmodelInstanceInfo tmodelInstanceInfo;
	private String langCode;
	private String descr;

	public InstanceDetailsDocDescr() {
	}

	public InstanceDetailsDocDescr(Long id,
			TmodelInstanceInfo tmodelInstanceInfo, String descr) {
		this.id = id;
		this.tmodelInstanceInfo = tmodelInstanceInfo;
		this.descr = descr;
	}

	public InstanceDetailsDocDescr(Long id,
			TmodelInstanceInfo tmodelInstanceInfo, String langCode, String descr) {
		this.id = id;
		this.tmodelInstanceInfo = tmodelInstanceInfo;
		this.langCode = langCode;
		this.descr = descr;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tmodel_instance_info_id", nullable = false)
	public TmodelInstanceInfo getTmodelInstanceInfo() {
		return this.tmodelInstanceInfo;
	}
	public void setTmodelInstanceInfo(TmodelInstanceInfo tmodelInstanceInfo) {
		this.tmodelInstanceInfo = tmodelInstanceInfo;
	}

	@Column(name = "lang_code", length = 26)
	public String getLangCode() {
		return this.langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	@Column(name = "descr", nullable = false, length = 255)
	public String getDescr() {
		return this.descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}

}
