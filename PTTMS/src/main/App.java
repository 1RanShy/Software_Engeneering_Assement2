package main;

import main.Controller.Controller;

public class App {
	/**
	 * Program entry function, start the project
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		App app = new App();
		app.start();
	}

	public App() {
	}

	public void start() {
		// Singleton
		Controller ctrl = Controller.getInstance();
		while (true) {
			// log verify and return current user's staffID
			String currentUser = ctrl.logVerify();
			// Boolean flag = true;
			// According to different user identity, call different session
			switch (currentUser.charAt(1)) {
				case 'c':
					ctrl.runClassDirectorSession();
					break;
				case 'a':
					ctrl.runAdministratorSession();
					break;
				case 'p':
					ctrl.runPTTSession();
					break;
			}
		}
	}
}
