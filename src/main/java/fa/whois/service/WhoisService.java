package fa.whois.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fa.browserUtils.Utils;
import fa.whois.model.Data;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.ParameterBinding.Anonymous;

@Service
public class WhoisService {

	
	public Data scrapWhois(String ip) throws InterruptedException {
		System.out.println("le ip que vous aviez soumis est "+ip);
		Data data=new Data();
		String driverPath="C:\\ChromeDriver\\";
		ChromeDriver cd= Utils.chromeConstruct(driverPath, 600, 600, 6000, PageLoadStrategy.NORMAL, false);
		cd.get("https://www.crawl-tools.com/fr/whois-client/");
		boolean domContentLoad=Utils.listensIfPageFullyLoaded(cd);
		if(domContentLoad) {
			 String js="var q='"+ip+"'; console.log('new task');"
						+ " var n_arg = new Object();"
						+ " n_arg[\"task\"] = 'pnet_whois_client';"
						+ "/* URL à tester*/"
						+ " n_arg[\"q\"] = q;"
					    + " n_arg[\"sid\"] = document.getElementById('request_token').value;"
						+ " $.ajax({"
						+ "  url: 'https://www.crawl-tools.com/ptool_ui.php',"
						+ "  type: 'POST',"
						+ "  data: n_arg,"
						+ "  cache: false,"
						+ "  dataType: \"text\","
						+ "  contentType: \"application/x-www-form-urlencoded;charset=UTF-8\","
						+ "  success: function (response, status) {"
						+ "                try {"
						+ "                    var obj = JSON.parse(response);"
						+ "                    console.log(obj);"
						+ "                    if (obj.result.task_token && obj.result.task_token.length == 32) {"
						+ "                        window.location = 'https://www.crawl-tools.com/fr/whois-client/' + obj.result.task_token;"
						+ "                    } else {"
						+ "                        raise_error('erreur interne' + response);"
						+ "                    }"
						+ "                } catch (e) {"
						+ "                    raise_error('erreur interne' + response);"
						+ "                }"
						+ "            },"
						+ "            error: function (result, statut, erreur) {"
						+ "                raise_error(result.responseText);"
						+ "  }"
						+ "});";
				System.out.println(js);
				JavascriptExecutor jsExec=(JavascriptExecutor)cd;
				jsExec.executeScript(js);	
		}
	   

		String sourcePage=cd.getPageSource();
		while(sourcePage.contains("https://www.crawl-tools.com/ptool_ui.php")) {
			sourcePage=cd.getPageSource();
		}
		WebDriverWait wait = new WebDriverWait(cd, 300);
		WebElement section=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.section.blue-pastel")));
		
		sourcePage=cd.getPageSource();
		Document doc=Jsoup.parse(sourcePage);
			//retrieve data about ip
		Elements resultsHead=doc.select("body > div.section.bg-white > div > div > table > tbody>tr");
		String addresse="",
				   type="",
				   creation="",
				   state="",
				   localisation="",
				   reputation="",
				   anonymous="",
				   usage="",
				   source="",
				   hostName="";
		if(resultsHead!=null) {
				
				int i=0;
				
				for(Element resultHead:resultsHead) {
					 Element tmp=resultHead.selectFirst("td:nth-child(2)");
					
					switch(i) {
				       case 0:{
				    	   addresse=tmp.text();
				    	   System.out.println("l'adresse ip est "+addresse);
				    	   break;
				       }
				       case 1:{
				    	   type=tmp.text();
				    	   System.out.println("le type de l'adresse ip est "+type);
				    	   break;
				        }
				       case 2:{
				    	   creation=tmp.text();
				    	   System.out.println("la creation de la response eu requête est "+creation);
				    	   break;
				        }
				       case 3:{
				    	   state=tmp.text();
				    	   System.out.println("etat de la requête est "+ state);
				    	   break;
				        }
				    }
					i++;
				}
				data.setAddress(addresse)
				.setType(type)
				.setDateCreation(creation)
				.setState(state);
			}
			
			//retrieve IP properties
			Elements propertiesElements=doc.select("body > div:nth-child(6) > div > "
					+ "div.result-task-left > table > tbody > tr");
			if(propertiesElements!=null) {
				int i=0;
				for(Element propertyElement: propertiesElements) {
					 Element tmp=propertyElement.selectFirst("td:nth-child(2)");
						switch(i) {
					       case 0:{
					    	   localisation=tmp.text();
					    	   System.out.println("localisation de l'ip "+localisation);
					    	   break;
					       }
					       case 1:{
					    	   reputation=tmp.text();
					    	   System.out.println("reputation de l'ip "+reputation);
					    	   break;
					        }
					       case 2:{
					    	   anonymous=tmp.text();
					    	   System.out.println("anonymat "+anonymous);
					    	   break;
					        }
					       case 3:{
					    	   usage=tmp.text();
					    	   System.out.println("usage l'ip "+usage);
					    	   break;
					       }
					       case 4:{
					    	   source=tmp.text();
					    	   System.out.println("source de l'ip "+source);
					    	   break;
					       }
					       case 5:{
					    	   hostName =tmp.text();
					    	   System.out.println("nom hote de l'ip "+hostName);
					    	   break;
					       }
					    }
						i++;
				}
				data.setLocalisation(localisation)
				.setReputation(reputation)
				.setAnonymat(anonymous)
				.setUsage(usage)
				.setSource(source)
				.setNomHote(hostName);
			}
			
		//}
		
		cd.quit();
		return data;
	}
	
}
