import java.io.*;
import com.google.gson.*;

public class Words
{
    public static void main(String args[])
    {
        String word;
        String api_key = "2a3de104-6904-436b-8a5e-93227974a936";
        if (args.length > 0)
        {
            for (int i = 0; i < args.length; i++)
            {
                word = args[i];
                try
                {
                    String out = getWord(word, api_key);
                    String[] def = parseJSON(out);
                    for (int j = 0; j < def.length; j++)
                    {
                        System.out.println(def[j]);
                    }
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("No words were given");
        }
    }

    public static String getWord(String word, String api_key) throws IOException
    {
        String command = "curl https://dictionaryapi.com/api/v3/references/collegiate/json/" + word + "?key=" + api_key;
        Process process = Runtime.getRuntime().exec(command);
        return getOutput(process);
    }

    public static String getOutput(Process process) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        String output = "";
        while ((line = reader.readLine()) != null)
        {
            output = output + line + "\n";
        }
        return output;
    }

    public static String[] parseJSON(String json)
    {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(json).getAsJsonArray();
        String[] def = gson.fromJson(array.get(0).getAsJsonObject().get("shortdef"), String[].class);
        return def;
    }
}
