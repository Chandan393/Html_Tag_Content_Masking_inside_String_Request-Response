import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class maskAttribute {
   public static void main(String[] args) {
     
    String  str = "Mask the <b:Signature>Masking_the_last_10_characters_of_the_Signature_tag_after_extracting_it_from_the_Signature_tag_of_String_Request/Response_=abcde12345</b:Signature>";
    String password = "<h1>Extracting the password tag content from the String Request/Response and masking all the Characters of the password except the First 3 Characters</h1><d:Password>Sample@123</d:Password>";
    
           String Signature = maskSignature(str);
           String Password = maskPassword(password);

           System.out.println(Signature);
           System.out.println(Password);

      }
      public static String maskSignature(String string) {
         Pattern pattern = Pattern.compile("<b:Signature>(\\S+)</b:Signature>");
         Matcher matcher = pattern.matcher(string);
         if (matcher.find()) {
             String result = matcher.group(1);
             String result1 = result;
             String str = result.substring(result.length() - 10, result.length());
             str = str.replaceAll(".", "*");
             result = result.substring(0, result.length() - 10);
             string = string.replace(result1,result.concat(str));
         }
         return string;
     }
     public static String maskPassword(String password) {
        Pattern pattern = Pattern.compile("<d:Password>(\\S+)</d:Password>");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            String result = matcher.group(1);
            String result1 = result;

            result = result.replaceAll("(?<=...).", "*");
            password = password.replace(result1, result); 
        }
        return password;
    }
   }
