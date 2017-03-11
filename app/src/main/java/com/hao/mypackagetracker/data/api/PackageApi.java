package com.hao.mypackagetracker.data.api;

import com.hao.mypackagetracker.data.bean.Package;
import com.hao.mypackagetracker.data.bean.PackageCompany;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by haohao on 2017/3/10.
 */

public interface PackageApi {

    /** API Url */
    String API_HOST = "http://www.kuaidi100.com/";

    /**
     * 获取快递公司列表
     */
    String COMPANY_LIST_URL = API_HOST + "/js/share/company.js";

    /**
     * 自动匹配公司
     *
     * @param text 快递号
     * http://www.kuaidi100.com/autonumber/autoComNum?text=70388432404380
     */
    String COMPANY_DETECT_URL = API_HOST + "/autonumber/autoComNum?text=%s";
    @GET("autonumber/autoComNum?")
    Observable<PackageCompany> getCompany(@Query("text") String number);

    /**
     * 请求快递信息
     *
     * @param type 快递公司
     * @param postid 快递单号
     * http://www.kuaidi100.com/query?type=huitongkuaidi&postid=70388432404380
     */
    String QUERY_URL = API_HOST + "/query?type=%1$s&postid=%2$s";
    @GET("query?")
    Observable<Package> getPackage(@Query("type") String companyName,
                                   @Query("postid") String number);

}
