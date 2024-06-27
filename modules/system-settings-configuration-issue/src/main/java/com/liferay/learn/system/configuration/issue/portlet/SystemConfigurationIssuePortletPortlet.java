package com.liferay.learn.system.configuration.issue.portlet;

import com.liferay.learn.system.configuration.issue.configuration.YetOtherSystemConfigurationIssueConfiguration;
import com.liferay.learn.system.configuration.issue.configuration.SystemConfigurationIssueConfiguration;
import com.liferay.learn.system.configuration.issue.constants.SystemConfigurationIssuePortletPortletKeys;
import com.liferay.learn.system.configuration.issue.constants.SystemConfigurationIssuePortletWebKeys;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.samplee",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SystemConfigurationIssuePortlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SystemConfigurationIssuePortletPortletKeys.SYSTEMCONFIGURATIONISSUEPORTLET,
		"javax.portlet.security-role-ref=power-user,user",
	},
	configurationPid = {
		"com.liferay.learn.system.configuration.issue.configuration.SystemConfigurationIssueConfiguration",
		"com.liferay.learn.system.configuration.issue.configuration.YetOtherSystemConfigurationIssueConfiguration"
	},
	service = Portlet.class
)
public class SystemConfigurationIssuePortletPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(renderRequest);

		String message = "system-settings-configuration-issue Add Portlet Provider";

		try {
			PortletPreferences preferences =
				PortletPreferencesFactoryUtil.getPortletSetup(
					renderRequest, portletId);

			String className = preferences.getValue(
				"className", null);

			long classPK = GetterUtil.getLong(
				preferences.getValue("classPK", null));

			if (Validator.isNotNull(className) && (classPK > 0)) {
				AssetEntry assetEntry = _assetEntryLocalService.getEntry(
					className, classPK);

				message = assetEntry.getTitle(themeDisplay.getLocale());
			}
		}
		catch (PortalException pe) {
			System.out.println("Errrooooooor" + pe.getMessage());
		}

		renderRequest.setAttribute(
			SystemConfigurationIssuePortletWebKeys.PORTLET_PROVIDER_MESSAGE, message);

		super.doView(renderRequest, renderResponse);
	}

	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		System.out.println("SystemConfigurationIssueConfiguration configuration render ==> " +
								   this._systemConfigurationIssueConfiguration.companyy() + " " +
								   _yetOtherSystemConfigurationIssueConfiguration.otherValue());
		renderRequest.setAttribute("companyy", this._systemConfigurationIssueConfiguration.companyy());
		renderRequest.setAttribute("other", this._yetOtherSystemConfigurationIssueConfiguration.otherValue());

		super.render(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_systemConfigurationIssueConfiguration = ConfigurableUtil.createConfigurable(SystemConfigurationIssueConfiguration.class, properties);
		_yetOtherSystemConfigurationIssueConfiguration = ConfigurableUtil.createConfigurable(
				YetOtherSystemConfigurationIssueConfiguration.class, properties);

		System.out.println("SystemConfigurationIssueConfiguration configuration activated ==> " +
								   this._systemConfigurationIssueConfiguration.companyy() + " " +
								   _yetOtherSystemConfigurationIssueConfiguration.otherValue());
	}

	@Reference(unbind = "-")
	private volatile AssetEntryLocalService _assetEntryLocalService;

	private volatile SystemConfigurationIssueConfiguration _systemConfigurationIssueConfiguration;
	private volatile YetOtherSystemConfigurationIssueConfiguration _yetOtherSystemConfigurationIssueConfiguration;

}