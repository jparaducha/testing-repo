package carinaAutomationHomework.carina.demo;


import carinaAutomationHomework.carina.demo.api.GetPostAutomation;
import carinaAutomationHomework.carina.demo.api.PatchPostAutomation;
import carinaAutomationHomework.carina.demo.api.PostPostAutomation;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class APIAutomationHomework {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test()
    @MethodOwner(owner = "paraducha")
    public void TestGetPost (){
        GetPostAutomation getPostAutomation = new GetPostAutomation();
        getPostAutomation.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPostAutomation.callAPI();
        getPostAutomation.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostAutomation.validateResponseAgainstSchema("api/users/_get/response.schema");
    }


    @Test()
    @MethodOwner(owner = "paraducha")
    public void TestPostPost (){

        PostPostAutomation api = new PostPostAutomation();
        api.setProperties("api/users/user.properties");


        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }


    @Test()
    @MethodOwner(owner = "paraducha")
    public void TestPostWithMissingField (){

        PostPostAutomation api = new PostPostAutomation();
        api.setProperties("api/users/post2.properties");


        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }



    @Test
    @MethodOwner(owner = "paraducha")
    public void TestPatchPost(){

        PatchPostAutomation api = new PatchPostAutomation();
        api.setProperties("api/users/user.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

}
