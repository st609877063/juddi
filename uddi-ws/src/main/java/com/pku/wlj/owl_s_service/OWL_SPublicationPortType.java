package com.pku.wlj.owl_s_service;

import java.rmi.Remote;

import javax.jws.WebService;
@WebService
public interface OWL_SPublicationPortType extends Remote {
	public int processDeleteEntry(int service_id);
}
