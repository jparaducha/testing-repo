package carinaAutomationHomework.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

@ResponseTemplatePath(path = "api/posts/_get/response.json")
@Endpoint(url = "${base_url}/posts", methodType = HttpMethodType.GET)
public class GetPostAutomation extends AbstractApiMethodV2 {
    public GetPostAutomation (){
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
