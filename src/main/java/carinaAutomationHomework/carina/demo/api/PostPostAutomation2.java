package carinaAutomationHomework.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PostPostAutomation2 extends AbstractApiMethodV2 {
    public PostPostAutomation2 () {
        super("api/users/_post/request2.json",
                "api/users/_post/response2.json",
                new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
