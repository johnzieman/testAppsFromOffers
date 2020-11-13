package ziemansoft.ziemapp.testapp.remote;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ziemansoft.ziemapp.testapp.pojo.Responce;

public interface NetworkService {
    //http://click-safety.com/test_task/test_do_not_run.php?id=lover
    @GET("test_task/test_do_not_run.php")
    Observable<Responce> getResponceObject(@Query("id") String text);
}
