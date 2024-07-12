package mypackage; /* How to change this? */

import net.rim.device.api.command.Command;
import net.rim.device.api.command.CommandHandler;
import net.rim.device.api.command.ReadOnlyCommandMetadata;
import net.rim.device.api.system.Characters;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Keypad;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

/**
 * A class which provides informations about this project.
 */
public final class AboutScreen extends MainScreen
{
    public AboutScreen()
    {
        setTitle("About this project");
        
        VerticalFieldManager mainField = new VerticalFieldManager();
        mainField.setPadding(20, 20, 20, 20);

        LabelField projName = new LabelField("Alarmer");
        LabelField projVers = new LabelField("v1.0.0");

        // set the font for the title
        try
        {
            FontFamily sysFontFamily = FontFamily.forName(FontFamily.FAMILY_SYSTEM); // this can throw error
            Font titleFont = sysFontFamily.getFont(Font.BOLD, 14, Ui.UNITS_pt);
            Font subtitleFont = sysFontFamily.getFont(Font.LATIN_SCRIPT, 12, Ui.UNITS_pt);
            projName.setFont(titleFont);
            projVers.setFont(subtitleFont);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // repo open button
        ButtonField repoBtn = new ButtonField("Repository", ButtonField.CONSUME_CLICK);
        repoBtn.setCommand(new Command(new RepoBtnClickHandler()));

        mainField.add(projName);
        mainField.add(projVers);
		mainField.add(new SeparatorField(SeparatorField.LINE_HORIZONTAL));
        mainField.add(new LabelField("An alarm app for BlackBerry!"));
        mainField.add(new LabelField("Made by Le Bao Nguyen. Licensed under GNU GPL 3."));
        mainField.add(repoBtn);

        add(mainField);
    }
    
    protected boolean keyDown(int keycode, int time) {  
        int key = Keypad.key(keycode);
        if (key == Characters.ESCAPE){
            close(); // avoid "Changes made!" dialog
            return true;
        }
        return super.keyDown(keycode, time);
    }
}

class RepoBtnClickHandler extends CommandHandler
{
    public void execute(ReadOnlyCommandMetadata metadata, Object context)
    {
        Dialog.inform("Open this link: gitlab.com/lebao3105/Alarmer\n(no signing method to open the link in browser)");
    }
}