package APIs;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class CreateNode {

	@Test
	public void NodeCreate() {

		RestAssured.baseURI = "http://api.e2enetworks.com";

		Response res=given().
				param("name", "truetest")
				.param("region", "ncr")
				.param("plan", "C-4vCPU-12RAM-100DISK-C2.12GB-CentOS-7.5")
				.param("image", "CentOS-7.5-Distro")
				.param("ssh_keys",
						"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDYzhkPZUcRal9oBGE6E91xdthkc0p4AHaT24Idh+32KeD7YpERJemuuWYgapFd6IXMRb7G+OjXwDna0TyyH5CUBgnOnSWov3kyFzkrqdchJDVYM4uW+RIk1bVhKJjGqR7/s+8U6Fg/1m8ptpIRh1U5pAJe2+H1e8fitoi2F3MCeXa8kaoL66iB9Y/Xekdo0zQjtkws/BgBR0JJwJZapcqJPNK1RipXjQ4Krc69tXr1EC8oWmXrU7sYstxgrL+mAMUCvpxSweblU6lUjR+CIiO7gVPQQVXWth3u8Sc66ci8OF/QV6PoghQzfKZ0RFTjMmhiapxXigrjfDD/cNUAfBO1 abhinav.garg@e2enetworks.com\r\n")
				.param("backups", "false")
				.

				header("x-api-key", "176b1cb1-eb00-45be-8815-fba6939dce6f").

				header("Authorization",
						"Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjejBXYVVKVF9wWmE5MXNpRl9QRXVxUUpqdm5VODhsMXdsVmNla1ZiUXBRIn0.eyJqdGkiOiI0NzhjMmVjOC0zZTgwLTRlZjMtYjU0YS03MWY0NmFmZjc4NzYiLCJleHAiOjE2MTQwNzUzMzEsIm5iZiI6MCwiaWF0IjoxNTgyNTM5MzMxLCJpc3MiOiJodHRwOi8vZ2F0ZXdheS5lMmVuZXR3b3Jrcy5jb20vYXV0aC9yZWFsbXMvYXBpbWFuIiwiYXVkIjoiYXBpbWFudWkiLCJzdWIiOiI3MjUxNGRiNC1hZDYzLTQ0OTYtYTQwYy0zYTBhMDUzMGUwNjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcGltYW51aSIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjAzYmM5ZDk4LThlZDItNDg4Ni1iZjAyLTkxOGVjNTE1ZTBiNiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOltdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsidW1hX2F1dGhvcml6YXRpb24iLCJhcGl1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwibmFtZSI6IlRlc3QgUHJvZCIsInByZWZlcnJlZF91c2VybmFtZSI6ImFiaGluYXYuZ2FyZytwcm9kY2FyZEBlMmVuZXR3b3Jrcy5jb20iLCJnaXZlbl9uYW1lIjoiVGVzdCIsImZhbWlseV9uYW1lIjoiUHJvZCIsImVtYWlsIjoiYWJoaW5hdi5nYXJnK3Byb2RjYXJkQGUyZW5ldHdvcmtzLmNvbSJ9.gu8Pmc-bzjcpY_gUeJ-3mXgzCIjlHKcyaGc-aA6FQjtQUVlbofxQpp32vYJadLUjdJc9kswC0fSLj0DxpaXzyTGdQFwo1skubXsjufU4IDafhVNfZx771e72i3lSiBgA2G_0RKodq27fVkrPpCYMCMQYcnwa2mJf8iMWotv8ULbP_wI0lef3uFZl1fW1T-HIkwoLk_uVyEzFxruhZrjafXhAny5obEpL5cAmcsTan2p-IPFplsZ-K4i1BNcfdf3thIOEzTKw-Evh5MB13W7fYZPDyywSqPJs3xG5vEuIaUr-sXJmneQcxwheU5BNLnYu2i9aeUgtb15GVqTZVFUNdQ")
				.

				when().post("/myaccount/api/v1/nodes/").then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and()
				.body("data.plan", equalTo("C2.12GB")).and()
				.body("data.name", equalTo("truetest")).and()
				.body("data.status", equalTo("Creating"))
		.extract().response();
		String responseString = res.asString();
		System.out.println(responseString);
		JsonPath js= new JsonPath(responseString);
		String data =js.getString("data");
		System.out.println(data);
		
		
	}

	}


