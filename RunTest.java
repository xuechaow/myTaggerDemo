import java.net.URL;

/**
 * Test suit for PageTagger
 * @author xuechao
 * @version 1.0
 *
 */

public class RunTest {
	/**
	 * Immutable after initialization
	 * accessed by useTagger
	 */
	private PageTagger tagger;
	
	public RunTest(PageTagger input){
		this.tagger = input;
	}
	
	public RunTest(){
		this.tagger = new PageTagger();
	}
	
	public PageTagger useTagger(){
		return this.tagger;
	}
	
	public void run(){
		this.tagTextTest("Hello My Name is Xuechao. I am from USC, and I love coding and cooking");
		this.getTextTest();
	}

	/**
	 * test basic tag functions
	 * @param input
	 */
	public void tagTextTest(String input){
		System.out.println(this.tagger.tagText(input));
		System.out.println("tagText test finished!");
	}
		
	public void getTextTest(){
		testURL("http://gumgum.com/");
		testURL("http://www.popcrunch.com/jimmy­kimmel­engaged/");
		testURL("http://gumgum­public.s3.amazonaws.com/numbers.html");
		testURL("http://www.windingroad.com/articles/reviews/quick­drive­2012­bmw­z4­sdrive28i/");
		testURL("http://www.google.com");
		testURL("http://www.facebook.com");
	}
	
	/**
	 * Test one individual URL.
	 * @param input String of the URL to be tagged
	 * @exception report error when failing to connect to the website URL navigated. Probably UserAgent wrong or no referrer. Or website has blocked crawlers
	 */
	public void testURL(String input){
		try{
			System.out.println(input);
			System.out.println(this.tagger.tagText(this.tagger.getText(new URL(input))));
		} catch (Exception e){
			System.err.println("Cannot connect to "+input);
		}
	}
}
