
package com.gotraveling.insthub.ecmobile.protocol;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.gotraveling.external.activeandroid.Model;
import com.gotraveling.external.activeandroid.annotation.Column;
import com.gotraveling.external.activeandroid.annotation.Table;

@Table(name = "goodsResponse")
public class goodsResponse  extends Model
{

     @Column(name = "status")
     public STATUS   status;

     @Column(name = "data")
     public GOODS   data;

     public void  fromJson(JSONObject jsonObject)  throws JSONException
     {
          if(null == jsonObject){
            return ;
           }

          JSONArray subItemArray;
          STATUS  status = new STATUS();
          status.fromJson(jsonObject.optJSONObject("status"));
          this.status = status;
          GOODS  data = new GOODS();
          data.fromJson(jsonObject.optJSONObject("data"));
          this.data = data;
          return ;
     }

     public JSONObject  toJson() throws JSONException 
     {
          JSONObject localItemObject = new JSONObject();
          JSONArray itemJSONArray = new JSONArray();
          if(null != status)
          {
            localItemObject.put("status", status.toJson());
          }
          if(null != data)
          {
            localItemObject.put("data", data.toJson());
          }
          return localItemObject;
     }

}
