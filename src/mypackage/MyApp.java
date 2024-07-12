package mypackage;

import net.rim.device.api.ui.UiApplication;

/**
 * This class extends the UiApplication class, providing a
 * graphical user interface.
 */
public class MyApp extends UiApplication
{
	
	public static MyScreen home;
	public static AboutScreen about;
	public static NewAlarmScreen newalarm;
	
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        MyApp theApp = new MyApp();       
        theApp.enterEventDispatcher();
    }
    

    /**
     * Creates a new MyApp object
     */
    public MyApp()
    {
    	home = new MyScreen();
    	about = new AboutScreen();
    	newalarm = new NewAlarmScreen();
    	
        // Push a screen onto the UI stack for rendering.
        PushHomeScreen();
    }
    
    /**
     * Pushes About screen
     */
    public void PushAboutScreen() { pushScreen(about); }
    
    /**
     * Pushes Home screen
     */
    public void PushHomeScreen() { pushScreen(home); }
    
    /**
     * Pushes New alarm screen
     */
    public void PushNewAlarmWizard() { pushScreen(newalarm); }
}
