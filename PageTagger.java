/**
* <h1>PageTagger</h1>
* The PageTagger Class is a demo class to show how MaxentTagger tags a string.
*
* @author  Xuechao Wu
* @version 1.0
* @since   2016-08-21
*/
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;

public class PageTagger {
	/**
	 * contains an instance of edu.stanford.nlp.tagger.maxent.MaxentTagger​
	 */
	MaxentTagger tagger;
	
	/**
	 * initialized with a english­left3words­distsim.tagger model​
	 */
	public PageTagger(){
		this.tagger = new MaxentTagger("english-left3words-distsim.tagger");
	}
	
	/**
	 * initialize with specified model
	 * @param s the path of the file to be initialized with
	 */
	public PageTagger(String s){
		this.tagger = new MaxentTagger(s);
	}
	
	/**
	 * Takes a String as input and returns thetagged text, another String, as output. 
	 * Internally the method should use the tagString method of MaxentTagger to tag the String.
	 * @param input the string to be tagged
	 * @return tagged string
	 */
	public String tagText(String input){
		return tagger.tagString(input);
	}
	
	/**
	 * Takes a java.net.URL as input and returns a String containing all the text in the body of a web page excluding HTML tags and JavaScript.
	 * @param input the URL where we parse the html file
	 * @return parsed String
	 * @throws Exception might be HttpException. That happens when a valid webpage blocks jsoup requests.
	 */
	public String getText(URL input) throws Exception {
		String EdgeAgent = new String("Mozilla");
		//userAgent and referrer are for getting the correct version of data.
		//can be retrieved from http://www.useragentstring.com/
		//toString() calls toExternalFrom()
		return Jsoup.connect(input.toString()).userAgent(EdgeAgent).referrer("http://www.google.com").get().body().text(); //pay attention to body!
			
	}
	
	/**
	 * Takes an html string and parse it.
	 * @param input string containing html
	 * @return parsed body text
	 * @throws IOException
	 */
	public String getText(String input) throws IOException{
		return Jsoup.parse(input).body().text();
	}
	
	/**
	 * Main method that takes a URL and return the tagged String
	 * @param arg URL to be parsed and tagged
	 * @return tagged String
	 * @throws Exception
	 */
	public static String main(URL arg) throws Exception{
		PageTagger myTagger = new PageTagger(); 
		return myTagger.tagText(myTagger.getText(arg)); 
	}
	
	public static void main(String[] args){
		RunTest test = new RunTest(new PageTagger());
		test.run();
	}
}
