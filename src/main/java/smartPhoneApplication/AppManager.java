package smartPhoneApplication;

import java.util.ArrayList;
import java.util.List;

public class AppManager {

	List<App> appList = new ArrayList<>();

	public void addApp(App app) {
		this.appList.add(app);
	}

	public void addAppToPhone(Phone phone, App app) {
		phone.getAppList().add(app);
	}

	public void deleteAppFromPhone(Phone phone, App app) {
		phone.getAppList().remove(app);
	}

	public void updateAppInPhone(Phone phone, App app, String newVersion) {
		for (App a : phone.getAppList()) {
			if (a.equals(app)) {
				app.setVersion(newVersion);
			}
		}
	}
}
