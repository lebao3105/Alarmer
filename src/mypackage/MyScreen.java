package mypackage;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.UiApplication;

//class AlarmsListField extends ListField implements ListFieldCallback
//{
//	private AlarmStore alarmStore;
//	
//	public AlarmsListField()
//	{
//		super(0);
//		alarmStore = new AlarmStore();
//		setCallback(this);
//		setSize(alarmStore.alarms.length);
//	}
//	
//	public int indexOfList(ListField listField, String prefix, int start)
//	{
//		for (int i = start; i < alarmStore.alarms.length; i++) {
//			if (alarmStore.alarms[i].when.startsWith(prefix))
//				return i;
//		}
//		return -1;
//	}
//	
//	public Object get(ListField listField, int index)
//	{
//		String result;
//		Alarm alarm = alarmStore.alarms[index];
//		result = alarm.when + " [" + alarm.howoften[0] + "] " + alarm.howoften[1];
//		return result;
//	}
//	
//	public void drawListRow(ListField listField, Graphics graphics, int index, int y, int width)
//	{
//		graphics.drawText((String) get(listField, index), 0, y);
//	}
//	
//	public int getPreferredWidth(ListField listField)
//	{
//		return Display.getWidth();
//	}
//}

/**
 * A class extending the MainScreen class and showing a list of alarms.
 */
public final class MyScreen extends MainScreen
{
    /**
     * Creates a new MyScreen object
     */
    public MyScreen()
    {        
        // Set the displayed title of the screen       
        setTitle("Alarmer");
        
        ListField list = new ListField();
        add(list);
    }
	
    /* Menu triggerable by pressing BlackBerry key */
    protected void makeMenu(Menu menu, int instance)
    {
    	MenuItem newAlarm = new MenuItem("New alarm...", 0, 0)
    	{
    		public void run() { ((MyApp) UiApplication.getUiApplication()).PushNewAlarmWizard(); }
    	};
    	
    	MenuItem aboutThis = new MenuItem("About this app", 0, 0)
        {
            public void run() { ((MyApp) UiApplication.getUiApplication()).PushAboutScreen(); }
        };
    	
        MenuItem close = new MenuItem("Close", 0, 0)
        {
        	public void run() { System.exit(0); }
        };
        
    	menu.add(newAlarm);
        menu.add(aboutThis);
        menu.addSeparator();
        menu.add(close);
    }
    
    public boolean onClose()
    {
    	UiApplication.getUiApplication().requestBackground();
    	return super.onClose();
    }
}
