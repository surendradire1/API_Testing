package common;
import java.util.List;
import java.util.Map;
import io.restassured.path.json.JsonPath;


public class CommonActions {
	
	//static JsonPath jsonPathEval;
	//JsonPath jsonPathEval;
	/*
	* This method reads the data into list of map from a particular node in the response and verifies the description value based on name attribute value
	* @return boolean
	* @param list of array
	* @throws Exception
	*/
	
	public static boolean verifyPromotion(List<Map<String, String>> lstPromotions){
		boolean result=false;
		try{
		for (int i=0; i<lstPromotions.size(); i++){
			if (lstPromotions.get(i).get("Name").equals("Gallery") && lstPromotions.get(i).get("Description").contains("2x larger image")){
				result=true;
				break;
			}else {
				result=false;
			}
		 }
		}
		catch(Exception e)
		{
			System.out.println(lstPromotions + " not found in the response. Error Message : "+ e.getStackTrace());
		}
		return result;
	}
	
	/*
	* This method reads the data from the node from the Json and returns its value
	* @return value of json object key
	* @param key of json object
	* @throws Exception
	*/
	
	public static String returnJsonKeyValue(JsonPath jsonPathEval, String jsonKey){
		String result = null;
		try{
			result=jsonPathEval.get(jsonKey);
		} catch(Exception e)
		{
			System.out.println("jsonKey " + "is not found in the response. " + "Error Message : "+ e.getStackTrace());
		}
		return result;
	}
	
}
