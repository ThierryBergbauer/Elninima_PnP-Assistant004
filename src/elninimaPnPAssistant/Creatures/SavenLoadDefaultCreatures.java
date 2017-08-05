package elninimaPnPAssistant.Creatures;
import com.google.gson.Gson;

public class SavenLoadDefaultCreatures 
{
	public void writeToJson(Object javaObject)
	{
		Gson gson = new Gson();
		String jsonString = null;
		try {
			jsonString = gson.toJson(javaObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
