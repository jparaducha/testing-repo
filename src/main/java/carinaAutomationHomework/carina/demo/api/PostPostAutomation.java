package carinaAutomationHomework.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@RequestTemplatePath(path = "api/posts/_post/request.json")
@ResponseTemplatePath(path = "api/posts/_post/response.json")
public class PostPostAutomation extends AbstractApiMethodV2 {
    public PostPostAutomation(){
        /*
        super("api/posts/_post/request.json",
                "api/posts/_post/response.json",
                "api/posts/user.properties");

         */
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
