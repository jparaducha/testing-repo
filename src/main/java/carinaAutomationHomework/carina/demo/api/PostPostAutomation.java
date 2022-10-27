package carinaAutomationHomework.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostPostAutomation extends AbstractApiMethodV2 {
    public PostPostAutomation(){
        super("api/users/_post/request.json",
                "api/users/_post/response.json",
                "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
