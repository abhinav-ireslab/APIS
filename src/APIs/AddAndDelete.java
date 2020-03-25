package APIs;

import java.util.List;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;


public class AddAndDelete {

	@Test
	public void postdata() {

		String b = "{"
				+ "\"name\":\"devendra12\","
				+ "\"region\": \"hyd@#\","
				+ "\"plan\": \"B-2VCPU-8RAM-115DISK\","
				+ "\"image\": \"Ubuntu-Distro\","
				+ "\"ssh_keys\": \"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCoSTieYJU4NkxXhpDOZZqVckrzwYxbQm8yTPXJPvOBuYXVIvlPLeUcSAsFaCFz19cDHm9Z8/QIHWeoS8UsFYunFbvNVZ5GFYXB7eRRPk2i15w09YUeSokT2ZJ73BmRHMvwhS/W075YmEJy27Taxlv+rDRc7qVJElvGJsw9WVyCKB0dMbrew+ZjP7YrL2oV9Ig/M70rmzwk5GxchGtAUakC2ywWvvqY5AZG5P5gJWs/KOBCqMj+/UCeSMt35eoIj8gGghru+Js+pKNjkL5mt3liNWrfXUS+XgK97Op4DOsaI5xFSJqFdNj/lZaeaQIQJGrR/q82UKrQ4OQsO2jaFxul E2E@LAPTOP-I2DQ2R0M\","
				+ "\"backups\": \"false\""+ "}";

		RestAssured.baseURI = "http://api.e2enetworks.com";
		Response res = given()
				.queryParam("x-api-key", "6b0f9f4d-cfe3-411d-b548-3c9cad62dd6f")

				.

				queryParam("Authorization",
						"Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjejBXYVVKVF9wWmE5MXNpRl9QRXVxUUpqdm5VODhsMXdsVmNla1ZiUXBRIn0.eyJqdGkiOiI0M2I4ZTY1OS05ZTdlLTRmZTctYmMyZi1iZDk2ODM5OTEzOWQiLCJleHAiOjE1OTY3MDM5NTAsIm5iZiI6MCwiaWF0IjoxNTY1MTY3OTUwLCJpc3MiOiJodHRwOi8vZ2F0ZXdheS5lMmVuZXR3b3Jrcy5jb20vYXV0aC9yZWFsbXMvYXBpbWFuIiwiYXVkIjoiYXBpbWFudWkiLCJzdWIiOiJjMmM2MGQ5MS0yODBmLTRhYTQtYjBjZi0xNDU4MWZiMTVmMmMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcGltYW51aSIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjcxNzJmNTE5LTc2M2EtNDQ1Ni1iZGY1LWJjMTg1MzQ1MjFkYSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOltdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsidW1hX2F1dGhvcml6YXRpb24iLCJhcGl1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwibmFtZSI6IkFiaGluYXYgR2FyZyIsInByZWZlcnJlZF91c2VybmFtZSI6ImFiaGluYXYuZ2FyZytwb3N0cGFpZEBlMmVuZXR3b3Jrcy5jb20iLCJnaXZlbl9uYW1lIjoiQWJoaW5hdiIsImZhbWlseV9uYW1lIjoiR2FyZyIsImVtYWlsIjoiYWJoaW5hdi5nYXJnK3Bvc3RwYWlkQGUyZW5ldHdvcmtzLmNvbSJ9.es7axCcx85N8EIA3F4DhnwIaz1Whr-5uGpAdyoJ3Wwjr8aACw3m_sfJ3vr-n0_Q0wr2Wepoj3TB5kwTaeA2ePfHdaSprpHuvPET4S_LHWoM8m4yT597iGdlmNP6ZMwfIaKwvfKttwYlGpEFLVInB_lVwQRaWwx6xCO0-jz9e0hWfRuK88iLo-PdBD52xSGovjc9qfBU2b_YmWdBqKKaZO41B76X42uAJIoXZKYCDx6xs2QBdEwgR7_8GhwNSGE945uyxgLcmcgFPkouDovQ0lopZngTopxGpO9EECVEV6TbvUa4uZiIc8iM97nVtX2l14HWkKpOQh7Lpq06gFrD-0A")
				.body(b).

				when().post("/myaccount/nodes/v1/").then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and()
				.body("data.plan", equalTo("B-2VCPU-8RAM-115DISK")).and()
				.body("data.name", equalTo("devendra12")).and()
				.body("data.status", equalTo("Create")).extract().response();
		String responseString = res.asString();
		System.out.println(responseString);

	}		
	
	
}
	/*
		public static void main(String[] args) {
	        
	        List<String> jsonResponse = res.jsonPath().getList("$");

	        System.out.println(jsonResponse.size());

	    }
	}

*/