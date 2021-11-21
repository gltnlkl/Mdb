package general.projectInformation;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ProjectInformation {
	private static final String BUNDLE_NAME = ProjectInformation.class.getPackageName() + ".information"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ProjectInformation() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		
		}
	}
}
