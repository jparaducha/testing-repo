package carinaAutomationHomework.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

@RequestTemplatePath(path = "api/posts/_patch/request.json")
@ResponseTemplatePath(path = "api/posts/_patch/response.json")
@Endpoint(url = "${base_url}/posts/${postId}", methodType = HttpMethodType.PATCH)
public class PatchPostAutomation extends AbstractApiMethodV2 {
    public PatchPostAutomation(){
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("postId", "1");
    }
    public PatchPostAutomation(String postId){
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("postId", postId);
    }
}
