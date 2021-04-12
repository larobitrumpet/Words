import java.io.*;

public class Words
{
    public static void main(String args[])
    {
        String word = "test";
        String api_key = "2a3de104-6904-436b-8a5e-93227974a936";
        try
        {
            String out = getWord(word, api_key);
            System.out.println(out);
        }
        catch(IOException e)
        {
            e.printStackTrace();
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
}
