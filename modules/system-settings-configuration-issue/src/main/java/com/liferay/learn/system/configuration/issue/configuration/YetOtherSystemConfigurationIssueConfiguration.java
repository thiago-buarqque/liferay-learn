package com.liferay.learn.system.configuration.issue.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "test",
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
        id = "com.liferay.learn.system.configuration.issue.configuration.YetOtherSystemConfigurationIssueConfiguration"
)
public interface YetOtherSystemConfigurationIssueConfiguration {
    @Meta.AD(
            deflt = "other-value",
            required = false
    )
    String otherValue();
}
