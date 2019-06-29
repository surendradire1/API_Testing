package scripts;
import common.CommonActions;
import filehandling.PropertyFileHandler;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assessment {

		public JsonPath jsonPathEval;
		public Response res;
		public PropertyFileHandler prop;
		
		//Set the base url and get the response in json format
		@BeforeClass
		public void setUp() {
			RestAssured.baseURI= "https://api.tmsandbox.co.nz";
			RestAssured.defaultParser = Parser.JSON;
			res = given().get("/v1/Categories/6327/Details.json");
			jsonPathEval = res.jsonPath();
			prop=new PropertyFileHandler();
		}
		
		@Test()
		//Verify response that value of name is "Carbon credits"
		public void verifyName_tc01(){
			Assert.assertEquals(jsonPathEval.get("Name"), prop.readProperties("Name") , "Verify response that value of name is as Carbon credits");
		}
	
		@Test()
		//Verify response contains value "Carbon credits" as true
		public void verifyCatalogue_tc02(){
			Assert.assertEquals(jsonPathEval.get("CanRelist").toString(), prop.readProperties("CanRelist"), "Verify response contains value of Carbon credits as true");
		}
	
		@Test()
		//Verify that promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"
		public void verifyDescriptionOfGallary_tc03(){
			List<Map<String, String>> lstPromotions = jsonPathEval.getList(prop.readProperties("Promotions"));
			Assert.assertEquals(CommonActions.verifyPromotion(lstPromotions), true , "Verify that promotions element with Name Gallery has a Description that contains the text as 2x larger image");
		}

		@AfterClass
		public void tearDown() {
			prop=null;
		}
		
	}
	




