// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.offering;

import java.util.Date;

import org.apache.cloudstack.acl.InfrastructureEntity;
import org.apache.cloudstack.api.Identity;
import org.apache.cloudstack.api.InternalIdentity;

/**
 * Represents a disk offering that specifies what the end user needs in
 * the disk offering.
 *
 */
public interface DiskOffering extends InfrastructureEntity, Identity, InternalIdentity {

    String getUniqueName();

    boolean getUseLocalStorage();

    Long getDomainId();

    String getName();

    boolean getSystemUse();

    String getDisplayText();

    public String getTags();

    public String[] getTagsArray();

    Date getCreated();

    long getDiskSize();

    boolean isCustomized();

    void setDiskSize(long diskSize);
    
    void setBytesReadRate(long bytesReadRate);

    long getBytesReadRate();

    void setBytesWriteRate(long bytesWriteRate);

    long getBytesWriteRate();

    void setIopsReadRate(long iopsReadRate);

    long getIopsReadRate();

    void setIopsWriteRate(long iopsWriteRate);

    long getIopsWriteRate();
}
