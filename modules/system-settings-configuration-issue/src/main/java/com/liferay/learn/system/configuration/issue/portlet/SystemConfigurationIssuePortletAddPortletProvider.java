package com.liferay.learn.system.configuration.issue.portlet;

import com.liferay.learn.system.configuration.issue.constants.SystemConfigurationIssuePortletPortletKeys;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

/**
 * @author me
 */
@Component(
	property = "model.class.name=com.liferay.asset.kernel.model.AssetEntry",
	service = PortletProvider.class
)
public class SystemConfigurationIssuePortletAddPortletProvider
	extends BasePortletProvider {

	@Override
	public String getPortletName() {
		return SystemConfigurationIssuePortletPortletKeys.SYSTEMCONFIGURATIONISSUEPORTLET;
	}

	@Override
	public Action[] getSupportedActions() {
		return _supportedActions;
	}

	private final Action[] _supportedActions = {Action.ADD};

}