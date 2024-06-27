package com.liferay.learn.system.configuration.issue.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "test",
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
        id = "com.liferay.learn.system.configuration.issue.configuration.SystemConfigurationIssueConfiguration"
)
public interface SystemConfigurationIssueConfiguration {
    @Meta.AD(
            deflt = "liferay",
            required = false
    )
    String companyy();
}
