//package mypackage;
//
//import javax.microedition.io.Connector;
//import javax.microedition.io.file.FileConnection;
//
//import java.io.DataInputStream;
//import java.io.InputStream;
//
//import net.rim.device.api.ui.component.Dialog;
//
//import org.json.me.JSONArray;
//import org.json.me.JSONException;
//import org.json.me.JSONObject;
//import org.json.me.JSONWriter;
//
//// an example of this metadata file:
//// {
////     "alarms": [
////         {
////             "when": "6:00 AM",
////             "howoften": ["Custom", "0 1 2 3 4"]
////         }
////     ]
//// }
//
//final class Alarm extends JSONObject {
//
//	/**
//	 * When will this alarm ring. 
//	 */
//	public String when;
//	
//	/**
//	 * Schedule of the alarm.
//	 * The first item is one of "Everyday", "Weekends", "Weekdays", "Custom".
//	 * The second one is selected days (integer from 0 = Monday) if "Custom" is used,
//	 * else an empty string.
//	 */
//	public String[] howoften = {};
//	
//	Alarm() {
//		try
//		{
//			when = (String) getString("when");
//			JSONArray arr = getJSONArray("howoften");
//			howoften[0] = arr.getString(0);
//			howoften[1] = arr.getString(1);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//};
//
//public final class AlarmStore {
//	public String storePath; // the path of the data file - not implemented
//	public Alarm[] alarms = {};
//	
//	private FileConnection fcon;
//	private JSONObject jsonObject;
//	
//	AlarmStore() {
//		try {
//			fcon = (FileConnection) Connector.open("file:///store/home/user/documents/Alarmer.json",
//												   Connector.READ_WRITE);
//			if (!fcon.exists())
//			{
//				fcon.create();
//				fcon.openDataOutputStream().writeUTF(new JSONObject().put("alarms", new JSONArray()).toString());
//			}
//			
//			DataInputStream is = fcon.openDataInputStream();
//			String fileRead = is.readUTF();
//			System.err.println("[Alarmer] Reading metadata... " + fileRead);
//			Dialog.alert(fileRead);
//			
//			jsonObject = new JSONObject(fileRead);
//			
//			JSONArray list_of_alarms = jsonObject.getJSONArray("alarms");
//			
//			for (int i = 0; i < list_of_alarms.length(); i++)
//			{
//				alarms[alarms.length] = (Alarm) list_of_alarms.getJSONObject(i);
//			}
//			
//			fcon.close();
//		}
//		
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.err.print(e.getMessage());
//		}
//	}
//}
//
