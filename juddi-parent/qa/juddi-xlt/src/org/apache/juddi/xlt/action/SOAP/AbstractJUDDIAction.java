/*
 * Copyright 2001-2010 The Apache Software Foundation.
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
package org.apache.juddi.xlt.action.SOAP;

import javax.xml.ws.BindingProvider;

import com.xceptance.xlt.api.actions.AbstractAction;

/**
 * An abstract class for jUDDI test actions.
 *
 */
public abstract class AbstractJUDDIAction extends AbstractAction 
{

	public AbstractJUDDIAction(String timerName) 
	{
		super(null, timerName);
	}

	protected void setHttpSessionManagementEnabled(BindingProvider bindingProvider, boolean state) 
	{
		bindingProvider.getRequestContext().put(
				BindingProvider.SESSION_MAINTAIN_PROPERTY,
				Boolean.valueOf(state));
	}
}
