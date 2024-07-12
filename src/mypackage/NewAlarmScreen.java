package mypackage;

import net.rim.device.api.i18n.DateFormat;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.component.*;

/* This, in fact, also usable for editing existing alarms. A TODO list item. */
public final class NewAlarmScreen extends MainScreen
{
	private ObjectChoiceField enableOptions;
	private ObjectChoiceField scheduleOptions;
	protected ButtonField doItButton;
	
	public NewAlarmScreen()
	{
		setTitle("New alarm");

		VerticalFieldManager mainField = new VerticalFieldManager();
		mainField.setPadding(20, 20, 20, 20);
		
		// enable or not?
		String[] enableOpts = {"Yes", "No"};
		enableOptions = new ObjectChoiceField("Enabled?", enableOpts, 0);
		mainField.add(enableOptions);
		
		// date field
		DateFormat dateFormat = DateFormat.getInstance(DateFormat.AM_PM_FIELD | DateFormat.HOUR_FIELD | DateFormat.MINUTE_FIELD);
		DateField dateField = new DateField("Time", Long.MIN_VALUE, dateFormat, DateField.TIME);
		mainField.add(dateField);
		
		// schedule options
		mainField.add(new LabelField("Schedule options"));
		String[] scheduleOpts = {"Everyday", "Weekends", "Weekdays", "Custom"};
		scheduleOptions = new ObjectChoiceField("Schedule", scheduleOpts, 0);
		mainField.add(scheduleOptions);
		
		FieldChangeListener enableListener = new FieldChangeListener()
		{
			public void fieldChanged(Field field, int context)
			{
				enableOptions.getSelectedIndex();
			}
		};
		enableOptions.setChangeListener(enableListener);
		
		// sound
		// and more stuff here...
		
		mainField.add(new SeparatorField(SeparatorField.LINE_HORIZONTAL));
		
		// create button
		doItButton = new ButtonField("Create", ButtonField.CONSUME_CLICK | Field.FIELD_TRAILING);
		mainField.add(doItButton);
		
		add(mainField);
	}
	
	protected void makeMenu(Menu menu, int instance)
	{
		super.makeMenu(menu, instance);
		MenuItem customSchedule = new MenuItem("Custom schedule...", 0, 0)
		{
			public void run() {}
		};
		menu.add(customSchedule);
	}
}