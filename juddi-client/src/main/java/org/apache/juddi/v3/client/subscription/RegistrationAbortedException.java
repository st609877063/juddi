/*
 * Copyright 2013 The Apache Software Foundation.
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

package org.apache.juddi.v3.client.subscription;

/**
 * throw when a particular digital signature situation occurs
 * @author <a href="mailto:alexoree@apache.org">Alex O'Ree</a>
 *  @since 3.2
 */
public class RegistrationAbortedException extends Exception{
    private static final long serialVersionUID = 1L;

    public RegistrationAbortedException(String message) {
        super(message);
        
    }

}
