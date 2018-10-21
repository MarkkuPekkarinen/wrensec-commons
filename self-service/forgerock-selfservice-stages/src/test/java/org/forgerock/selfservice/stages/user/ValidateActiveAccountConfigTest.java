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
 * Copyright 2017 ForgeRock AS.
 */

package org.forgerock.selfservice.stages.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.forgerock.selfservice.core.config.StageConfig;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

/**
 * Unit test for {@link ValidateActiveAccountConfig}.
 *
 * @since 22.0.0
 */
public class ValidateActiveAccountConfigTest {
    @Test
    public void testConfigFromJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(
                new NamedType(ValidateActiveAccountConfig.class, ValidateActiveAccountConfig.NAME)
        );
        StageConfig config = mapper.readValue(getClass().getResource("/validateActiveAccount.json"), StageConfig.class);

        assertThat(config).isInstanceOf(ValidateActiveAccountConfig.class);
        ValidateActiveAccountConfig validAccountConfig = (ValidateActiveAccountConfig) config;
        assertThat(validAccountConfig.getAccountStatusField()).isEqualTo("accountStatus");
        assertThat(validAccountConfig.getValidStatusValue()).isEqualTo("active");
    }
}
