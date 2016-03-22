/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2016 ForgeRock AS.
 */
package com.forgerock.api.beans;

/**
 * Class that represents the VersionedPath type in API descriptor.
 */
public class VersionedPath {

    private final String version;
    private final Resource resource;

    private VersionedPath(Builder builder){
        this.version = builder.version;
        this.resource = builder.resource;
    }

    /**
     * Getter of the resources version
     * @return Version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Getter of the resource
     * @return Resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Create a new Builder for VersionedPath
     *
     * @return Builder
     */
    public static Builder versionedPath(String version, Resource resource) {
        return new Builder(version, resource);
    }

    public static class Builder {

        private String version;
        private Resource resource;

        /**
         * Private default constructor with the mandatory fields
         */
        private Builder(String version, Resource resource) {
            this.version = version;
            this.resource = resource;
        }

        /**
         * Builds the VersionedPath instace
         *
         * @return VersionedPath instace
         */
        public VersionedPath build() {
            return new VersionedPath(this);
        }
    }

}