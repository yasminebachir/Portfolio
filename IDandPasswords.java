package LoginSystem;

import java.util.HashMap;

public class IDandPasswords {
    
    // for this part, i'll create hash map because they store key value pairs

    HashMap<String,String> logininfo = new HashMap<String, String>();

    IDandPasswords(){

        logininfo.put("user123", "ottawa123$");
        logininfo.put("user546", "Ottawa456");
        logininfo.put("User0", "Canada1$");
    }


    protected HashMap getLoginInfo(){ // 
        return logininfo; 
    }
}
