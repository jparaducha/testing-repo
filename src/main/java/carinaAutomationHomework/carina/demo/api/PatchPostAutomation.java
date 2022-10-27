package carinaAutomationHomework.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PatchPostAutomation extends AbstractApiMethodV2 {
    public PatchPostAutomation(){
        super("api/users/_patch/request.json",
                "api/users/_patch/response.json",
                new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
