package carinaAutomationHomework.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

@RequestTemplatePath(path = "api/posts/_post/request2.json")
@ResponseTemplatePath(path = "api/posts/_post/response2.json")
public class PostPostAutomation2 extends AbstractApiMethodV2 {
    public PostPostAutomation2 () {
        /*
        super("api/posts/_post/request2.json",
                "api/posts/_post/response2.json",
                new Properties());
         */
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
