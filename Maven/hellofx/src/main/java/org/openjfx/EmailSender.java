package org.openjfx;

public class EmailSender {

    public static void Activate() {

        //Email Formatting
        try {
            //Open mail client with "receiver", "subject", "message"
            composeEmail("pknoebel@gccschools.com",
                    "Student Absence Notification",
                    "Hello,\nI am parent/guardian of " + EmailToolController.ChildName + ", and I am writing to inform you that my child " +
                            "will be absent from school on: "+ EmailToolController.Date +"\n\nbecause:\n"+EmailToolController.Reason+
                            "\n\nThank you very much, \n " + EmailToolController.AdultName);
        }
        catch (Exception err) {
            err.printStackTrace();
        }
        System.out.println("~~~COMPLETED~~~");
    }

    //Generating mailto-URI.
    public static void composeEmail(String receiver, String subject, String body) throws Exception {

        //Create OS-specific run command
        String cmd = "";
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System: " + os); // Debugging output

        if (os.contains("win")) {
            String mailto = "mailto:\"" + receiver;
            mailto += "?subject=" + uriEncode(subject);
            mailto += "&body=" + uriEncode(body) + "\"";
            cmd = "cmd.exe /c start " + mailto;
        } else if (os.contains("mac") || os.contains("darwin")) {
            String mailto = "mailto:" + receiver;
            mailto += "?subject=" + uriEncode(subject);
            mailto += "&body=" + uriEncode(body);
            cmd = "open " + mailto;
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            String mailto = "mailto:" + receiver;
            mailto += "?subject=" + uriEncode(subject);
            mailto += "&body=" + uriEncode(body);
            cmd = "xdg-open " + mailto;
        } else {
            throw new UnsupportedOperationException("Operating system not supported: " + os); // Default case
        }

        //Call default mail client with parameters
        Runtime.getRuntime().exec(cmd);
    }

    //URI Encoding
    private static String uriEncode(String in) {
        String out = new String();
        for (char ch : in.toCharArray()) {
            out += Character.isLetterOrDigit(ch) ? ch : String.format("%%%02X", (int)ch);
        }
        return out;
    }
}